package com.example.demo.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Client;

public interface clientRepository extends JpaRepository<Client, Integer> {

	 Optional<Client> findClientByIdClient(Integer idClient);
	 
}
