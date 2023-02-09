package assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.DAO.ProductsDAO;
import assignment.entities.Products;

@Controller
public class ProductsController {
	
	@Autowired
	ProductsDAO productsDAO;
	
	@RequestMapping(value = {"/streng"})
	public String getProductsByStreng(Model model) {
		String streng = "Hero Streng";
		List<Products> list = productsDAO.getProductsByStreng(streng);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value = {"/agility"})
	public String getProductsByAgility(Model model) {
		String agility = "Hero Agility";
		List<Products> list = productsDAO.getProductsByStreng(agility);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value = {"/intelligent"})
	public String getProductsByIntelligent(Model model) {
		String intelligent = "Hero Intelligent";
		List<Products> list = productsDAO.getProductsByStreng(intelligent);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value = {"/detail"})
	public String detail(@RequestParam(required = false, name = "detailProduct")String detailProduct, Model model) {
		Integer detail = Integer.parseInt(detailProduct);
		Products products = productsDAO.getProductById(detail);
		model.addAttribute("e", products);
		return "/template/web/detailproduct";
	}
	
	@RequestMapping(value = {"/search"})
	public String searchProductsByName(@RequestParam("productName")String name ,Model model) {
		List<Products> list = productsDAO.searchProductsByName(name);
		model.addAttribute("list", list);
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
