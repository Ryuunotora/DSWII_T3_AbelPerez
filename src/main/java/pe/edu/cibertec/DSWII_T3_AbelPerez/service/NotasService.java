package pe.edu.cibertec.DSWII_T3_AbelPerez.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Notas;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.pk.NotasId;
import pe.edu.cibertec.DSWII_T3_AbelPerez.repository.NotasRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NotasService implements  INotasService{

    private NotasRepository notasRepository;

    @Override
    public List<Notas> listarNotas() {
        return notasRepository.findAll();
    }

    @Override
    public Notas guardarNotas(Notas notas) {
        return notasRepository.save(notas);
    }

    @Override
    public Optional<Notas> obtenerNotasxId(NotasId id) {
        Optional<Notas> notas
                = notasRepository.findById(id);
        if(notas.isEmpty()){
            return Optional.empty();
        }
        return notas;
    }
}
