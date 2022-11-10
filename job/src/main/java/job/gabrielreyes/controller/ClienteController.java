package job.gabrielreyes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestBody;

import job.gabrielreyes.dto.ClienteDTO;
import job.gabrielreyes.dto.ResultCliente;
import job.gabrielreyes.model.Beneficio;
import job.gabrielreyes.model.Cliente;
import job.gabrielreyes.repo.BeneficioRepo;
import job.gabrielreyes.service.IBeneficioService;
import job.gabrielreyes.service.IClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IBeneficioService beneficioService;
	
	@ApiModelProperty(notes="Guardar/Modificar Cliente")
	@PostMapping("/nuevoJSON")
	public ResponseEntity<String> saveCliente(@RequestBody ClienteDTO cli)
	{
		if (cli == null || cli.getNombre() == null || cli.getMail() == null || cli.getTelefono() == null
				|| cli.getBeneficio() == null || cli.getLista() == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("Todos los datos son obligatorios!");
		}
		
		//Validar Beneficio
		Beneficio beneficio = beneficioService.datosBeneficio(cli.getBeneficio(),cli.getLista());
		
		if (beneficio == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, el beneficiario no existe.");
		} else if (beneficio.getEstado() == 1) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, el beneficiario no esta libre.");
		} else {
			beneficio.setEstado(1);
			beneficioService.modificar(beneficio);
		}
		
		//Crear al Cliente
		Cliente cliNuevo = new Cliente();
		cliNuevo.setMail(cli.getMail());
		cliNuevo.setNombre(cli.getNombre());
		cliNuevo.setTelefono(cli.getTelefono());
		cliNuevo.setIdBeneficio(beneficio);
		
		Cliente respCliente = clienteService.modificar(cliNuevo);
		if (respCliente == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, revisar con el administrador.");
		} else {
			return ResponseEntity
		            .status(HttpStatus.OK)
		            .body("Cliente Guardado!");
		}
	}
	
	@ApiModelProperty(notes="Guardar/Modificar Cliente XML")
	@PostMapping(path = "/nuevoXML", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> saveClienteXML(@RequestBody ClienteDTO cli)
	{
		if (cli == null || cli.getNombre() == null || cli.getMail() == null || cli.getTelefono() == null
				|| cli.getBeneficio() == null || cli.getLista() == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("Todos los datos son obligatorios!");
		}
		
		//Validar Beneficio
		Beneficio beneficio = beneficioService.datosBeneficio(cli.getBeneficio(),cli.getLista());
		
		if (beneficio == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, el beneficiario no existe.");
		} else if (beneficio.getEstado() == 1) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, el beneficiario no esta libre.");
		} else {
			beneficio.setEstado(1);
			beneficioService.modificar(beneficio);
		}
				
		Cliente cliNuevo = new Cliente();
		cliNuevo.setMail(cli.getMail());
		cliNuevo.setNombre(cli.getNombre());
		cliNuevo.setTelefono(cli.getTelefono());
		cliNuevo.setIdBeneficio(beneficio);
		
		Cliente respCliente = clienteService.modificar(cliNuevo);
		if (respCliente == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("No se pudo guardar el cliente, revisar con el administrador.");
		} else {
			return ResponseEntity
		            .status(HttpStatus.OK)
		            .body("Cliente Guardado!");
		}
	}
	
	@ApiModelProperty(notes="Obtener los clientes")
	@GetMapping(path="/consulta")
	public List<ResultCliente> consultaClientes() {
		List<ResultCliente> result = clienteService.consultaClientes();
		return result;
	}
}
