package Tp_spring_validator.Tp_spring_validator.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name="auteur")
@AllArgsConstructor
@NoArgsConstructor
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty(message="Ne peut pas être vide")
    @Size(max=50, message = "Le nom ne peut pas dépasser 50 caractères")
    private String nom;
    @NotNull
    @NotEmpty
    @Email(regexp = "^[\\w-.]+@(editor\\.com)", message = "Ceci n'est pas une adresse mail : ...@editor.com demandé")
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Livre> livres;
}
