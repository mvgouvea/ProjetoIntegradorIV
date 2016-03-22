package br.com.controlepatrimonial.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.controlepatrimonial.modelo.TipoBaixa;
import br.com.controlepatrimonial.util.ConnectionFactory;

public class TipoBaixaDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	Connection conexao = null;
	PreparedStatement ps = null;
	
	public void grava(TipoBaixa tb){
		String sql = "INSERT INTO tipo_baixa(codigo, descricao, calcula_gp, data_cadastro) "
				+ "VALUES (?, ?, ?, now())";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getCodigo());
			ps.setString(2, tb.getDescricao());
			ps.setBoolean(3, tb.isCalculaGP());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no grava() TipoBaixaDAO");
			e.printStackTrace();
		}finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public void altera(TipoBaixa tb){
		String sql = "UPDATE tipo_baixa SET descricao = ?, "
				+ "calcula_gp = ? WHERE codigo = ?;";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getDescricao());
			ps.setBoolean(2, tb.isCalculaGP());
			ps.setString(3, tb.getCodigo());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no altera() TipoBaixaDAO");
			e.printStackTrace();
		} finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public void deleta(TipoBaixa tb){
		String sql = "DELETE FROM tipo_baixa WHERE codigo = ?";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getCodigo());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no deleta() TipoBaixaDAO");
			e.printStackTrace();
		} finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public TipoBaixa busca(TipoBaixa tb){
		ResultSet rs = null;
		TipoBaixa p = null;
		String sql = "SELECT * FROM tipo_baixa WHERE codigo = ?;";
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getCodigo());
			rs = ps.executeQuery();
			while (rs.next()){
				p = new TipoBaixa();
				p.setCodigo(rs.getString("codigo"));
				p.setCalculaGP(rs.getBoolean("calcula_gp"));
				p.setDataCadastro(rs.getDate("data_cadastro"));
				p.setDescricao(rs.getString("descricao"));
			}
		}catch(Exception e){
			System.err.println("Erro no buscaTodos TipoBaixaDAO");
			e.printStackTrace();
		}finally{
			ConnectionFactory.fechar(conexao, ps, rs);
		}
		
		return p;
	}
	public List<TipoBaixa> buscaTodos(){
		ResultSet rs = null;
		String sql = "SELECT * FROM tipo_baixa;";
		List<TipoBaixa> lsTipoBaixa = null;
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			lsTipoBaixa = new ArrayList<TipoBaixa>();
			while (rs.next()){
				TipoBaixa p = new TipoBaixa();
				p.setCodigo(rs.getString("codigo"));
				p.setCalculaGP(rs.getBoolean("calcula_gp"));
				p.setDataCadastro(rs.getDate("data_cadastro"));
				p.setDescricao(rs.getString("descricao"));
				lsTipoBaixa.add(p);
			}
		}catch(Exception e){
			System.err.println("Erro no buscaTodos TipoBaixaDAO");
			e.printStackTrace();
		}finally{
			ConnectionFactory.fechar(conexao, ps, rs);
		}
		return lsTipoBaixa;
	}
}
