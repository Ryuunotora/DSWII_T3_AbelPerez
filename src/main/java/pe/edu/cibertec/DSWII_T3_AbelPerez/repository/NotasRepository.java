package pe.edu.cibertec.DSWII_T3_AbelPerez.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Notas;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.NotasId;

@Repository
public interface NotasRepository extends JpaRepository<Notas, NotasId> {
}
