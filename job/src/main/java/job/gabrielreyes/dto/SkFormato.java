package job.gabrielreyes.dto;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Request para obtener clientes")
public class SkFormato{
    public String beneficio;

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
}