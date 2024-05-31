package Api.com.farvillage.repository;

import Api.com.farvillage.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository <Consulta, Long> {
}
