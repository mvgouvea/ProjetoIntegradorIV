package br.com.controlepatrimonial.calculos;


public class Depreciacao {
	private float taxa, valorPatrimonio, DA, VC, ganho, perda, VU;
	private int periodo;
	
	public float getTaxa() {
		return taxa;
	}
	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	public float getValorPatrimonio() {
		return valorPatrimonio;
	}
	public void setValorPatrimonio(float valorPatrimonio) {
		this.valorPatrimonio = valorPatrimonio;
	}
	public float getDA() {
		return DA;
	}
	public void setDA(float dA) {
		DA = dA;
	}
	public float getVC() {
		return VC;
	}
	public void setVC(float vC) {
		VC = vC;
	}
	public float getGanho() {
		return ganho;
	}
	public void setGanho(float ganho) {
		this.ganho = ganho;
	}
	public float getPerda() {
		return perda;
	}
	public void setPerda(float perda) {
		this.perda = perda;
	}
	public float getVU() {
		return VU;
	}
	public void setVU(float vU) {
		VU = vU;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
