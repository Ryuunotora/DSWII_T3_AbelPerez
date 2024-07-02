package pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class NotasId implements Serializable {

    private String idalumno;
    private String idcurso;


    public NotasId() {}

    public NotasId(String idalumno, String idcurso) {
        this.idalumno = idalumno;
        this.idcurso = idcurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idalumno, idcurso);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NotasId that = (NotasId) obj;
        return Objects.equals(idalumno, that.idalumno) && Objects.equals(idcurso, that.idcurso);
    }


}
