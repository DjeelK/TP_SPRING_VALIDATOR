package Tp_spring_validator.Tp_spring_validator.controller;

import Tp_spring_validator.Tp_spring_validator.entity.Livre;
import Tp_spring_validator.Tp_spring_validator.exception.NotFoundException;
import Tp_spring_validator.Tp_spring_validator.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/v1/livre")
public class LivreController {
    @Autowired
    LivreService livreService;

    @PostMapping("/add")
    ResponseEntity<Livre> addLivre(@Valid @RequestBody Livre livre){
        return new ResponseEntity<>( livreService.save(livre), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(livreService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) throws NotFoundException {
        livreService.delete(id);
        return new ResponseEntity<>("Livre supprimé",HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Livre>> findAll () {
        return new ResponseEntity<>(livreService.findAll(),HttpStatus.OK);
    }

}
