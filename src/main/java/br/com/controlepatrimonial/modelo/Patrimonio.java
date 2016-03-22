package br.com.controlepatrimonial.modelo;

import java.util.Date;

public class Patrimonio {
	private int turnoTrabalho;
	private String descricao, codigo, condicao, tipoPatrimonio, tipoBaixa, st_patrimonio;
	private Date dataCompra, dataBaixa;
	private float valorCompra, valorBaixa, anosUso, valorResidual;
	//condição será adotado como u = usado n = novo

	public int getTurnoTrabalho() {
		return turnoTrabalho;
	}
	public void setTurnoTrabalho(int turnoTrabalho) {
		this.turnoTrabalho = turnoTrabalho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	public float getValorBaixa() {
		return valorBaixa;
	}
	public void setValorBaixa(float valorBaixa) {
		this.valorBaixa = valorBaixa;
	}
	public float getAnosUso() {
		return anosUso;
	}
	public void setAnosUso(float anosUso) {
		this.anosUso = anosUso;
	}
	public float getValorResidual() {
		return valorResidual;
	}
	public void setValorResidual(float valorResidual) {
		this.valorResidual = valorResidual;
	}
	public String getTipoPatrimonio() {
		return tipoPatrimonio;
	}
	public void setTipoPatrimonio(String tipoPatrimonio) {
		this.tipoPatrimonio = tipoPatrimonio;
	}
	public Date getDataBaixa() {
		return dataBaixa;
	}
	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCondicao() {
		return condicao;
	}
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	public String getTipoBaixa() {
		return tipoBaixa;
	}
	public void setTipoBaixa(String tipoBaixa) {
		this.tipoBaixa = tipoBaixa;
	}
	public String getSt_patrimonio() {
		return st_patrimonio;
	}
	public void setSt_patrimonio(String st_patrimonio) {
		this.st_patrimonio = st_patrimonio;
	}
}
