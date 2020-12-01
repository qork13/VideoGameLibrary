package VGL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import VGL.model.Game;
import VGL.repository.GameRepository;

@Controller
public class WebController {
	@Autowired
	GameRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllGames(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewGame(model);
		}
		
		model.addAttribute("games",repo.findAll(Sort.by(Sort.Direction.ASC, "platform")));
		return "results";
	}
	
	@GetMapping("/inputGame")
	public String addNewGame(Model model) {
		Game g = new Game();
		model.addAttribute("newGame",g);
		return "input";
	}
	
	@GetMapping({"/customerView"})
	public String customerView(Model customer, @Param(value = "checkedOut") boolean checkedOut) {
		
		if(repo.findAll().isEmpty()) {
			return addNewGame(customer);
		}
		
		customer.addAttribute("games", repo.findByAvailability(checkedOut));
		return "customerView";
	}
	
	@PostMapping("/inputGame")
	public String addNewGame(@ModelAttribute Game g, Model model) {
		repo.save(g);
		return viewAllGames(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateGame(@PathVariable("id") long id, Model model) {
		Game g = repo.findById(id).orElse(null);
		model.addAttribute("newGame",g);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseGame(Game g, Model model) {
		repo.save(g);
		return viewAllGames(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Game g = repo.findById(id).orElse(null);
		repo.delete(g);
		return viewAllGames(model);
	}
	
	@GetMapping("/checkedOut/{id}")
	public String rentGame(@PathVariable("id") long id, Model model) {
		Game g = repo.findById(id).orElse(null);
		g.setCheckedOut(true);
		repo.save(g);
		return viewAllGames(model);
	}


	
	@GetMapping("/checkedOutView")
	public String checkedOutGame(Model rented, @Param(value = "checkedOut") boolean checkedOut) {
		if(repo.findAll().isEmpty()) {
			return addNewGame(rented);
		}
		
		rented.addAttribute("games",repo.findByCheckedOut(checkedOut));
		return "checkedOutView";
	}

}
