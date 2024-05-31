package Api.com.farvillage.service;

import Api.com.farvillage.model.Consulta;
import Api.com.farvillage.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public void create(Consulta consulta){
        consultaRepository.save(consulta);
    }

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Optional <Consulta> findById(Long id){
        return consultaRepository.findById(id);
    }

    public void updated(Long id, Consulta consulta){
        Optional<Consulta> consultaDb = consultaRepository.findById(id);

        if (consultaDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "consulta não encontrada");
        }


        Consulta consultaUp = consultaDb.get();
        consultaUp.setDescricao(consulta.getDescricao());
        consultaUp.setHoraDaConsulta(consulta.getHoraDaConsulta());
        consultaUp.setMedico(consulta.getMedico());
        consultaUp.setPaciente(consulta.getPaciente());

        consultaRepository.save(consultaUp);
    }

    public void DeleteById(Long id){
        consultaRepository.deleteById(id);
    }
}
