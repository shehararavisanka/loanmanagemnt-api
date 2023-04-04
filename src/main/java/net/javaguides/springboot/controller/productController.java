package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.repository.productRepository;
import net.javaguides.springboot.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/product")
public class productController {

    @Autowired
    private productRepository prodrepo;

    @GetMapping
    public List<Product> getAllEmployees(){
        return prodrepo.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Product createUser(@RequestBody Product usr){
        return prodrepo.save(usr);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getUsersById(@PathVariable long id){
        Product usr = prodrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(usr);
    }



    //build update employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable long id,@RequestBody Product usrdet){
        Product usr =  prodrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        usr.setProductname(usrdet.getProductname());
        prodrepo.save(usr);

        return ResponseEntity.ok(usr);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteEmployee(@PathVariable long id){
        Product usr = prodrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        prodrepo.delete(usr);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
