/**
 * 
 */
package com.br.loja.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.loja.entity.Produto;
import com.br.loja.service.ProdutoService;

/**
 * @author Eduardo
 *
 */

@Controller
@ManagedBean
@SessionScoped
public class ProdutoView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoService produtoService;
	
	private List<Produto> produtos;

	public Produto produto = new Produto();

	public void cadastroProduto() {

		produtoService.cadastroProdutoService(produto);

		FacesContext.getCurrentInstance().addMessage("messagems1",new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso.", null));

		produto = new Produto();
	}

	public void listarProduto() {

		produtos = produtoService.listaProdutoService();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
