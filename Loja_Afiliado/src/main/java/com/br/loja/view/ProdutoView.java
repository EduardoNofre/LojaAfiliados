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
import com.br.loja.util.Constantes;

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
	
	private Produto selecionadoProduto;

	public Produto produto = new Produto();

	public void cadastroProduto() {

		produtoService.cadastroProdutoService(produto);

		FacesContext.getCurrentInstance().addMessage("messagems1",new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso.", null));

		produto = new Produto();
	}

	public String listarProduto() {

		produtos = produtoService.listaProdutoService();
		
		return Constantes.ALTERARDESATIVARPRODUTO;
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

	public Produto getSelecionadoProduto() {
		return selecionadoProduto;
	}

	public void setSelecionadoProduto(Produto selecionadoProduto) {
		this.selecionadoProduto = selecionadoProduto;
	}

}
