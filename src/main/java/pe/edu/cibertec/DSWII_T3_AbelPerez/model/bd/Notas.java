package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notas")
public class Notas {

    @EmbeddedId
    private NotasId id;

    @MapsId("idalumno")
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    @MapsId("idcurso")
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    private Integer exaparcial;
    private Integer exafinal;
}
