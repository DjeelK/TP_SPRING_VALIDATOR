package Tp_spring_validator.Tp_spring_validator.service;

import Tp_spring_validator.Tp_spring_validator.entity.Auteur;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {
    @Autowired
    private AuteurRepository auteurRepository;

    public Auteur save (Auteur auteur){
        return auteurRepository.save(auteur);
    }

    public Auteur findById(int id) throws NotFoundException {
        Optional<Auteur> auteur = auteurRepository.findById(id);
        if(auteur.isPresent()){
            return auteur.get();
        }
        throw new NotFoundException();
    }
    public boolean delete(int id) throws NotFoundException {
        Auteur auteur = findById(id);
        auteurRepository.delete(auteur);
        return true;
    }
    public List<Auteur> findAll(){
        return(List<Auteur>) auteurRepository.findAll();
    }
}
