package com.br.loja.dao;

import java.util.List;

import com.br.loja.entity.Produto;

public interface ProdutoDao {

	public Produto cadastroProduto(Produto produto);

	public List<Produto> listaProduto();
}
