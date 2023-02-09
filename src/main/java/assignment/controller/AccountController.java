package assignment.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.DAO.ProductsDAO;
import assignment.DAO.UserDAO;
import assignment.dto.Cart;
import assignment.entities.Bills;
import assignment.entities.CustomUserDetails;
import assignment.entities.Products;
import assignment.entities.User;
import assignment.service.BillsService;
import assignment.service.CartService;
import assignment.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	ProductsDAO productsDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	BillsService billsService;
	
	//phần controller của người dùng
	@RequestMapping("/user/home")
	public String userHome(@RequestParam(required=false,name="page")String Page ,Model model) {
		if(Page == null) {
			Page = "1";
		}
		Integer indexPage = Integer.parseInt(Page);
		Integer totalProduct = productsDAO.getTotalProduct();
		int endPage = totalProduct/3;
		if(totalProduct % 3 != 0) {
			endPage++ ;
		}
		List<Products> list = productsDAO.getProductsByPage(indexPage);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("list", list);
		model.addAttribute("endPage", endPage);
		return "home";
	}
	
	@RequestMapping("/user/streng")
	public String getProductsByStreng(Model model) {
		String streng = "Hero Streng";
		List<Products> list = productsDAO.getProductsByStreng(streng);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/user/agility")
	public String getProductsByAgility(Model model) {
		String agility = "Hero Agility";
		List<Products> list = productsDAO.getProductsByStreng(agility);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/user/intelligent")
	public String getProductsByIntelligent(Model model) {
		String intelligent = "Hero Intelligent";
		List<Products> list = productsDAO.getProductsByStreng(intelligent);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/user/detail")
	public String detail(@RequestParam(required = false, name = "detailProduct")String detailProduct, Model model) {
		Integer detail = Integer.parseInt(detailProduct);
		Products products = productsDAO.getProductById(detail);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("e", products);
		return "/template/web/detailproduct";
	}
	
	@RequestMapping("/user/search")
	public String searchProductsByName(@RequestParam("productName")String name ,Model model) {
		List<Products> list = productsDAO.searchProductsByName(name);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/user/MyCart")
	public String myCart(HttpSession session, Model model) {
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
		Integer totalMoney = cartService.totalPrice(cart);
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("money", totalMoney);
		model.addAttribute("account", user);
		model.addAttribute("totalMoney", totalMoney);
		model.addAttribute("items", cart);
		return "/template/web/mycart";
	}
	
	@RequestMapping("/user/CheckOut")
	public String checkOut(HttpServletRequest request, HttpSession session, Authentication authentication,@ModelAttribute("bills")Bills bills , Model model) {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", user);
		HashMap<Integer, Cart> c = (HashMap<Integer, Cart>) session.getAttribute("cart");
		int size = c.size();
		Integer money = (Integer) session.getAttribute("money");
		if(user != null) {
			bills.setUsername(user.getUsername());
			bills.setTelephone(user.getTelephone());
			bills.setBills_quanty(size);
			bills.setBills_total(money);
		}else {
			model.addAttribute("NeedLogin", "Bạn cần đăng nhập để có thể thanh toán!");
			return "/template/web/login";
		}
		model.addAttribute("bills", bills);
		return "/template/web/checkout";
	}
	
	@RequestMapping("/user/Pay")
	public String pay(HttpServletRequest request, HttpSession session, @ModelAttribute("bills")Bills bills, Model model) {
		
		HashMap<Integer, Cart> c = (HashMap<Integer, Cart>) session.getAttribute("cart");
		int totalQuanty = cartService.totalQuanty(c);
		double totalPrice = cartService.totalPrice(c);
		bills.setBills_quanty(totalQuanty);
		bills.setBills_total(totalPrice);
		if(billsService.addBills(bills)) {
			billsService.addBillsDetail(c);
		}
		session.removeAttribute("cart");
		return "redirect:/user/home";
	}
	
	
	
	
	//phần controller của admin
	@RequestMapping("/admin")
	public String adminHome(Model model) {
		return "/template/admin/admin";
	}
	
	@RequestMapping("/admin/account")
	public String getAllUser(@RequestParam(required = false, name = "page")String Page ,Model model) {
		if(Page == null) {
			Page = "1";
		}
		Integer indexPage = Integer.parseInt(Page);
		int endPage = 0;
		Integer totalUser;
		totalUser = userDAO.countTotalUser();
		endPage = totalUser/5;
		if(totalUser % 5 != 0) {
			endPage++ ;
		}
		List<User> list = userDAO.getAllUser(indexPage);
		model.addAttribute("account", list);
		model.addAttribute("endPage", endPage);
		return "/template/admin/account";
	}
	
	@RequestMapping("/admin/product")
	public String getProductsByPage(@RequestParam(required=false,name="page")String Page ,Model model) {
		if(Page == null) {
			Page = "1";
		}
		Integer indexPage = Integer.parseInt(Page);
		Integer totalProduct = productsDAO.getTotalProduct();
		int endPage = totalProduct/3;
		if(totalProduct % 3 != 0) {
			endPage++ ;
		}
		List<Products> list = productsDAO.getProductsByPage(indexPage);
		model.addAttribute("list", list);
		model.addAttribute("endPage", endPage);
		return "/template/admin/product";
	}
	
	@RequestMapping("/admin/initInsertProduct")
	public String initInsertProduct(Model model) {
		Products products = new Products();
		model.addAttribute("p", products);
		return "/template/admin/insertProduct";
	}
	
	@RequestMapping("/admin/insertProduct")
	public String insertProduct(@ModelAttribute("p")Products products, 
								@RequestParam(required = false, name = "page")String Page,
								Model model) {
		boolean bl = productsDAO.insertProduct(products);
		if(Page == null) {
			Page = "1";
		}
		Integer indexPage = Integer.parseInt(Page);
		Integer totalProduct = productsDAO.getTotalProduct();
		int endPage = totalProduct/3;
		if(totalProduct % 3 != 0) {
			endPage++ ;
		}
		List<Products> list = productsDAO.getProductsByPage(indexPage);
		model.addAttribute("list", list);
		model.addAttribute("endPage", endPage);
		return "/template/admin/product";
	}
	
	@RequestMapping("/admin/preUpdateProduct")
	public String updateProduct(@RequestParam("product_name")String product_name ,Model model) {
		Products products = productsDAO.findProductByName(product_name);
		model.addAttribute("e", products);
		return "/template/admin/updateProduct";
	}
	
	@RequestMapping("/admin/updateProduct")
	public String updateProduct(@ModelAttribute("e") Products products, Model model) {
		boolean bl = productsDAO.updateProduct(products);
		if(bl) {
			return "redirect:/admin/product";
		}else {
			model.addAttribute("Err", "Cập nhật thất bại !");
			model.addAttribute("e", products);
			return "/template/admin/updateProduct";
		}
	}
	
	@RequestMapping("/admin/deleteProduct")
	public String deleteProduct(@RequestParam("product_name")String product_name ,Model model) {
		boolean bl = productsDAO.deleteProduct(product_name);
		if(bl) {
			model.addAttribute("success", "Xoá thành công!");
			return "redirect:/admin/product";
		}else {
			model.addAttribute("err", "Xoá thất bại!");
			return "redirect:/admin/product";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
