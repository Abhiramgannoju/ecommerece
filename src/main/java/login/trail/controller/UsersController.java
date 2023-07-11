package login.trail.controller;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import login.trail.model.UserModel;
import login.trail.model.books;
import login.trail.service.BooksService;
import login.trail.service.CategoryService;
//import login.trail.service.UsersService;

@Controller
public class UsersController {

//	@Autowired
//	private UsersService userservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	BooksService bookservice;
	
	 @GetMapping("/")
	    public String home(Model model) {
//	        User user = new User();
//	        model.addAttribute("user", user);
		  System.out.println("home");
	        return "index";
	    }
//	public UsersController(UsersService userservice)
//	{
//		this.userservice=userservice;
//	}
//	  @GetMapping("/login")
//	    public String loginUser(Model model) {
////	        User user = new User();
//	        model.addAttribute("loginrequest", new UserModel());
//		  System.out.println("login");
//	        return "login";
//	    }
//	 
//	@GetMapping("/register")
//	public String getRegisterPage(Model model)
//	{
//		model.addAttribute("registerRequest", new UserModel());
//		System.out.println("registered page");
//		return "register";
//	}
//	@PostMapping("/register")
//	public String register(@ModelAttribute UserModel usermodel)
//
//	{
//		System.out.println("register request"+ usermodel);	
//		UserModel registerduser=userservice.registerUser(usermodel.getLogin(), usermodel.getPassword(), usermodel.getEmail());
//		if(registerduser==null)
//		{
//			return "error";
//		}
//		else
//		{
//			return "redirect:/login";
//		}
//  }
//	@PostMapping("/login")
//	public String login(@ModelAttribute UserModel usermodel,Model model)
//
//	{
//		System.out.println("register request"+ usermodel);	
//		UserModel authnicate=userservice.authicate(usermodel.getLogin(), usermodel.getPassword(), usermodel.getEmail());
//		if(authnicate==null)
//		{
//			return "error";
//		}
//		else
//		{
//			model.addAttribute("userLogin",authnicate.getLogin());
//			return "personal";
//        }
//  }
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("categories",categoryservice.getAllCategory());
		model.addAttribute("allbooks",bookservice.getAllbooks());
		return "shop";
	}
	@GetMapping("/shop/category/{id}")
	public String shopcategory(Model model, @PathVariable("id") int id)
	{
		model.addAttribute("categories",categoryservice.getAllCategory());
		model.addAttribute("allbooks",bookservice.getAllproductsById(id));
		return "shop";
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewproduct(Model model, @PathVariable("id") int id)
	{
		
		model.addAttribute("categories",categoryservice.getAllCategory());
		java.util.Optional<books> optionalBook = bookservice.getproductById(id);
		 if (optionalBook.isPresent()) {
		        books book = optionalBook.get();
		        model.addAttribute("product", book);
		    } 
		return "viewproduct";
	}
	
	
}
