package pe.edu.cibertec.DSWII_T3_AbelPerez.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("documentos");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        validarExtensionArchivo(archivo);
        validarTamanoArchivo(archivo);
        if (!Files.exists(pathFolder)) {
            Files.createDirectories(pathFolder);
        }
        Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        for (MultipartFile archivo : archivosList) {
            this.guardarArchivo(archivo);
        }
    }

    private void validarExtensionArchivo(MultipartFile archivo) throws Exception {
        String nombreArchivo = archivo.getOriginalFilename();
        if (nombreArchivo == null || !nombreArchivo.endsWith(".docx")) {
            throw new IllegalArgumentException("Solo se permiten archivos con la extensión .docx");
        }
    }

    private void validarTamanoArchivo(MultipartFile archivo) throws Exception {
        if (archivo.getSize() > 2 * 1024 * 1024) {
            throw new IllegalArgumentException("El archivo excede el tamaño máximo permitido de 2MB");
        }
    }
}
