package login.trail.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import login.trail.model.Category;
import login.trail.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categotyrepo;

	public CategoryRepo getCategotyrepo() {
		return categotyrepo;
	}
	public void setCategotyrepo(CategoryRepo categotyrepo) {
		this.categotyrepo = categotyrepo;
	}
	public List<Category> getAllCategory()
	{
		return categotyrepo.findAll();
	}

  
	public void addcategory(Category category) {
		// TODO Auto-generated method stub
		categotyrepo.save(category);

	}
	public void deletecategorybyId(int id)
	{
		categotyrepo.deleteById(id);
	}
	public Optional<Category> getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categotyrepo.findById(id);
	}
	
	
}
