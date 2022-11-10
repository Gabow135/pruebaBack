package job.gabrielreyes.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.gabrielreyes.dto.ResultBeneficio;
import job.gabrielreyes.model.Beneficio;
import job.gabrielreyes.repo.BeneficioRepo;
import job.gabrielreyes.service.IBeneficioService;

@Service
public class BeneficioServiceImpl implements IBeneficioService {
	
	@Autowired private BeneficioRepo repoBeneficio;
	
	@Override
	public Beneficio modificar(Beneficio ben) {
		return repoBeneficio.save(ben);
	}
	
	@Override
	public List<ResultBeneficio> consultaBeneficio() {
		ResultBeneficio result;
		List<ResultBeneficio> listaBeneficio = new ArrayList<ResultBeneficio>();
		List<Object[]> listaObj = repoBeneficio.consultaBeneficios();
		if (listaObj.isEmpty() || listaObj == null) {
			return null;
		} else {
			for (Object[] obj : listaObj) {
				result = new ResultBeneficio();
				result.setBeneficio(obj[1] == null ? null :(obj[1].toString()));
				result.setEstado(obj[2] == null ? null :(Integer.parseInt(obj[2].toString())));
				result.setLista(obj[3] == null ? null :(obj[3].toString()));
				listaBeneficio.add(result);
			}
			return listaBeneficio;
		}
	}
	
	@Override
	public Beneficio datosBeneficio(String beneficio, String lista) {
		Beneficio result = new Beneficio();
		List<Object[]> listaObj = repoBeneficio.datosBeneficio(beneficio, lista);
		if (listaObj.isEmpty() || listaObj == null) {
			return null;
		} else {
			for (Object[] obj : listaObj) {
				result.setIdBeneficio(obj[0] == null ? null : (Long.parseLong(obj[0].toString())));
				result.setBeneficio(obj[1] == null ? null :(obj[1].toString()));
				result.setEstado(obj[2] == null ? null :(Integer.parseInt(obj[2].toString())));
				result.setLista(obj[3] == null ? null :(obj[3].toString()));
			}
			return result;
		}
	}
}
