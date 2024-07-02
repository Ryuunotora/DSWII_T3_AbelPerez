package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PagosId implements Serializable {

    private String idalumno;
    private String ciclo;
    private Integer ncuota;

    public PagosId() {}

    public PagosId(String idalumno, String ciclo, Integer ncuota) {
        this.idalumno = idalumno;
        this.ciclo = ciclo;
        this.ncuota = ncuota;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idalumno, ciclo, ncuota);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PagosId that = (PagosId) obj;
        return Objects.equals(idalumno, that.idalumno) && Objects.equals(ciclo, that.ciclo) && Objects.equals(ncuota, that.ncuota);
    }
}