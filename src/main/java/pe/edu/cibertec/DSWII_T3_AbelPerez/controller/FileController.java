package pe.edu.cibertec.DSWII_T3_AbelPerez.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.dto.ArchivoDto;
import pe.edu.cibertec.DSWII_T3_AbelPerez.service.FileService;

import java.util.List;
@PreAuthorize("hasRole('Administrador')")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileController {
    private final FileService fileService;

    @PostMapping("filesdoc")
    public ResponseEntity<ArchivoDto> subirArchivoDoc(
            @RequestParam("file") MultipartFile multipartFile
    ) throws Exception {
        fileService.guardarArchivo(multipartFile);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivo .docx subido correctamente").build(),
                HttpStatus.OK);
    }
}
