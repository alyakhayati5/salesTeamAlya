package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.example.demo.Model.AppUser;


public interface appUserRepository extends JpaRepository<AppUser,Integer> {
	 void deleteUserByIdUser(Integer idUser);

	 Optional<AppUser> findUserByIdUser(Integer idUser);
}
