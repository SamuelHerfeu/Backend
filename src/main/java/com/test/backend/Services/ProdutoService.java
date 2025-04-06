package com.test.backend.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.test.backend.Repository.ProdutoRepository;
import com.test.backend.model.Produto;
import com.test.backend.model.Exception.ResourceNotFoundException;
import com.test.backend.shared.ProdutoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterTodos(){
        List<Produto> produtos = produtoRepository.obterTodos();
        ModelMapper mapper = new ModelMapper();

        return produtos.stream()
                .map(produto -> mapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> obterPorId(Integer id){
        Optional<Produto> produto = produtoRepository.obterPorId(id);

        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id: " + id + " não encontrado");
        }

        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }

    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
        produtoDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        
        produto = produtoRepository.adicionar(produto);
        produtoDto.setId(produto.getId());

        return produtoDto;
    }

    public void deletar(Integer id) {
        Optional<Produto> produto = produtoRepository.obterPorId(id);

        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar o produto com o id: " + id + " - Produto não existe");
        }

        produtoRepository.deletar(id);
    }

    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        
        produtoRepository.atualizar(produto);
        return produtoDto;
    }
}