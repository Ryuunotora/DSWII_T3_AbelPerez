package pe.edu.cibertec.DSWII_T3_AbelPerez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Pagos;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.pk.PagosId;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, PagosId> {
}
