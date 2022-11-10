package job.gabrielreyes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import job.gabrielreyes.model.Beneficio;

public interface BeneficioRepo extends JpaRepository<Beneficio, Integer> {
	List<Object[]> consultaBeneficios();
	List<Object[]> datosBeneficio(String beneficio, String lista);
}
