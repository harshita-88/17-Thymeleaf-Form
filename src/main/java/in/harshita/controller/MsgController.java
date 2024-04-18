package in.harshita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.harshita.entity.Product;
import in.harshita.repository.ProductRepository;

@Controller
public class MsgController {
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam("id")Integer id,Model model) {
		Optional<Product> p = repo.findById(id);
		if(p.isPresent()) {
			Product product = p.get();
			model.addAttribute("product", product);
			
		}
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id")Integer id,Model model) {
		repo.deleteById(id);
		model.addAttribute("msg","Field Deleted");
		model.addAttribute("products",repo.findAll());
		return"data";
	}
	
	@GetMapping("/products")
	public String getDetails(Model model) {
		List<Product> list = repo.findAll();
		model.addAttribute("products",list);	
		return "data";
	}
	
	@GetMapping("/")
	public String formFill(Model model) {
		model.addAttribute("p",new Product());	
		return "index";
	}
	
	@PostMapping("/product")
	public String saveData(@Validated @ModelAttribute("p") Product p,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "index";
		}
		p = repo.save(p);
		if(p.getId() != null) {
			model.addAttribute("msg", "data saved");
		}
		return "index";
	}
}
