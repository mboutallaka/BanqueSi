package net.boutallaka.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import net.boutallaka.entities.Compte;
import net.boutallaka.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
//	@Query(" select o from Operation o where o.compte.codeCompte=:x")
//	public Page<Operation> getOperation(@Param("x") String code ,Pageable pageable);

	

	public Page<Operation> findByCompte(Compte cp, Pageable pageable);

}
