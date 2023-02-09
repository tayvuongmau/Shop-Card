package assignment.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.DAO.CartDAO;
import assignment.DAO.ProductsDAO;
import assignment.dto.Cart;
import assignment.entities.Bills;
import assignment.entities.CustomUserDetails;
import assignment.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductsDAO productsDAO;

	@RequestMapping("/BuyProduct")
	public String buyProduct(HttpServletRequest request ,
							HttpSession session ,
							@RequestParam(required = false, name = "product_id")String id, Model model) {
		Integer product_id = Integer.parseInt(id);
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Integer, Cart>();
		}
//		thay vì dùng 6 dòng này viết gọn thành 3 dòng dưới		
//		cart = cartService.addCart(product_id, cart);
//		Integer totalQuanty = cartService.totalQuanty(cart);
//		Integer totalPrice = cartService.totalPrice(cart);
//		session.setAttribute("cart", cart);
//		session.setAttribute("totalQuanty", totalQuanty);
//		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("cart", cartService.addCart(product_id, cart));
		session.setAttribute("totalQuanty", cartService.totalQuanty(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("/MyCart")
	public String myCart(HttpSession session, Model model) {
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
		Integer totalMoney = cartService.totalPrice(cart);
		session.setAttribute("money", totalMoney);
		model.addAttribute("totalMoney", totalMoney);
		model.addAttribute("items", cart);
		return "/template/web/mycart";
	}
	
	@RequestMapping("/EditCart")
	public String editCart(@RequestParam(required = false, name = "process")String process,
							@RequestParam(required = false, name = "product_id")String product_id,
							HttpServletRequest request,
							HttpSession session, Model model) {
		String num = process.trim();
		Integer quanty = Integer.parseInt(num);
		Integer id = Integer.parseInt(product_id);
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
		
		if((quanty == -1) &&  cart.get(id).getQuantity() <= 1){
			cart.remove(id);
		}else {
			session.setAttribute("cart", cartService.editCart(id, quanty, cart));
			session.setAttribute("totalQuanty", cartService.totalQuanty(cart));
			session.setAttribute("totalPrice", cartService.totalPrice(cart));
		}
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("/DeleteCart")
	public String deleteCart(@RequestParam(required = false, name = "product_id")String product_id,
							HttpServletRequest request,
							HttpSession session, Model model) {
		Integer id = Integer.parseInt(product_id);
		HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
		cartService.deleteCart(id, cart);
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("/CheckOut")
	public String checkOut(HttpServletRequest request, HttpSession session, Authentication authentication, Model model) {
		Bills bills = new Bills();
		CustomUserDetails user = (CustomUserDetails) model.getAttribute("account");
		if(user == null) {
			model.addAttribute("NeedLogin", "Bạn cần đăng nhập để có thể thanh toán!");
		}
		return "/template/web/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
