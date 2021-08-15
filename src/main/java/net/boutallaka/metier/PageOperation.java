package net.boutallaka.metier;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.boutallaka.entities.Operation;


@Data
@AllArgsConstructor @NoArgsConstructor
public class PageOperation implements Serializable {

	private List<Operation> operations;
	private int pages;
	private int nombreOperations;
	private int totalOperations;
	private int totalPages;
	
	
	
}
