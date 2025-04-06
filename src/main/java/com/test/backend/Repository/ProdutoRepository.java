package com.test.backend.Repository;

import com.test.backend.model.Produto;
import java.util.List;
import java.util.Optional;



//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;



@Repository
public interface ProdutoRepository {

    List<Produto> obterTodos();

    Optional<Produto> obterPorId(Integer id);

    Produto adicionar(Produto produto);

    void deletar(Integer id);

    Produto atualizar(Produto produto);

}

