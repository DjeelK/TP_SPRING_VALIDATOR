package Tp_spring_validator.Tp_spring_validator.service;

import Tp_spring_validator.Tp_spring_validator.entity.Genre;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre findById(int id) throws NotFoundException {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()){
            return genre.get();
        }
        throw new NotFoundException();
    }
    public boolean delete(int id) throws NotFoundException {
        Genre genre = findById(id);
        genreRepository.delete(genre);
        return true;
    }

    public List<Genre> findAll(){
        return (List<Genre>) genreRepository.findAll();
    }


}
