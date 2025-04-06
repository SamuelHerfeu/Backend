package com.test.backend.Repository;

import com.test.backend.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository { // Implementa a interface

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Produto> obterTodos() {
        String sql = "SELECT * FROM produtos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Produto.class));
    }

    @Override
    public Optional<Produto> obterPorId(Integer id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            Produto produto = jdbcTemplate.queryForObject(
                sql, 
                new BeanPropertyRowMapper<>(Produto.class), 
                id
            );
            return Optional.ofNullable(produto);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Produto adicionar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, valor, observacao) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            produto.getNome(),
            produto.getDescricao(),
            produto.getValor(),
            produto.getObservacao());
        return produto;
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Produto atualizar(Produto produto) {
       // String sql = "UPDATE produtos SET nome = ?, descricao = ?, valor = ?, observacao = ? WHERE id = ?";
        //jdbcTemplate.update(sql,
            //produto.getNome(),
            //produto.getDescricao(),
           // produto.getValor(),
            //produto.getObservacao(),
           // produto.getId());
       // return produto;

       jdbcTemplate.update(
        "INSERT INTO produtos (nome, quantidade, descricao, valor, observacao) VALUES (?, ?, ?, ?, ?)",
        produto.getNome(),
        produto.getQuantidade(),
        produto.getDescricao(), // novo campo
        produto.getValor(),
        produto.getObservacao()
    );
    return produto;
    }
}