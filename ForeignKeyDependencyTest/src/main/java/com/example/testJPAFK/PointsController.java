package com.example.testJPAFK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PointsController {

	@Autowired
	PointsInterface pointsRepo;

	@Autowired
	UserInterface userRepo;

	@PostMapping("/savePoint/{userId}")
	public Points savePoint(@PathVariable int userId , @RequestBody Points point)
	{
		User user = userRepo.getById(userId);
		if(user == null) return new Points();
		point.setUser(user);
		return pointsRepo.save(point);
	}

}
