package job.gabrielreyes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import job.gabrielreyes.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
	List<Object[]> consultaClientes();
}
