package net.boutallaka.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.boutallaka.entities.Employe;
import net.boutallaka.repositories.EmployeRepository;


@Service
public class EmployeMetierImp implements EmployeMetier {
     @Autowired
	 private EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
