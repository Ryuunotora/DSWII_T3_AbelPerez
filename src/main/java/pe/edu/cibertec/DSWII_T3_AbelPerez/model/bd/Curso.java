package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    private String idcurso;
    private String nomcurso;
    private Integer credito;

}
