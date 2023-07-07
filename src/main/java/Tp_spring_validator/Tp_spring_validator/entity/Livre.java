package Tp_spring_validator.Tp_spring_validator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(max=250, message = "Le titre est trop long")
    private String titre;
    @NotNull
    @ManyToOne
    private Auteur auteur;
    @NotNull
    @ManyToOne
    private Genre genre;
    @Size(max = 2023, message = "l'année de publication ne peut être supérieur à 2023")
    private int annee_publication;

}
