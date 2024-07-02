package pe.edu.cibertec.DSWII_T3_AbelPerez.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}
