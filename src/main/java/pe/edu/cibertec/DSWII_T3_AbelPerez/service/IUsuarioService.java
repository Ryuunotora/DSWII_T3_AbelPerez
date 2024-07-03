package pe.edu.cibertec.DSWII_T3_AbelPerez.service;


import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Usuario;

public interface IUsuarioService {

    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
