package pe.edu.cibertec.DSWII_T3_AbelPerez.service;

import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Especialidad;


import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {

    List<Especialidad> listarEspecialidades();
    Especialidad guardarEspecialidad(Especialidad especialidad);
    Optional<Especialidad> obtenerEspecialidadxId(String id);


}
