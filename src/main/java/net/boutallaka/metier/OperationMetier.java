package net.boutallaka.metier;

public interface OperationMetier {
	
	public boolean verser(String code, double montant ,Long codeEmp);
	public boolean retirer(String code, double montant ,Long codeEmpl);
	public boolean virement(String cpte1 ,String cpte2 ,double Montant ,Long codeEmpl);
	public PageOperation getOperations(String codeCompte ,int page ,int size);
	

}
