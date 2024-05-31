package Api.com.farvillage.service;

import Api.com.farvillage.model.Medico;
import Api.com.farvillage.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public void create(Medico medico){
        medicoRepository.save(medico);
    }

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Long id){
        return medicoRepository.findById(id);
    }

    public void updated(Long id, Medico medico){
        Optional<Medico> medicoDb = medicoRepository.findById(id);

        if (medicoDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico não encontrado");
        }


        Medico medicoUp = medicoDb.get();
        medicoUp.setNome(medico.getNome());
        medicoUp.setDepartamento(medico.getDepartamento());
        medicoUp.setCRM(medico.getCRM());

        medicoRepository.save(medicoUp);
    }

    public void DeleteById(Long id){
        medicoRepository.deleteById(id);
    }
}
