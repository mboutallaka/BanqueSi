package net.boutallaka.rmi;

import java.rmi.RemoteException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.boutallaka.entities.Compte;
import net.boutallaka.metier.CompteMetier;
import net.boutallaka.metier.OperationMetier;
@Component("MyRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote {
    @Autowired
	private CompteMetier compteMetier;
    @Autowired
	private OperationMetier operationMetier;
	@Override
	public Compte saveCompte(Compte cp) throws RemoteException {
		// TODO Auto-generated method stub
		return  compteMetier.saveCompte(cp);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.getCompte(code);
	}

	@Override
	public boolean verser(String code, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.verser(code, montant, codeEmp);
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmpl) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.retirer(code, montant, codeEmpl);
	}

	@Override
	public boolean virement(String cpte1, String cpte2, double Montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.virement(cpte1, cpte2, Montant, codeEmp);
	}

}
