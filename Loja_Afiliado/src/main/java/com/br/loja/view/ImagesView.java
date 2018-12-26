/**
 * 
 */
package com.br.loja.view;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Controller;

/**
 * @author eduardo.sa
 *
 */

@Controller
@ManagedBean
@SessionScoped
public class ImagesView {

	private List<StreamedContent> images;

	@PostConstruct
	public void init() throws FileNotFoundException {

		ByteArrayOutputStream outFile = null;
		
		images = new ArrayList<StreamedContent>();

		File f = new File("C:\\img_TIFF\\");

		for (File file : f.listFiles()) {

			outFile = this.getBytes(file);
			
			InputStream is = new ByteArrayInputStream(outFile.toByteArray());

			images.add(new DefaultStreamedContent(is));
		}
	}

	public List<StreamedContent> getImages() {

		return images;
	}

	public ByteArrayOutputStream getBytes(File file) {

		ByteArrayOutputStream out = null;

		InputStream in = null;

		try {

			in = new BufferedInputStream(new FileInputStream(file));

			out = new ByteArrayOutputStream((int) file.length());

			byte[] buffer = new byte[4096];

			int len = 0;

			while ((len = in.read(buffer, 0, buffer.length)) != -1) {

				out.write(buffer, 0, len);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				if (out != null) {
					out.close();
				}

				if (in != null) {
					in.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return out;

	}
}
