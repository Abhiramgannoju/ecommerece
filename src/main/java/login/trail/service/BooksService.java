package login.trail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import login.trail.model.books;
import login.trail.repo.BooksRepo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

@Service
public class BooksService {

	@Autowired
	 private BooksRepo bookrepo;
	
	public List<books> getAllbooks()
	{
		return bookrepo.findAll();
	}

    public void deletebook(int id)
    {
    	bookrepo.deleteById(id);
    }
    public Optional<books> getproductById(int id)
    {
    	return bookrepo.findById(id);
    }
    public List<books>getAllproductsById(int id)
    {
    	return bookrepo.findAllBycategory_id(id);
    }

	public void save(books book) {
		bookrepo.save(book);
		
	}

	
   

}
