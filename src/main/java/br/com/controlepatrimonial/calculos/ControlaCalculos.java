package br.com.controlepatrimonial.calculos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import br.com.controlepatrimonial.DAO.TipoBaixaDAO;
import br.com.controlepatrimonial.DAO.TipoPatrimonioDAO;
import br.com.controlepatrimonial.modelo.Patrimonio;
import br.com.controlepatrimonial.modelo.TipoBaixa;
import br.com.controlepatrimonial.modelo.TipoPatrimonio;

public class ControlaCalculos {
	TipoPatrimonioDAO tpDAO;
	TipoPatrimonio tp;
	Depreciacao d;
	ControlaCalculos c;

	public Depreciacao deprecia(Patrimonio patrimonio) {
		d = new Depreciacao();
		c = new ControlaCalculos();

		d.setValorPatrimonio(patrimonio.getValorCompra());
		if (patrimonio.getValorResidual() != 0) {
			d.setValorPatrimonio(patrimonio.getValorCompra()
					- patrimonio.getValorResidual());
		}
		d.setPeriodo(c.getPeriodo(patrimonio));
		d.setVU(c.getVidaRestante(patrimonio));
		d.setTaxa((float) c.getTaxa(d.getVU(), patrimonio));
		d.setDA((d.getValorPatrimonio() * d.getTaxa() * (float) d.getPeriodo()) / 12);
		if (d.getDA() > patrimonio.getValorCompra()) {
			d.setDA(patrimonio.getValorCompra() - patrimonio.getValorResidual());
			d.setVC(patrimonio.getValorResidual());
		}
		d.setVC(patrimonio.getValorCompra() - d.getDA());
		if (patrimonio.getTipoBaixa() != null) {
			if (c.getCalculaGP(patrimonio) == true) {
				if (patrimonio.getValorBaixa() >= d.getVC()) {
					d.setGanho(patrimonio.getValorBaixa() - d.getVC());
				} else {
					d.setPerda(patrimonio.getValorBaixa() - d.getVC());
				}
			}
		}
		return d;
	}

	private boolean getCalculaGP(Patrimonio patrimonio) {
		TipoBaixa tb = new TipoBaixa();
		TipoBaixaDAO tbDAO = new TipoBaixaDAO();
		tb.setCodigo(patrimonio.getTipoBaixa());
		tb = tbDAO.busca(tb);
		if (tb.isCalculaGP() == true) {
			return true;
		} else {
			return false;
		}
	}

	private double getTaxa(float VR, Patrimonio patrimonio) {
		double taxa = 0;
		switch (patrimonio.getTurnoTrabalho()) {
		case 1:
			taxa = ((double) 100 / (double) VR) / (double) 100;
			return taxa;
		case 2:
			taxa = (((double) 100 / (double) VR ) * (double) 1.5) / (double) 100;
			return taxa;
		case 3:
			taxa = (((double) 100 / (double) VR ) * 2) / (double) 100;
			return taxa;
		}
		return taxa;
	}

	private int getPeriodo(Patrimonio patrimonio) {
		int m = 0;
		patrimonio.setDataCompra(new java.util.Date(patrimonio.getDataCompra()
				.getTime()));
		patrimonio.setDataBaixa(new java.util.Date(patrimonio.getDataBaixa()
				.getTime()));
		Instant inicioI = patrimonio.getDataCompra().toInstant();
		Instant fimI = patrimonio.getDataBaixa().toInstant();
		LocalDate inicio = inicioI.atZone(ZoneId.systemDefault()).toLocalDate();

		if (inicio.getDayOfMonth() > 15) {
			inicio.plusMonths(1);
		}
		LocalDate fim = fimI.atZone(ZoneId.systemDefault()).toLocalDate();
		if (fim.getDayOfMonth() < 15) {
			fim.plusMonths(-1);
		}
		Period p = Period.between(inicio, fim);
		if (p.getYears() != 0) {
			m = p.getYears() * 12;
		}
		if (p.getMonths() != 0) {
			m = m + p.getMonths();
		}
		return m;
	}

	private float getVidaRestante(Patrimonio patrimonio) {
		tp = new TipoPatrimonio();
		tpDAO = new TipoPatrimonioDAO();
		tp.setCodigo(patrimonio.getTipoPatrimonio());
		tp = tpDAO.busca(tp);
		
		float VU = 0, v = (float) tp.getVidaUtil();
		if (patrimonio.getAnosUso() >= v) {
			VU = tp.getVidaUtil() / 2;
		} else {
			VU = v - patrimonio.getAnosUso();
		}
		return VU;
	}

}
