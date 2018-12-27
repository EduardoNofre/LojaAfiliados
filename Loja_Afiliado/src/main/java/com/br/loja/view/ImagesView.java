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

	private List<StreamedContent> imagesGaleriaProdutos = null;
	
	private List<StreamedContent> imagesDataGridProdutos = null;

	public List<StreamedContent> getImagesGaleriaProdutos() {
		
		imagesGaleriaProdutos = Util.loadImagemGalleria();

		return imagesGaleriaProdutos;
	}

	public void setImagesGaleriaProdutos(List<StreamedContent> imagesGaleriaProdutos) {
		
		this.imagesGaleriaProdutos = imagesGaleriaProdutos;
	}

	public List<StreamedContent> getImagesDataGridProdutos() {
		
		imagesDataGridProdutos = Util.loadImagemGalleria();
		
		return imagesDataGridProdutos;
	}

	public void setImagesDataGridProdutos(List<StreamedContent> imagesDataGridProdutos) {
		this.imagesDataGridProdutos = imagesDataGridProdutos;
	}
	
	

}
