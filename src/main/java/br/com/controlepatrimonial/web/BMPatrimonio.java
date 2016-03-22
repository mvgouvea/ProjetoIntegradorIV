package br.com.controlepatrimonial.web;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.controlepatrimonial.DAO.PatrimonioDAO;
import br.com.controlepatrimonial.calculos.ControlaCalculos;
import br.com.controlepatrimonial.calculos.Depreciacao;
import br.com.controlepatrimonial.modelo.Patrimonio;

@ManagedBean(name = "patrimonio")
@SessionScoped
public class BMPatrimonio implements Serializable {

	private static final long serialVersionUID = 1L;
	private Patrimonio patrimonio = new Patrimonio();
	private PatrimonioDAO pDAO;
	private boolean codigoEditavel = true;
	private Depreciacao d;

	public String btnBaixa() {
		return "formBaixa";
	}
	public String actionGeraMemoria(){
		return "memoriaDeCalculo";
	}
	public String btnDeprecia() {
		ControlaCalculos c = new ControlaCalculos();
		LocalDate ldt = LocalDate.now();
		patrimonio.setDataBaixa(Date.valueOf(ldt));
		d = new Depreciacao();
		d = c.deprecia(patrimonio);
		return "formDepreciacao";
	}

	public String actionBaixa() {
		ControlaCalculos c = new ControlaCalculos();
		d = new Depreciacao();
		d = c.deprecia(patrimonio);
		return "resultadoBaixa";
	}

	public String actionConfirmar() {
		pDAO.gravaBaixa(patrimonio, d);
		return "listaPatrimonio";
	}

	public String actionNovo() {
		setCodigoEditavel(false);
		patrimonio = new Patrimonio();
		return "formCadastraPatrimonio";
	}

	public String actionGrava() {
		pDAO = new PatrimonioDAO();
		if (pDAO.busca(patrimonio) != null) {
			pDAO.altera(patrimonio);
		} else {
			pDAO.grava(patrimonio);
		}
		return "listaPatrimonio";
	}

	public String actionDeleta() {
		pDAO = new PatrimonioDAO();
		pDAO.deleta(patrimonio);
		return "listaPatrimonio";
	}

	public String actionAltera() {
		pDAO = new PatrimonioDAO();
		setCodigoEditavel(true);
		pDAO.altera(patrimonio);
		return "formCadastraPatrimonio";
	}

	public String actionBusca() {
		return "";
	}

	public List<Patrimonio> getBuscaTodos() {
		pDAO = new PatrimonioDAO();
		return pDAO.buscaTodos();
	}

	public Patrimonio getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}
	public Depreciacao getD() {
		return d;
	}

	public void setD(Depreciacao d) {
		this.d = d;
	}
	public boolean isCodigoEditavel() {
		return codigoEditavel;
	}

	public void setCodigoEditavel(boolean codigoEditavel) {
		this.codigoEditavel = codigoEditavel;
	}
}
