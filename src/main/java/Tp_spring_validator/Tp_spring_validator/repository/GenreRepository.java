package Tp_spring_validator.Tp_spring_validator.repository;

import Tp_spring_validator.Tp_spring_validator.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
