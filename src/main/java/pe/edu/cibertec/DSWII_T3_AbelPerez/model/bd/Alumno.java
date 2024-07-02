package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    private String idalumno;
    private String apealumno;
    private String nomalumno;
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialida;
    private Character proce;
}
