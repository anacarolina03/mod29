package br.com.rpires;

import org.junit.Assert;
import org.junit.Test;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.dao.ProdutoDAO;
import br.com.rpires.domain.Produto;

public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception{
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setQuantidade(12);
        produto.setNome("Chocolate Nestlé");
        Integer cadastrar = dao.cadastrar(produto);
        Assert.assertTrue(1 == cadastrar);
        
        dao.excluir(produto);
  
    }
}

