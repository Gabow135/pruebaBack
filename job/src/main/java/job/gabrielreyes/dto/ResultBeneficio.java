package job.gabrielreyes.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Request para obtener beneficios")
public class ResultBeneficio {
	private String beneficio;
	private String lista;
	private Integer estado;
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public String getLista() {
		return lista;
	}
	public void setLista(String lista) {
		this.lista = lista;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}