package job.gabrielreyes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@NamedNativeQueries({
	@NamedNativeQuery(
				name = "Beneficio.consultaBeneficios",
				query="SELECT * FROM Beneficio"
			),
	@NamedNativeQuery(
			name = "Beneficio.datosBeneficio",
			query="SELECT * FROM Beneficio WHERE beneficio = :beneficio AND lista = :lista"
		),
})

@ApiModel(description="Datos del Beneficio")
@Table(name="Beneficio")
@Entity
public class Beneficio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idBeneficio",nullable=false)
	private Long idBeneficio;
	
	@ApiModelProperty(notes="max 20")
	@Column(name="beneficio",nullable=false,length=20)
	private String beneficio;
	
	@ApiModelProperty(notes="max 10")
	@Column(name="lista",nullable=false,length=10)
	private String lista;
	
	@Column(name="estado",nullable=false)
	private Integer estado;

	public Long getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(Long idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}
}
