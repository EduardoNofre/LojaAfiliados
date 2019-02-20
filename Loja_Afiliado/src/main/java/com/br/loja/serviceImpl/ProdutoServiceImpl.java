package com.br.loja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.loja.dao.ProdutoDao;
import com.br.loja.entity.Produto;
import com.br.loja.service.ProdutoService;
import com.br.loja.util.BasicBBean;

@Service
public class ProdutoServiceImpl extends BasicBBean implements ProdutoService {

	@Autowired
	ProdutoDao produtoDao;

	private static final long serialVersionUID = 1L;

	@Override
	public Produto cadastroProdutoService(Produto produto) {

		return produtoDao.cadastroProdutoDao(produto);
	}

	@Override
	public List<Produto> listaProdutoService() {

		return produtoDao.listaProdutoDao();
	}

	@Override
	public void salvarCelulaAlteradaService(Produto produto) {

		produtoDao.salvarCelulaAlteradaDao(produto);

	}

	@Override
	public void excluirCelulaService(Produto produto) {

		produtoDao.excluirCelulaADao(produto);

	}
}
