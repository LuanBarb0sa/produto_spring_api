package com.api.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repository.ProdutoRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	// Ações
	@Autowired
	private ProdutoRepository acoes;

	// Início
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll();
	}

	// Cadastrar produtos
	@RequestMapping(value = "produtos", method = RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}

	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo);
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.PUT)
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}

	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {

		RespostaModelo resposta = new RespostaModelo();

		try {

			ProdutoModelo produto = filtrar(codigo);
			this.acoes.delete(produto);
			resposta.setMensagem("Produto removido com sucesso!");
		} catch (Exception e) {
			resposta.setMensagem("Falha na exclusão do produto.");
		}

		return resposta;
	}
}
