package net.boutallaka.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.boutallaka.entities.Compte;
import net.boutallaka.entities.Employe;
import net.boutallaka.entities.Operation;
import net.boutallaka.entities.Retrait;
import net.boutallaka.entities.Versement;
import net.boutallaka.repositories.CompteRepository;
import net.boutallaka.repositories.EmployeRepository;
import net.boutallaka.repositories.OperationRepository;

@Service
public class OperationMetierImp implements OperationMetier{
	@Autowired
	private OperationRepository  operationRepository;
    @Autowired
	private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.getOne(code);
		Employe e =employeRepository.getOne(codeEmp);
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.getOne(code);
		Employe e =employeRepository.getOne(codeEmp);
		Operation o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}
	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		retirer(cpte1 ,montant,codeEmp);
		verser(cpte2 ,montant ,codeEmp);
		return true;
	}

	@Override
	@Transactional
	public PageOperation getOperations(String codeCompte, int page, int size) {
	   Compte cp =compteRepository.getOne(codeCompte) ;
	   Pageable pageable = null;
	Page<Operation>  op1=operationRepository.findByCompte(cp, pageable);
	PageOperation pOp=new PageOperation();
	pOp.setOperations(op1.getContent());
	pOp.setNombreOperations(op1.getNumberOfElements());
	pOp.setPages(op1.getNumber());
	pOp.setTotalOperations(op1.getTotalPages());
	pOp.setTotalOperations((int)op1.getTotalElements());
	return pOp;
	}

	

}
