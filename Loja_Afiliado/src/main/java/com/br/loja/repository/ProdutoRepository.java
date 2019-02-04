/**
 * 
 */
package com.br.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.loja.entity.Produto;

/**
 * @author Eduardo
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
