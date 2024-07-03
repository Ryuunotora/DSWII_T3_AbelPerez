package pe.edu.cibertec.DSWII_T3_AbelPerez.model.dto;

import lombok.Data;

@Data
public class NotasDto implements DtoEntity {

    private String nombreCurso;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Double exaparcial;
    private Double exafinal;

}
