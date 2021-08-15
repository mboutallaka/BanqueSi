package net.boutallaka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import net.boutallaka.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
	

}
