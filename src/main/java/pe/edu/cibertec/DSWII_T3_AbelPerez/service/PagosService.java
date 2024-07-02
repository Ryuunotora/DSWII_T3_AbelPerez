package pe.edu.cibertec.DSWII_T3_AbelPerez.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Pagos;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.PagosId;
import pe.edu.cibertec.DSWII_T3_AbelPerez.repository.PagosRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PagosService implements IPagosService{

    private PagosRepository pagosRepository;

    @Override
    public List<Pagos> listarPagos() {
        return pagosRepository.findAll();
    }

    @Override
    public Pagos guardarPagos(Pagos pagos) {
        return pagosRepository.save(pagos);
    }


    @Override
    public Optional<Pagos> obtenerPagosxId(PagosId id) {
        Optional<Pagos> pagos
                = pagosRepository.findById(id);
        if(pagos.isEmpty()){
            return Optional.empty();
        }
        return pagos;
    }
}
