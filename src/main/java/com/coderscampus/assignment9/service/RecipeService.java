package com.coderscampus.assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;


import com.coderscampus.assignment9.domain.Recipes;

@Service
public class RecipeService {

	public List<Recipes> getAllRecipes() throws IOException {
	    List<Recipes> recipes = new ArrayList<>();

	    try (Reader reader = new FileReader("recipes.txt")) {
	        @SuppressWarnings("deprecation")
			Iterable<CSVRecord> records =  CSVFormat.DEFAULT.withDelimiter(',').withEscape('\\').withFirstRecordAsHeader().withIgnoreSurroundingSpaces().parse(reader);

	        for (CSVRecord record : records) {
	            Recipes recipe = new Recipes();
	            recipe.setCookingMinutes(Integer.parseInt(record.get(0).trim()));
	            recipe.setDairyFree(Boolean.parseBoolean(record.get(1).trim()));
	            recipe.setGlutenFree(Boolean.parseBoolean(record.get(2).trim()));
	            recipe.setInstructions(record.get(3).trim());
	            recipe.setPreparationMinutes(Double.parseDouble(record.get(4).trim()));
	            recipe.setPricePerServing(Double.parseDouble(record.get(5).trim()));
	            recipe.setReadyInMinutes(Integer.parseInt(record.get(6).trim()));
	            recipe.setServings(Integer.parseInt(record.get(7).trim()));
	            recipe.setSpoonacularScore(Double.parseDouble(record.get(8).trim()));
	            recipe.setTitle(record.get(9).trim());
	            recipe.setVegan(Boolean.parseBoolean(record.get(10).trim()));
	            recipe.setVegetarian(Boolean.parseBoolean(record.get(11).trim()));

	            recipes.add(recipe);
	        }
	    }

	    return recipes;
	}

	    
	
	public List<Recipes> getGlutenFreeRecipes() throws IOException {
		return getAllRecipes().stream().filter(Recipes::getGlutenFree).collect(Collectors.toList());
	}

}
