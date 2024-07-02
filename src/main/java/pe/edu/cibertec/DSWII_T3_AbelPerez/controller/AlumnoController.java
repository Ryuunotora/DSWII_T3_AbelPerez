package pe.edu.cibertec.DSWII_T3_AbelPerez.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_T3_AbelPerez.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Alumno;
import pe.edu.cibertec.DSWII_T3_AbelPerez.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {

    private AlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumnos(){
        List<Alumno> alumnoList =
                new ArrayList<>(alumnoService.listarAlumnos());
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoXId(
            @PathVariable String id){
        Alumno alumno = alumnoService
                .obtenerAlumnoxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El Alumno con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Alumno> registrarAlumno(
            @RequestBody Alumno alumno
    ){
        return new ResponseEntity<>(
                alumnoService.guardarAlumno(alumno), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable String id,
            @RequestBody Alumno alumno
    ){
        Alumno newAlumno = alumnoService.obtenerAlumnoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Alumno con Id "
                        + id +" no existe"));
        newAlumno.setApealumno(alumno.getApealumno());
        newAlumno.setNomalumno(alumno.getNomalumno());
        newAlumno.setEspecialidad(alumno.getEspecialidad());
        newAlumno.setProce(alumno.getProce());

        return new ResponseEntity<>(
                alumnoService.guardarAlumno(newAlumno),
                HttpStatus.OK);
    }

}
