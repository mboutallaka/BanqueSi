package net.boutallaka.metier;

import java.util.List;

import net.boutallaka.entities.Employe;

public interface EmployeMetier {
	
	public Employe saveEmploye(Employe e);
	public List<Employe> listEmploye();
	

}
