package pe.edu.cibertec.DSWII_T3_AbelPerez.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Curso;
import pe.edu.cibertec.DSWII_T3_AbelPerez.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CursoService implements ICursoService{

    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> obtenerCursoxId(String id) {
        Optional<Curso> curso
                = cursoRepository.findById(id);
        if(curso.isEmpty()){
            return Optional.empty();
        }
        return curso;
    }
}
