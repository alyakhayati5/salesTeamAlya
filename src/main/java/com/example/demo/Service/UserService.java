package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AppUser;
import com.example.demo.Repository.appUserRepository;


@Service
@Transactional
public class UserService {
	private final appUserRepository repo;

    @Autowired
	public UserService(appUserRepository repo) {
		super();
		this.repo = repo;
	}
    public AppUser addUser(AppUser user) {
              return repo.save(user);
    }

    public List<AppUser> findAllAppUsers() {
        return repo.findAll();
    }
	
    public AppUser updateAppUser(AppUser user) {
        return repo.save(user);
    }
    public AppUser findUserByIdUser(Integer idUser) {
    	return repo.findUserByIdUser(idUser)
                .orElseThrow(() -> new com.example.demo.Exception.UserNotFoundException("User by id " + idUser + " was not found"));
    }

    public Long count() {

        return repo.count();
    }

    public void deleteUser(Integer idUser){
        repo.deleteUserByIdUser(idUser);
    }
	

}
