package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.object.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

}
