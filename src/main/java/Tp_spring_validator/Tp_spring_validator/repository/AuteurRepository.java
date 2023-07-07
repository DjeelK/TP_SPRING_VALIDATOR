package Tp_spring_validator.Tp_spring_validator.repository;

import Tp_spring_validator.Tp_spring_validator.entity.Auteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends CrudRepository<Auteur,Integer> {
}
