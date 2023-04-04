package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private usersRepository usersrepo;

    @GetMapping
    public List<Users> getAllEmployees(){
        return usersrepo.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Users createUser(@RequestBody Users usr){
        return usersrepo.save(usr);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable long id){
        Users usr = usersrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(usr);
    }

    @PostMapping("/byemail")
    public ResponseEntity<Users> findByEmail(@RequestBody Users usrdet){
        Users usr = usersrepo.findByEmail(usrdet.getEmail()).orElse(null) ;
        return ResponseEntity.ok(usr);
    }





    //build update employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Users> updateEmployee(@PathVariable long id,@RequestBody Users usrdet){
        Users usr =  usersrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        usr.setFullname(usrdet.getFullname());
        usr.setDateofbirth(usrdet.getDateofbirth());
        usr.setUsedamount(usrdet.getUsedamount());
        usr.setLoanbalance(usrdet.getLoanbalance());
        usr.setInstallments(usrdet.getInstallments());
        usersrepo.save(usr);

        return ResponseEntity.ok(usr);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Users> deleteEmployee(@PathVariable long id){
        Users usr = usersrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        usersrepo.delete(usr);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
