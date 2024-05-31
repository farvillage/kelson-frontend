package Api.com.farvillage.service;

import Api.com.farvillage.model.Convenio;
import Api.com.farvillage.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {


    @Autowired
    static ConvenioRepository convenioRepository;

    public void create(Convenio convenio){
        convenioRepository.save(convenio);
    }

    public List<Convenio> findAll(){
        return convenioRepository.findAll();
    }

    public Optional<Convenio> findById(Long id){
        return convenioRepository.findById(id);
    }

    public void updated(Long id, Convenio convenio){
        Optional<Convenio> convenioDb = convenioRepository.findById(id);

        if (convenioDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "convenio não encontrado");
        }


        Convenio convenioUp = convenioDb.get();
        convenioUp.setName(convenio.getName());
        convenioRepository.save(convenioUp);
    }

    public void DeleteById(Long id){
        convenioRepository.deleteById(id);
    }
}
