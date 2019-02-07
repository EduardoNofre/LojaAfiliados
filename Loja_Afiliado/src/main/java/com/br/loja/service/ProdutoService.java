/**
 * 
 */
package com.br.loja.service;

import java.util.List;

import com.br.loja.entity.Produto;

/**
 * @author Eduardo
 *
 */
public interface ProdutoService {

	public Produto cadastroProdutoService(Produto produto);

	public List<Produto> listaProdutoService();

	public void salvarCelulaAlteradaService(Produto produto);

	public void excluirCelulaService(Produto produto);

}
