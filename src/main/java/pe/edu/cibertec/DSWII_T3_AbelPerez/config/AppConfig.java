package pe.edu.cibertec.DSWII_T3_AbelPerez.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Notas;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.dto.NotasDto;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Notas.class, NotasDto.class)
                .addMapping(src -> src.getCurso().getNomcurso(), NotasDto::setNombreCurso)
                .addMapping(src -> src.getAlumno().getNomalumno(), NotasDto::setNombreAlumno)
                .addMapping(src -> src.getAlumno().getApealumno(), NotasDto::setApellidoAlumno);
        return modelMapper;
    }
}
