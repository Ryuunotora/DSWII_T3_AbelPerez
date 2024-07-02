package pe.edu.cibertec.DSWII_T3_AbelPerez.service;



import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoService {

    List<Curso> listarCursos();
    Curso guardarCurso(Curso curso);
    Optional<Curso> obtenerCursoxId(String id);


}
