package Api.com.farvillage.repository;

import Api.com.farvillage.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository <Medico, Long> {
}
