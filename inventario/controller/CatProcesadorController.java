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

import dgac.inventario.entidades.BinCatProcesador;
import dgac.inventario.service.CatProcesadorService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class CatProcesadorController {
	
	@Autowired
	private CatProcesadorService _catProcesadorService;
	
	
	//CREATE
	@RequestMapping(value = "/catProcesador", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createCatProcesador(@RequestBody BinCatProcesador catProcesador, UriComponentsBuilder ucBuilder) {
        
		_catProcesadorService.saveCatProceasdor(catProcesador);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/catRam/{no_inventario}").buildAndExpand(catProcesador.getId_catic_procesador()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	//GET
	@RequestMapping(value = "/catProcesador", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinCatProcesador>> getCatProcesador(){
			
		List<BinCatProcesador> catProcesador = new ArrayList<BinCatProcesador>();		
		catProcesador  = _catProcesadorService.findAllCatProcesador();
		return new ResponseEntity<List<BinCatProcesador>>(catProcesador, HttpStatus.OK);		
	}
	
	//UPDATE
	@RequestMapping(value = "/catProcesador/{nombre_procesador}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateCatProcesador(@PathVariable("nombre_procesador") String nombre_procesador, @RequestBody BinCatProcesador catProcesador){
		
		BinCatProcesador currentCatProcesador = _catProcesadorService.findByNombreProcesador(nombre_procesador);
		
		if (currentCatProcesador == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del catalogo procesador:  " + nombre_procesador),
                    HttpStatus.NOT_FOUND);
		}
	
		currentCatProcesador.setId_catic_procesador(catProcesador.getId_catic_procesador());
		currentCatProcesador.setNombre_procesador(catProcesador.getNombre_procesador());
		
		_catProcesadorService.updateCatProcesador(currentCatProcesador);
		return new ResponseEntity<BinCatProcesador>(currentCatProcesador, HttpStatus.OK);
	}	

}
