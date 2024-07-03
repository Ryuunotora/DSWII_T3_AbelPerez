package pe.edu.cibertec.DSWII_T3_AbelPerez.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_T3_AbelPerez.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Notas;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.NotasId;
import pe.edu.cibertec.DSWII_T3_AbelPerez.service.NotasService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/notas")
public class NotasController {

    private NotasService notasService;

    @GetMapping("")
    public ResponseEntity<List<Notas>> listarNotas(){
        List<Notas> notasList = new ArrayList<>(notasService.listarNotas());
        if(notasList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notasList, HttpStatus.OK);
    }

    @GetMapping("/{idalumno}/{idcurso}")
    public ResponseEntity<Notas> obtenerNotasxId(
            @PathVariable String idalumno,
            @PathVariable String idcurso){
        NotasId id = new NotasId(idalumno,idcurso);
        Notas notas = notasService
                .obtenerNotasxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Las notas con Id Alumno " +
                        idalumno + " y Id Curso " + idcurso + " no existen"));
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Notas> registrarNotas(
            @RequestBody Notas notas
    ){
        return new ResponseEntity<>(
                notasService.guardarNotas(notas), HttpStatus.CREATED);
    }

    @PutMapping("/{idalumno}/{idcurso}")
    public ResponseEntity<Notas> actualizarNotas(
            @PathVariable String idalumno,
            @PathVariable String idcurso,
            @RequestBody Notas notas
    ){
        NotasId id = new NotasId(idalumno,idcurso);
        Notas existingNotas = notasService.obtenerNotasxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Las notas con Id Alumno "
                        + idalumno + " y Id Curso " + idcurso + " no existen"));
        existingNotas.setExaparcial(notas.getExaparcial());
        existingNotas.setExafinal(notas.getExafinal());
        existingNotas.setAlumno(notas.getAlumno());
        existingNotas.setCurso(notas.getCurso());

        return new ResponseEntity<>(
                notasService.guardarNotas(existingNotas),
                HttpStatus.OK);
    }

}
