package com.example.testJPAFK;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserInterface extends JpaRepository<User, Integer>{

}
