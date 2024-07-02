package pe.edu.cibertec.DSWII_T3_AbelPerez.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Alumno;
import pe.edu.cibertec.DSWII_T3_AbelPerez.repository.AlumnoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AlumnoService implements  IAlumnoService{

    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Optional<Alumno> obtenerAlumnoxId(String id) {
        Optional<Alumno> alumno
                = alumnoRepository.findById(id);
        if(alumno.isEmpty()){
            return Optional.empty();
        }
        return alumno;

    }
}
