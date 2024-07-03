package pe.edu.cibertec.DSWII_T3_AbelPerez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Usuario;


@Repository
public interface UsuarioRepository
    extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

}
