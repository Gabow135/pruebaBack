package job.gabrielreyes.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@NamedNativeQueries({
	@NamedNativeQuery(
				name = "Cliente.consultaClientes",
				query="SELECT c.nombre,c.mail,c.telefono,a.beneficio,a.lista FROM Cliente c "
						+ " INNER JOIN Beneficio a ON a.id_beneficio = c.id_beneficio"
			),
})

@ApiModel(description="Datos del Cliente")
@Table(name="Cliente")
@Entity
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCliente",nullable=false)
	private Long idCliente;
	
	@ApiModelProperty(notes="max 60")
	@Column(name="mail",nullable=false,length=60)
	@Email(message="Debe ser un mail valido!")
	private String mail;
	
	@ApiModelProperty(notes="max 50")
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	
	@ApiModelProperty(notes="max 10")
	@Column(name="telefono",nullable=false,length=10)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="idBeneficio",referencedColumnName="idBeneficio")
	private Beneficio idBeneficio;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Beneficio getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(Beneficio idBeneficio) {
		this.idBeneficio = idBeneficio;
	}
}
