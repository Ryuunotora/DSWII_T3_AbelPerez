package pe.edu.cibertec.DSWII_T3_AbelPerez.service;

import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Notas;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.NotasId;


import java.util.List;
import java.util.Optional;

public interface INotasService {

    List<Notas> listarNotas();
    Notas guardarNotas(Notas notas);
    Optional<Notas> obtenerNotasxId(NotasId id);


}
