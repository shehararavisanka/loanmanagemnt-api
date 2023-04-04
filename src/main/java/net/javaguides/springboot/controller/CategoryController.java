package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Brands;
import net.javaguides.springboot.model.Category;
import net.javaguides.springboot.repository.BrandsRepository;
import net.javaguides.springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {


    @Autowired
    private CategoryRepository caterepo;

    @GetMapping
    public List<Category> getAllCategories(){
        return caterepo.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Category createBrands(@RequestBody Category cate){
        return caterepo.save(cate);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Category> getEmployeeById(@PathVariable long id){
        Category cat = caterepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(cat);
    }

    //build update employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Category> updateEmployee(@PathVariable long id,@RequestBody Category catdetails){
        Category brnd =  caterepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        brnd.setCategoryname(catdetails.getCategoryname());
        brnd.setProductname(catdetails.getProductname());

        caterepo.save(brnd);

        return ResponseEntity.ok(brnd);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteEmployee(@PathVariable long id){
        Category brnd = caterepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        caterepo.delete(brnd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
