package com.test.backend.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.test.backend.model.Produto;
import com.test.backend.model.Exception.ResourceNotFoundException;


@Repository
public class ProdutoRepositoryold {
    
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId= 0;

    /**
     * Metodo para retornar uma lista de produto
     * @return Retorna uma lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id Produto  que sera localizado
     * @return Retorna o produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == (id))
                .findFirst();
        
    }

    /**
     * Metodo para adicionar um produto a lista.
     * @param produto que sera adicionado.
     * @return Retorna o produto que foi adicionado.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo para deletar um produto por Id.
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == (id));
    }

    /**
     * Metodo par atualizar o produto na lista
     * @param produto que sera atualizado
     * @return Retorna o produtop após atualizar a lista.
     */
    public Produto atualizar(Produto produto) {

        // Aqui eu tenho que verificar se o produto existe
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto nao encontrado");
        }
        // Eu tenho que remover o produto antigo da lista
        deletar(produto.getId());

        // E adicionar o produto novo
        produtos.add(produto);

        return produto;

    }

}
