package net.boutallaka.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;


@Entity
@DiscriminatorValue("CE")
@Data
@XmlType(name = "CE")
public class CompteEpargne extends Compte{
	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, Date dateDeCreation, double solde, double taux) {
		super(codeCompte, dateDeCreation, solde);
		this.taux = taux;
	}



}
