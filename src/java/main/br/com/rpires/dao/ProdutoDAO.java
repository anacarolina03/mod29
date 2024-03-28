package br.com.rpires.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rpires.dao.jdbc.ConnectionFactory;
import br.com.rpires.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_produto (nome,quantidade) values (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidade());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }

    }

    @Override
    public Produto consultar(int codigo) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_produto WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setNome(rs.getString("nome"));
                return produto;
            }
            return produto;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection con =  null;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "DELETE FROM tb_produto WHERE nome = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            return ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            if(con != null && !con.isClosed()){
                con.close();
            }if (ps != null && !ps.isClosed()){
                ps.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection con  =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try{
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_produto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            return produtos;

        }catch (Exception e){
            throw e;
        }finally {
            if (con != null && !con.isClosed()){
                con.close();
            }if (rs != null && !rs.isClosed()){
                rs.close();
            }if (ps != null && !ps.isClosed()){
                ps.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_produto SET nome = ?, quantidade = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setInt(2,produto.getQuantidade());
            return ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            if (con != null && !con.isClosed()){
                con.close();
            }if (ps != null && !ps.isClosed()){
                ps.close();
            }
        }
    }
}
