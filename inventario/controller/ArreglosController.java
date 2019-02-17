package dgac.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import dgac.inventario.entidades.BinArreglos;
import dgac.inventario.service.ArreglosService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class ArreglosController {

	@Autowired
	private ArreglosService _arreglosService;
	
	//CREATE
	@RequestMapping(value = "/arreglos", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createArreglo(@RequestBody BinArreglos arreglos, UriComponentsBuilder ucBuilder) {
        
		_arreglosService.saveArreglos(arreglos);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/arreglos/{no_inventario}").buildAndExpand(arreglos.getNo_inventario()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }	

	//GET
	@RequestMapping(value = "/arreglos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinArreglos>> getArreglos(){
			
		List<BinArreglos> arreglos = new ArrayList<BinArreglos>();		
		arreglos  = _arreglosService.findAllArreglos();
		return new ResponseEntity<List<BinArreglos>>(arreglos, HttpStatus.OK);		
	}
	
	//UPDATE
	@RequestMapping(value = "/arreglos/{no_inventario}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateArreglos(@PathVariable("no_inventario") int no_inventario, @RequestBody BinArreglos arreglos){
		
		BinArreglos currentArreglos = _arreglosService.findbyNoInventario(no_inventario);
		
		if (currentArreglos == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del arreglo:  " + no_inventario),
                    HttpStatus.NOT_FOUND);
		}
	
		currentArreglos.setNo_inventario(arreglos.getNo_inventario());
		currentArreglos.setNum_arreglo(arreglos.getNum_arreglo());
		currentArreglos.setEsquema(arreglos.getEsquema());
		currentArreglos.setTecnologia_dd(arreglos.getTecnologia_dd());
		currentArreglos.setCapacidad_arr(arreglos.getCapacidad_arr());
		currentArreglos.setEscala_capacidad(arreglos.getEscala_capacidad());
		
		_arreglosService.updateArreglos(currentArreglos);
		return new ResponseEntity<BinArreglos>(currentArreglos, HttpStatus.OK);
	}
	
}
