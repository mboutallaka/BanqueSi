package net.boutallaka.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.boutallaka.entities.Compte;
import net.boutallaka.repositories.CompteRepository;

@Service
public class CompteMetierImp implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		cp.setDateDeCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		return compteRepository.getOne(code);
		
	}
	


}
