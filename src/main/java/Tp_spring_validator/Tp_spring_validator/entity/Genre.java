package Tp_spring_validator.Tp_spring_validator.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name="genre")
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty
    @Size(max=10,message = "Le nom ne doit pas dépasser 10 caractères")
    private String nom_genre;

    @NotEmpty
    @NotNull
    @Size(max=200,message = "La description ne peut pas dépasser 200 caractères")
    private String description;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Livre> livres;
}
