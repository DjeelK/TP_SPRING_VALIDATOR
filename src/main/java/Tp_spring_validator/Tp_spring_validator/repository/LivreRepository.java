package Tp_spring_validator.Tp_spring_validator.repository;

import Tp_spring_validator.Tp_spring_validator.entity.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
}
