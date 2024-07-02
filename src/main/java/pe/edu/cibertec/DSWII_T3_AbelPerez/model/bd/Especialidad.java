package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    private String idesp;
    private String nomesp;
    private Double costo;

}
