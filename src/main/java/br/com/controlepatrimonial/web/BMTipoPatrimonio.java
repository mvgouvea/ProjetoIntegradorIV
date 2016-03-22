package br.com.controlepatrimonial.web;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.controlepatrimonial.DAO.TipoPatrimonioDAO;
import br.com.controlepatrimonial.modelo.TipoPatrimonio;

@ManagedBean(name="tipoPatrimonio")
@SessionScoped
public class BMTipoPatrimonio implements Serializable {

	private static final long serialVersionUID = 1L;
	private TipoPatrimonio tipoPatrimonio = new TipoPatrimonio();
	private TipoPatrimonioDAO tpDAO;
	private boolean codigoEditavel;
	
	public String actionNovo(){
		codigoEditavel = false;
		tipoPatrimonio = new TipoPatrimonio();
		return "formCadastraTiposPatrimonio";
	}
	public String actionGrava(){
		tpDAO = new TipoPatrimonioDAO();
		if (tpDAO.busca(tipoPatrimonio) != null){
			tpDAO.altera(tipoPatrimonio);
		} else {
			tpDAO.grava(tipoPatrimonio);
		}
		return "listaTiposPatrimonio";
	}
	public String actionDeleta(){
		tpDAO = new TipoPatrimonioDAO();
		tpDAO.deleta(tipoPatrimonio);
		return "listaTiposPatrimonio";
	}
	public String actionAltera(){
		tpDAO = new TipoPatrimonioDAO();
		codigoEditavel = true;
		tpDAO.altera(tipoPatrimonio);
		return "formCadastraTiposPatrimonio";
	}
	public String actionBusca(){
		return "";
	}
	public List<TipoPatrimonio> getBuscaTodos(){
		tpDAO = new TipoPatrimonioDAO();
		return tpDAO.buscaTodos();
	}

	
	public TipoPatrimonio getTipoPatrimonio() {
		return tipoPatrimonio;
	}
	public void setTipoPatrimonio(TipoPatrimonio tipoPatrimonio) {
		this.tipoPatrimonio = tipoPatrimonio;
	}
	public boolean isCodigoEditavel() {
		return codigoEditavel;
	}
	public void setCodigoEditavel(boolean codigoEditavel) {
		this.codigoEditavel = codigoEditavel;
	}
}
