package pe.edu.cibertec.DSWII_T3_AbelPerez.service;

import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Pagos;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.PagosId;

import java.util.List;
import java.util.Optional;

public interface IPagosService {

    List<Pagos> listarPagos();
    Pagos guardarPagos(Pagos pagos);
    Optional<Pagos> obtenerPagosxId(PagosId id);

}
