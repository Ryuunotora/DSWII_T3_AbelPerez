package pe.edu.cibertec.DSWII_T3_AbelPerez.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_T3_AbelPerez.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.Pagos;
import pe.edu.cibertec.DSWII_T3_AbelPerez.model.bd.pk.PagosId;
import pe.edu.cibertec.DSWII_T3_AbelPerez.service.PagosService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/pagos")
public class PagosController {

    private PagosService pagosService;


    @GetMapping("")
    public ResponseEntity<List<Pagos>> listarPagos(){
        List<Pagos> pagosList =
                new ArrayList<>(pagosService.listarPagos());
        if(pagosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pagosList, HttpStatus.OK);
    }

    @GetMapping("/{idalumno}/{ciclo}/{ncuota}")
    public ResponseEntity<Pagos> obtenerPagosXId(
            @PathVariable String idalumno,
            @PathVariable String ciclo,
            @PathVariable Integer ncuota)
    {
        PagosId id = new PagosId(idalumno,ciclo,ncuota);
        Pagos pagos = pagosService
                .obtenerPagosxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El Pago con Id Alumno" +
                                idalumno + " cilo " + ciclo + " y Numero de cuota" + ncuota + " no existen"));
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Pagos> registrarPago(
            @RequestBody Pagos pagos
    ) {
        if (pagos.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pagos nuevoPago = pagosService.guardarPagos(pagos);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @PutMapping("/{idalumno}/{ciclo}/{ncuota}")
    public ResponseEntity<Pagos> actualizarPago(
            @PathVariable String idalumno,
            @PathVariable String ciclo,
            @PathVariable Integer ncuota,
            @RequestBody Pagos pagos
    ){
        PagosId id = new PagosId(idalumno,ciclo,ncuota);
        Pagos newPago = pagosService.obtenerPagosxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Pago con Id Alumno" +
                        idalumno + " cilo " + ciclo + " y Numero de cuota" + ncuota + " no existen"));
        newPago.setAlumno(pagos.getAlumno());
        newPago.setMonto(pagos.getMonto());
        newPago.setFecha(pagos.getFecha());


        return new ResponseEntity<>(
                pagosService.guardarPagos(newPago),
                HttpStatus.OK);
    }

}
