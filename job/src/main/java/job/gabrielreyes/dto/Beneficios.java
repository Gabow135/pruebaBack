package job.gabrielreyes.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Obtener Beneficios")
public class Beneficios { 
	public String beneficio;

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
}