package net.boutallaka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.boutallaka.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
