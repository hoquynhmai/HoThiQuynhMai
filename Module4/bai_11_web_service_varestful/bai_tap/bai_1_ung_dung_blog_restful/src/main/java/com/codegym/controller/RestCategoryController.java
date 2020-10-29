package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class RestCategoryController {
    @Autowired
    private CategoryService categoryService;

    //-------------------Retrieve All Category--------------------------------------------------------

    @RequestMapping(value = "/rest/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> category = categoryService.findAll();
        if (category.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }

//    //-------------------Retrieve Single Category--------------------------------------------------------
//
//    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
//        System.out.println("Fetching Customer with id " + id);
//        Category category = categoryService.findById(id);
//        if (category == null) {
//            System.out.println("Category with id " + id + " not found");
//            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Category>(category, HttpStatus.OK);
//    }
//
//    //-------------------Create a Category--------------------------------------------------------
//
//    @RequestMapping(value = "/rest/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Category " + category.getName());
//        categoryService.save(category);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/rest/{id}").buildAndExpand(category.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    //------------------- Update a Category --------------------------------------------------------
//
//    @RequestMapping(value = "/rest/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
//        System.out.println("Updating Category " + id);
//
//        Category currentCategory = categoryService.findById(id);
//
//        if (currentCategory == null) {
//            System.out.println("Category with id " + id + " not found");
//            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
//        }
//
//        currentCategory.setId(category.getId());
//        currentCategory.setName(category.getName());
//
//        categoryService.save(currentCategory);
//        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
//    }
//
//    //------------------- Delete a Category --------------------------------------------------------
//
//    @RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id) {
//        System.out.println("Fetching & Deleting Category with id " + id);
//
//        Category category = categoryService.findById(id);
//        if (category == null) {
//            System.out.println("Unable to delete. Category with id " + id + " not found");
//            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
//        }
//
//        categoryService.delete(id);
//        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
//    }
}
