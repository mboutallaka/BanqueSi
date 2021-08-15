package net.boutallaka.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;



@Entity
@DiscriminatorValue("CC")
@Data
@XmlType(name = "CC")
public class CompteCourant extends Compte {
	

	private double decouvert;
	
	
	
	public CompteCourant() {
		super();
	}
	

	public CompteCourant(String codeCompte, Date dateDeCreation, double solde, double decouvert) {
		super(codeCompte, dateDeCreation, solde);
		this.decouvert = decouvert;
	}

	
	

}
