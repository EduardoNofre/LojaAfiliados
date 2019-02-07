package com.br.loja.dao;

import java.util.List;

import com.br.loja.entity.Produto;

public interface ProdutoDao {

	public Produto cadastroProdutoDao(Produto produto);

	public List<Produto> listaProdutoDao();

	public void salvarCelulaAlteradaDao(Produto produto);

	public void excluirCelulaADao(Produto produto);

}
