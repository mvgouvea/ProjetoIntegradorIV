package br.com.controlepatrimonial.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.controlepatrimonial.modelo.TipoPatrimonio;
import br.com.controlepatrimonial.util.ConnectionFactory;

public class TipoPatrimonioDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	Connection conexao = null;
	PreparedStatement ps = null;

	public void grava(TipoPatrimonio tp){
		String sql = "INSERT INTO tipo_patrimonio "
				+ "(codigo, descricao, vida_util) "
				+ "VALUES (?, ?, ?)";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tp.getCodigo());
			ps.setString(2, tp.getDescricao());
			ps.setInt(3, tp.getVidaUtil());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no grava() TipoPatrimonioDAO");
			e.printStackTrace();
		}finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public void altera(TipoPatrimonio tb){
		String sql = "UPDATE tipo_patrimonio SET descricao = ?, vida_util = ?"
				+ " WHERE codigo = ?";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getDescricao());
			ps.setInt(2, tb.getVidaUtil());
			ps.setString(3, tb.getCodigo());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no altera() TipoPatrimonioDAO");
			e.printStackTrace();
		} finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public void deleta(TipoPatrimonio tb){
		String sql = "DELETE FROM tipo_patrimonio WHERE codigo = ?";
		
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, tb.getCodigo());
			ps.executeUpdate();
		}catch(Exception e){
			System.err.println("Erro no altera() TipoPatrimonioDAO");
			e.printStackTrace();
		} finally{
			ConnectionFactory.fechar(conexao, ps);
		}
	}
	public TipoPatrimonio busca(TipoPatrimonio t){
		ResultSet rs = null;
		String sql = "SELECT * FROM tipo_patrimonio WHERE codigo = ?";
		TipoPatrimonio p = null;
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, t.getCodigo());
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new TipoPatrimonio();
				p.setCodigo(rs.getString("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setVidaUtil(rs.getInt("vida_util"));
			}
		} catch (Exception e) {
			System.err.println("Erro no busca() TipoPatrimonioDAO");
			e.printStackTrace();
		} finally {
			ConnectionFactory.fechar(conexao, ps, rs);
		}
		return p;
	}
	public List<TipoPatrimonio> buscaTodos(){
		
		ResultSet rs = null;
		String sql = "SELECT codigo, descricao, vida_util "
				+ "FROM tipo_patrimonio;";
		List<TipoPatrimonio> lsTipoPatrimonio = null;
		try {
			conexao = ConnectionFactory.getConexao();
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			lsTipoPatrimonio = new ArrayList<TipoPatrimonio>();
			while (rs.next()){
				TipoPatrimonio p = new TipoPatrimonio();
				p.setCodigo(rs.getString("codigo"));
				p.setVidaUtil(rs.getInt("vida_util"));
				p.setDescricao(rs.getString("descricao"));
				lsTipoPatrimonio.add(p);
			}
		}catch(Exception e){
			System.err.println("Erro no buscaTodos TipoBaixaDAO");
			e.printStackTrace();
		}finally{
			ConnectionFactory.fechar(conexao, ps, rs);
		}
		return lsTipoPatrimonio;
	}
}
