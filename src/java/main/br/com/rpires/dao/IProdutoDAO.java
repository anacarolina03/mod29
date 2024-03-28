package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.domain.Produto;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;
    
    public Produto consultar(int codigo) throws Exception;
    
    public Integer excluir(Produto produto) throws Exception;
    
    public List<Produto> buscarTodos() throws Exception;
    
    public Integer atualizar(Produto produto) throws Exception;
}
