package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipes;
import com.coderscampus.assignment9.service.RecipeService;

@RestController
public class RecipeController {
	
	 private final RecipeService recipeService;

	    @Autowired
	    public RecipeController(RecipeService recipeService) {
	        this.recipeService = recipeService;
	    }
	    
	    @GetMapping("/gluten-free")
	    public List<Recipes> getGlutenFreeRecipes () throws IOException {
	    	 return recipeService.getGlutenFreeRecipes();
	    	
	    }
	    
	    @GetMapping("/vegan")
	    public List<Recipes> getVeganRecipes () throws IOException {
	    	return recipeService.getVeganRecipes();
	    }
	    
	    @GetMapping("/vegan-gluten-free")
	    public List<Recipes> getVeganAndGlutenFreeRecipes() throws IOException {
	    	return recipeService.getVeganAndGlutenFreeRecipes();
	    }
	    
	    @GetMapping("/vegetarian")
	    public List<Recipes> getVegetarianRecipes() throws IOException {
	    	return recipeService.getVegetarianRecipes();
	    }
	    
	    
	    
	    @GetMapping("/")
	    public List<Recipes> getAllRecipes () throws IOException {
	    	return recipeService.getAllRecipes();
	    }
	    
	    

}
