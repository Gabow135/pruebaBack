package job.gabrielreyes.service;

import java.util.List;

import job.gabrielreyes.dto.ResultBeneficio;
import job.gabrielreyes.model.Beneficio;

public interface IBeneficioService {
	Beneficio modificar(Beneficio ben);
	List<ResultBeneficio> consultaBeneficio();
	Beneficio datosBeneficio(String beneficio, String lista);
}
