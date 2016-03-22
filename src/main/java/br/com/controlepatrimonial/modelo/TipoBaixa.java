package br.com.controlepatrimonial.modelo;

import java.util.Date;

public class TipoBaixa {
	private String codigo, descricao;
	private Date dataCadastro;
	private boolean calculaGP;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isCalculaGP() {
		return calculaGP;
	}
	public void setCalculaGP(boolean calculaGP) {
		this.calculaGP = calculaGP;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
