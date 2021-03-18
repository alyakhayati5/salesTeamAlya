package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
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

import com.example.demo.Model.AppUser;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/user")
public class AppUserController {
	private final UserService service;

	public AppUserController(UserService service) {
		super();
		this.service = service;
	}

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> users = service.findAllAppUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/users/count")
    public Long count() {

        return service.count();
    }
    

    @GetMapping("/find/{idUser}")
    public ResponseEntity<AppUser> getUserById (@PathVariable("idUser") Integer idUser) {
    	AppUser user = service.findUserByIdUser(idUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
    	user.setDeleted(0);
    	user.setDeletedBy(user.getIdUser());

    	user.setDeletedAt(LocalDate.now());  
    	AppUser newuser = service.addUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user) {
    	AppUser updateUser = service.updateAppUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable("idUser") Integer idUser) {
        service.deleteUser(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
