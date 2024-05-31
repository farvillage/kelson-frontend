package Api.com.farvillage.service;

import Api.com.farvillage.model.Paciente;
import Api.com.farvillage.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {


    @Autowired
    PacienteRepository pacienteRepository;

    public void create(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById (Long id){
        return pacienteRepository.findById(id);
    }

    public void updated(Long id, Paciente paciente){
        Optional<Paciente> pacienteDb = pacienteRepository.findById(id);

        if (pacienteDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paciente não encontrado");
        }


        Paciente pacienteUp = pacienteDb.get();
        pacienteUp.setNome(paciente.getNome());
        pacienteUp.setEmail(paciente.getEmail());
        pacienteUp.setIdade(paciente.getIdade());
        pacienteUp.setEnderece(paciente.getEnderece());

        pacienteRepository.save(pacienteUp);
    }

    public void DeleteById(Long id){
        pacienteRepository.deleteById(id);
    }
}
