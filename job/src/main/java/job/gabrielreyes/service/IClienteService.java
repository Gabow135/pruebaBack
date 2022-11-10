package job.gabrielreyes.service;

import java.util.List;

import job.gabrielreyes.dto.ResultCliente;
import job.gabrielreyes.model.Cliente;

public interface IClienteService {
	Cliente modificar(Cliente cli);
	List<ResultCliente> consultaClientes();
}
