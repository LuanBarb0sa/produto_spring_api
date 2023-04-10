package com.api.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;

public interface ProdutoRepository extends CrudRepository<ProdutoModelo, Integer> {
	
	// Listar todos os produtos
	List<ProdutoModelo> findAll();
	
	// Find by ID
	ProdutoModelo findByCodigo(int codigo);
	
	// Remover produto
	void delete(ProdutoModelo produto);
	
	// Cadastrar/Alterar produto
	//ProdutoModelo save(ProdutoModelo produto);
	<ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);
	
}
