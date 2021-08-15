package net.boutallaka.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import lombok.Data;


@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE" ,discriminatorType = DiscriminatorType.STRING,length = 2)
@JsonTypeInfo(use =JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
	@Type(name = "CC",value =CompteCourant.class),
	@Type(name = "CE",value =CompteEpargne.class)
})
@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})
public abstract class Compte implements Serializable {
	
	@Id 
	private String codeCompte;
	private Date DateDeCreation;
	private double Solde;
	@ManyToOne
	@JoinColumn(name = "CODE_CLT")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "CODE_EMP")
	private Employe employe;
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;
	public Compte(String codeCompte, Date dateDeCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		DateDeCreation = dateDeCreation;
		Solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateDeCreation() {
		return DateDeCreation;
	}
	public void setDateDeCreation(Date dateDeCreation) {
		DateDeCreation = dateDeCreation;
	}
	public double getSolde() {
		return Solde;
	}
	public void setSolde(double solde) {
		Solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
