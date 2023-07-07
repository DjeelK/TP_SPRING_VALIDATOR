package Tp_spring_validator.Tp_spring_validator.controller;

import Tp_spring_validator.Tp_spring_validator.entity.Genre;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/v1/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @PostMapping("/add")
    ResponseEntity<Genre> addGenre(@Valid @RequestBody Genre genre){
        return new ResponseEntity<>(genreService.save(genre), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(genreService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) throws NotFoundException {
        genreService.delete(id);
        return new ResponseEntity<>("Genre supprimé",HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Genre>> findAll () {
        return new ResponseEntity<>(genreService.findAll(),HttpStatus.OK);
    }
}
