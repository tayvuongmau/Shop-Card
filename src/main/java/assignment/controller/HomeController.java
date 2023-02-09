package assignment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.DAO.ProductsDAO;
import assignment.DAO.UserDAO;
import assignment.entities.CustomUserDetails;
import assignment.entities.Products;
import assignment.entities.User;
import assignment.service.UserService;


@Controller
public class HomeController {
	@Autowired
	ProductsDAO productsDAO;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDAO userDAO;
	
	//Hàm xử lí dữ liệu kiểu Date vì kiểu Date không tự động mapping qua được
	@InitBinder
	public void initBinder(WebDataBinder data){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(sf, true)); 
		//true ở đây là cho phép empty, false thì ngược lại
		//Date.class phải add thư viện java.util
		}
	
	@RequestMapping(value = {"/","/home"})
	public String home(@RequestParam(required=false,name="page")String Page ,Model model) {
		
		if(Page == null) {
			Page = "1";
		}
		Integer indexPage = Integer.parseInt(Page);
		int endPage = 0;
		Integer totalProduct = null;
		totalProduct = productsDAO.getTotalProduct();
		endPage = totalProduct/3;
			if(totalProduct % 3 != 0) {
				endPage++ ;
			}
		List<Products> list = productsDAO.getProductsByPage(indexPage);
		model.addAttribute("list", list);
		model.addAttribute("endPage", endPage);
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String err,
						@RequestParam(value = "accessDenied", required = false)String accessDenied,
						Model model) {
		if(err != null) {
			model.addAttribute("err", "Sai tài khoản hoặc mật khẩu !");
		}else if (accessDenied != null) {
			model.addAttribute("accessDenied", "Tài khoản của bạn không có quyền truy cập địa chỉ này!");
		}
		return "template/web/login";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "redirect:/login?accessDenied";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		return "template/web/login";
	}
	
	@RequestMapping(value = "/signin")
	public String signin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "template/web/signin";
	}
	
	@RequestMapping("/CreateUser")
	public String createUser(@Valid @ModelAttribute("user")User user, BindingResult result, Model model) {
		boolean create = userService.insertUser(user);
		boolean exists = userService.exists(user.getUserName());
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "template/web/signin";
		}else {
			if(exists) {
				model.addAttribute("user", user);
				model.addAttribute("exists", "Tài khoản đã tồn tại");
				return "template/web/signin";
			}else {
				if(create) {
					model.addAttribute("create", "Đăng kí thành công");
				}
				return "template/web/signin";
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
