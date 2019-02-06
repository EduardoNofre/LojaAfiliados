package com.br.loja.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.loja.dao.ProdutoDao;
import com.br.loja.entity.Produto;
import com.br.loja.repository.ProdutoRepository;

@Component
public class ProdutoDaoImpl implements ProdutoDao {

	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public Produto cadastroProduto(Produto produto) {

		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listaProduto() {
		
		return produtoRepository.findAll();
	}

	@Override
	public void salvarCelulaAlterada(Produto produto) {

		produtoRepository.save(produto);
	}
}
