package net.boutallaka.metier;

import java.util.List;

import net.boutallaka.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List<Client> listClient();

}
