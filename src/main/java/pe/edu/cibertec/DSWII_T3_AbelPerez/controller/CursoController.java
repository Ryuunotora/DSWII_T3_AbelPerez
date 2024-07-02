package pe.edu.cibertec.DSWII_T3_AbelPerez.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_T3_AbelPerez.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Curso;
import pe.edu.cibertec.DSWII_T3_AbelPerez.service.CursoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/curso")
public class CursoController {

        private CursoService cursoService;

        @GetMapping("")
        public ResponseEntity<List<Curso>> listarCursos(){
        List<Curso> cursoList =
                new ArrayList<>(cursoService.listarCursos());
        if(cursoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursoList, HttpStatus.OK);
    }

        @GetMapping("/{id}")
        public ResponseEntity<Curso> obtenerCursoXId(
            @PathVariable String id){
        Curso curso = cursoService
                .obtenerCursoxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El Curso con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

        @PostMapping("")
        public ResponseEntity<Curso> registrarCurso(
            @RequestBody Curso curso
    ){
        return new ResponseEntity<>(
               cursoService.guardarCurso(curso), HttpStatus.CREATED);
    }

        @PutMapping("/{id}")
        public ResponseEntity<Curso> actualizarCurso(
            @PathVariable String id,
            @RequestBody Curso curso
    ){
        Curso newCurso = cursoService.obtenerCursoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Curso con Id "
                        + id +" no existe"));
        newCurso.setNomcurso(curso.getNomcurso());
        newCurso.setCredito(curso.getCredito());

        return new ResponseEntity<>(
                cursoService.guardarCurso(newCurso),
                HttpStatus.OK);
    }

    }


