/**
 * 
 */
package com.br.loja.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Controller;

import com.br.loja.util.Util;

/**
 * @author eduardo.sa
 *
 */

@Controller
@ManagedBean
@SessionScoped
public class ImagesView {

	private List<StreamedContent> imagesPrincipalProdutos = null;

	public List<StreamedContent> getImagesPrincipalProdutos() {
		
		imagesPrincipalProdutos = Util.loadImagemGalleria();

		return imagesPrincipalProdutos;
	}

	public void setImagesPrincipalProdutos(List<StreamedContent> imagesPrincipalProdutos) {
		this.imagesPrincipalProdutos = imagesPrincipalProdutos;
	}

}
