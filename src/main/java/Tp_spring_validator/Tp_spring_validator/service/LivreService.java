package Tp_spring_validator.Tp_spring_validator.service;

import Tp_spring_validator.Tp_spring_validator.entity.Auteur;
import Tp_spring_validator.Tp_spring_validator.entity.Livre;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    public Livre save(Livre livre){
        return livreRepository.save(livre);
    }

    public Livre findById(int id) throws NotFoundException {
        Optional<Livre> livre = livreRepository.findById(id);
        if(livre.isPresent()){
            return livre.get();
        }
        throw new NotFoundException();
    }
    public boolean delete(int id) throws NotFoundException {
        Livre livre = findById(id);
        livreRepository.delete(livre);
        return true;
    }

    public List<Livre> findAll(){
        return(List<Livre>) livreRepository.findAll();
    }


}
