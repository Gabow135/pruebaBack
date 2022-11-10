package job.gabrielreyes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModelProperty;
import job.gabrielreyes.dto.BeneficioDTO;
import job.gabrielreyes.dto.ResultBeneficio;
import job.gabrielreyes.dto.SkFormato;
import job.gabrielreyes.dto.ThFormato;
import job.gabrielreyes.model.Beneficio;
import job.gabrielreyes.service.IBeneficioService;

@RestController
@RequestMapping("/beneficios")
@CrossOrigin(origins="*")
public class BeneficioController {
	
	@Autowired
	private IBeneficioService beneficioService;
	
	@ApiModelProperty(notes="Guardar/Modificar Beneficiario")
	@PostMapping("/nuevoJSON")
	public ResponseEntity<String> saveBeneficiarios(@RequestBody BeneficioDTO ben)
	{
		if (ben == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("Todos los datos son obligatorios!");
		}
		
		for (SkFormato sk : ben.sk_formato) {
			Beneficio benNuevo = new Beneficio();
			benNuevo.setBeneficio(sk.getBeneficio());
			benNuevo.setLista("JSON");
			benNuevo.setEstado(0);
			
			Beneficio respBeneficio = beneficioService.modificar(benNuevo);
			if (respBeneficio == null)
			{
				return ResponseEntity
			            .status(HttpStatus.FORBIDDEN)
			            .body("No se pudo guardar el beneficio, revisar con el administrador.");
			}
		}
		
		return ResponseEntity
	            .status(HttpStatus.OK)
	            .body("Beneficios Guardados!");
	}
	
	@ApiModelProperty(notes="Guardar/Modificar Beneficiario")
	@PostMapping(path = "/nuevoXML", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> saveBeneficiariosXML(@RequestBody ThFormato ben)
	{
		if (ben == null)
		{
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("Todos los datos son obligatorios!");
		}
		
			Beneficio benNuevo = new Beneficio();
			benNuevo.setBeneficio( ben.beneficios.getBeneficio());
			benNuevo.setLista("XML");
			benNuevo.setEstado(0);
			
			Beneficio respBeneficio = beneficioService.modificar(benNuevo);
			if (respBeneficio == null)
			{
				return ResponseEntity
			            .status(HttpStatus.FORBIDDEN)
			            .body("No se pudo guardar el beneficio, revisar con el administrador.");
			}
		
		return ResponseEntity
	            .status(HttpStatus.OK)
	            .body("Beneficios Guardados!");
	}
	
	@ApiModelProperty(notes="Obtener los beneficios")
	@GetMapping(path="/consulta")
	public List<ResultBeneficio> consultaClientes() {
		List<ResultBeneficio> result = beneficioService.consultaBeneficio();
		return result;
	}
}
