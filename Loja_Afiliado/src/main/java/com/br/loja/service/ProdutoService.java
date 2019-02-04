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

}
