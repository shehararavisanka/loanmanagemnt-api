package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Category;
import net.javaguides.springboot.model.Inventory;
import net.javaguides.springboot.repository.CategoryRepository;
import net.javaguides.springboot.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {




    @Autowired
    private InventoryRepository inrepo;

    @GetMapping
    public List<Inventory> getAllCategories(){
        return inrepo.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Inventory createBrands(@RequestBody Inventory cate){
        return inrepo.save(cate);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Inventory> getEmployeeById(@PathVariable long id){
        Inventory cat = inrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(cat);
    }

    //build update employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Inventory> updateEmployee(@PathVariable long id,@RequestBody Inventory catdetails){
        Inventory brnd =  inrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        brnd.setCategoryname(catdetails.getCategoryname());
        brnd.setProductname(catdetails.getProductname());

        inrepo.save(brnd);

        return ResponseEntity.ok(brnd);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Inventory> deleteEmployee(@PathVariable long id){
        Inventory brnd = inrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        inrepo.delete(brnd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
