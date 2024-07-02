package pe.edu.cibertec.DSWII_T3_AbelPerez.service;

import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService {

    List<Alumno> listarAlumnos();
    Alumno guardarAlumno(Alumno alumno);
    Optional<Alumno> obtenerAlumnoxId(String id);


}
