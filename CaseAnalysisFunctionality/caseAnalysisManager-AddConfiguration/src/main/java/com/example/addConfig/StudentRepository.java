package com.example.addConfig;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "select * from student st , address at\r\n" + 
			"    where st.address_id = at.id and at.street='Pimpri'",
			nativeQuery = true)
	List<Student> findDetails();
	
}
