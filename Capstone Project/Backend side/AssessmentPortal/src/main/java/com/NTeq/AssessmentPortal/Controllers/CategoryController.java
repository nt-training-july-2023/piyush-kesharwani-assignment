package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryService;
	
	@PostMapping("/addCategory")
	public String saveCategory(@RequestBody Category cg) {
		return categoryService.addCategory(cg);
	}
	
	@GetMapping("/getCategory/{id}")
	public ResponseEntity<Category>getEmp(@PathVariable("id") long id){
		Category cg = categoryService.getCategoryById(id);
		if(cg==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(cg));
	}
	
	@GetMapping("/all")
	public List<Category> getAll(){
		return categoryService.getAllCategory();
		
	}
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<Category>updateCategory(@PathVariable("id") Long id, @RequestBody Category cg){
    	try {
			categoryService.UpdateCategory(id,cg);
			return ResponseEntity.ok().body(cg);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id){
		try {
			categoryService.deleteCategory(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
	}
}
