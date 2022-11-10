package job.gabrielreyes.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.gabrielreyes.dto.ResultCliente;
import job.gabrielreyes.model.Cliente;
import job.gabrielreyes.repo.ClienteRepo;
import job.gabrielreyes.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired private ClienteRepo repoCliente;
	
	@Override
	public Cliente modificar(Cliente cli) {
		return repoCliente.save(cli);
	}
	
	@Override
	public List<ResultCliente> consultaClientes() {
		ResultCliente result;
		List<ResultCliente> listaCliente = new ArrayList<ResultCliente>();
		List<Object[]> listaObj = repoCliente.consultaClientes();
		if (listaObj.isEmpty() || listaObj == null) {
			return null;
		} else {
			for (Object[] obj : listaObj) {
				result = new ResultCliente();
				result.setLista(obj[4] == null ? null :(obj[4].toString()));
				result.setBeneficio(obj[3] == null ? null :(obj[3].toString()));
				result.setMail(obj[1] == null ? null :(obj[1].toString()));
				result.setNombre(obj[0] == null ? null :(obj[0].toString()));
				result.setTelefono(obj[2] == null ? null :(obj[2].toString()));
				listaCliente.add(result);
			}
			return listaCliente;
		}
	}
}
