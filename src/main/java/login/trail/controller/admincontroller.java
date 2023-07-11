package login.trail.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.criteria.Path;

import login.trail.model.Category;
import login.trail.model.UserModel;
import login.trail.model.books;
import login.trail.service.BooksService;
import login.trail.service.CategoryService;

@Controller
public class admincontroller {
	@Autowired
	CategoryService categoryservice;
	@Autowired
	BooksService bookservice;

	@GetMapping("/admin")
    public String adminPage(Model model) {
        
        System.out.println("admin page");
		
        return "adminhome";
    }
	@GetMapping("/admin/categories")
    public String getadmincategories(Model model) {
        
//        System.out.println("admin page");
//		System.out.println("Categoty page");
//	    System.out.println(categoryservice.getAllCategory().get(0).getId());
		
		model.addAttribute("category",categoryservice.getAllCategory());
        return "categories";
    
    }
	@GetMapping("/admin/categories/add")
	public String getadmincategoriesadd(Model model) {
	    model.addAttribute("category", new Category());
	    
//	    System.out.println(categoryservice.getAllCategory());
	    return "categoriesAdd";
	}
	@PostMapping("/admin/categories/add")
    public String postadmincategoriesadd(@ModelAttribute("category") Category category) {
        
//        System.out.println("admin page");
//		System.out.println(categoryservice.getAllCategory().get(0).getId());
		categoryservice.addcategory(category);
        return "redirect:/admin/categories";
    
    }
	
	@GetMapping("/admin/categories/delete/{id}")
	public String getadmincategoriesdel(@PathVariable("id") int id ) {
	   
	    
	    categoryservice.deletecategorybyId(id);
//	    System.out.println(categoryservice.getAllCategory());
	    return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String getadmincategoriesupdate(@PathVariable int id ,Model model ) {
	   
	    
	    java.util.Optional<Category> category =categoryservice.getCategoryById(id);
	    if(category.isPresent()) {
	    	model.addAttribute("category",category.get());
	    	return "categoriesAdd";
	    }
	    else
	    {
//	    System.out.println(categoryservice.getAllCategory());
	    return "error";
	    }
	}
	
	//product Section

	@GetMapping("/admin/products")
	public String getadminproducts ( Model model) {
	   
//		System.out.println(bookservice.getAllbooks().get(0).getImageData());

		 System.out.println("products");
	    model.addAttribute("allbooks",bookservice.getAllbooks());
	    return "products";
	}
	@GetMapping("/admin/products/add")
	public String getadminproductsadd ( Model model) {
	   
	    model.addAttribute("allbooks", new books());
	    model.addAttribute("categories",categoryservice.getAllCategory());
	    return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String postadminproductsadd (@ModelAttribute("allbooks") books book, @RequestParam("bookimage") MultipartFile file ) throws IOException {
		if (!file.isEmpty()) {
          book.setImage(file.getOriginalFilename());
          String imagePath = "classpath:/static/images/" + file.getOriginalFilename();
          ClassPathResource resource = new ClassPathResource("static/images/");
          File savedFile = new File(resource.getFile(), file.getOriginalFilename());
          Files.copy(file.getInputStream(), savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
		bookservice.save(book);
		
	    return "redirect:/admin/products";
	}

	  @GetMapping("/admin/products/delete/{id}")
	    public String deleteProduct(@PathVariable("id") int id) {
//		  System.out.println(id);
	        bookservice.deletebook(id);
	        return "redirect:/admin/products";
	    }
	  @GetMapping("/admin/products/update/{id}")
	    public String updateProduct(@PathVariable("id") int id,Model model) {
//		  System.out.println(id);
	      
            books book=bookservice.getproductById(id).get();
           
            
            
    	  model.addAttribute("allbooks",book);

	   	    model.addAttribute("categories",categoryservice.getAllCategory());
		    	return "productsAdd";
	    	   
	      
	    }
}
