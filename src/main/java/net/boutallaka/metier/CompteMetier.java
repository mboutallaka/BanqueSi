package net.boutallaka.metier;






import net.boutallaka.entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);
}
