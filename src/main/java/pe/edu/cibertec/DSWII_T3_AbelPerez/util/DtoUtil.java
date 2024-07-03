package pe.edu.cibertec.DSWII_T3_AbelPerez.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {

    @Autowired
    private ModelMapper modelMapper;

    public <D> D convertirADto(Object obj, Class<D> dtoClass) {
        return modelMapper.map(obj, dtoClass);
    }

    public <E> E convertirAEntity(Object dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
