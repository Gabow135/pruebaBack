package job.gabrielreyes.dto;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Request para insertar clientes")
public class BeneficioDTO {
	public ArrayList<SkFormato> sk_formato;
}