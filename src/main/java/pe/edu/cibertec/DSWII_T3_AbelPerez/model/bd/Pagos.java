package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.pk.PagosId;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pagos {

    @EmbeddedId
    private PagosId id;

    @MapsId("idalumno")
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    private Double monto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
}
