package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Brands;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.BrandsRepository;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/brands")
public class BrandsController {


    @Autowired
    private BrandsRepository brandsrepo;

    @GetMapping
    public List<Brands> getAllEmployees(){
        return brandsrepo.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Brands createBrands(@RequestBody Brands brnd){
        return brandsrepo.save(brnd);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Brands> getEmployeeById(@PathVariable long id){
        Brands employee = brandsrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Brands> updateEmployee(@PathVariable long id,@RequestBody Brands branddetails){
        Brands updateBrands =  brandsrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateBrands.setBrandname(branddetails.getBrandname());
        updateBrands.setCategoryname(branddetails.getCategoryname());
        updateBrands.setProductname(branddetails.getProductname());

        brandsrepo.save(updateBrands);

        return ResponseEntity.ok(updateBrands);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Brands> deleteEmployee(@PathVariable long id){
        Brands brnd = brandsrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        brandsrepo.delete(brnd);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
