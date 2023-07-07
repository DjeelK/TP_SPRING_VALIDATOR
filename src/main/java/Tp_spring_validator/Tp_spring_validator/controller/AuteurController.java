package Tp_spring_validator.Tp_spring_validator.controller;

import Tp_spring_validator.Tp_spring_validator.entity.Auteur;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.service.AuteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/auteur")
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @PostMapping("/add")
    public ResponseEntity<Auteur> addAutor(@RequestBody @Valid Auteur auteur){
        return new ResponseEntity<>( auteurService.save(auteur), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auteur> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(auteurService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) throws NotFoundException {
        auteurService.delete(id);
        return new ResponseEntity<>("auteur supprimé",HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Auteur>> findAll () {
        return new ResponseEntity<>(auteurService.findAll(),HttpStatus.OK);
    }

}
