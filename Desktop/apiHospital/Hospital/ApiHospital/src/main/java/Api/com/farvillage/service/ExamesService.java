package Api.com.farvillage.service;

import Api.com.farvillage.model.Exames;
import Api.com.farvillage.repository.ExamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class ExamesService {


    @Autowired
    static ExamesRepository examesRepository;

    public void create(Exames exames){
        examesRepository.save(exames);
    }

    public List<Exames> findAll(){
        return examesRepository.findAll();
    }

    public Optional<Exames> findById(Long id){
        return examesRepository.findById(id);
    }

    public void updated(Long id, Exames exames){
        Optional<Exames> examesDb = examesRepository.findById(id);

        if (examesDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico não encontrado");
        }


        Exames examesup = examesDb.get();
        examesup.setTipoDeExame(exames.getTipoDeExame());
        examesup.setConsulta(exames.getConsulta());
        examesRepository.save(examesup);
    }

    public void DeleteById(Long id){
        examesRepository.deleteById(id);
    }
}
