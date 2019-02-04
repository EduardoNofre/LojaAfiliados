/**
 * 
 */
package com.br.loja.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.loja.entity.Produto;
import com.br.loja.service.ProdutoService;
import com.br.loja.util.BasicBBean;

/**
 * @author Eduardo
 *
 */

@Controller
@ManagedBean
@SessionScoped
public class ProdutoView extends BasicBBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoService produtoService;
	
	public Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void cadastroProduto() {

	}
}
