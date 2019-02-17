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

import dgac.inventario.entidades.BinPeriferico;
import dgac.inventario.service.PerifericoService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class PerifericoController {
	
	@Autowired
	private PerifericoService _perifericoService;
	
	//CREATE
	@RequestMapping(value = "/perifericos", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createPeriferico(@RequestBody BinPeriferico periferico, UriComponentsBuilder ucBuilder) {
        
		_perifericoService.savePeriferico(periferico);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/periferico/{num_serie}").buildAndExpand(periferico.getNum_serie()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }	
	
	//GET
	@RequestMapping(value = "/perifericos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinPeriferico>> getPeriferico(){
			
		List<BinPeriferico> perifericos = new ArrayList<BinPeriferico>();		
		perifericos  = _perifericoService.findAllPerifericos();
		return new ResponseEntity<List<BinPeriferico>>(perifericos, HttpStatus.OK);		
	}	
	
	//GET BY NUM SERIE
	@RequestMapping(value = "/perifericos/{num_serie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<BinPeriferico> getEquipoByNoInventario(@PathVariable("num_serie") String num_serie){
		BinPeriferico periferico = _perifericoService.findbyNumSerie(num_serie);
	    
		if (num_serie == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	        // You many decide to return HttpStatus.NOT_FOUND
	    }
		return new ResponseEntity<BinPeriferico>(periferico, HttpStatus.OK);
	}
	
	//UPDATE 
	@RequestMapping(value = "/perifericos/{num_serie}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateEquipos(@PathVariable("num_serie") String num_serie, @RequestBody BinPeriferico periferico){
			
		BinPeriferico currentPeriferico = _perifericoService.findbyNumSerie(num_serie);
			
		if (currentPeriferico == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del periferico con Num de serie:  " + num_serie),
	                    HttpStatus.NOT_FOUND);
		}	
		
		//ACTUALIZAR CAMPOS
		currentPeriferico.setNo_factura(periferico.getNo_factura());
		currentPeriferico.setNum_serie(periferico.getNum_serie());
		currentPeriferico.setId_tipos_eq_perifs(periferico.getId_tipos_eq_perifs());
		currentPeriferico.setId_usuario(periferico.getId_usuario());
		currentPeriferico.setId_responsable(periferico.getId_responsable());
		currentPeriferico.setNo_inventario(periferico.getNo_inventario());
		currentPeriferico.setMarca(periferico.getMarca());
		currentPeriferico.setModelo(periferico.getModelo());
		currentPeriferico.setLocalizacion(periferico.getLocalizacion());
		currentPeriferico.setInterfaz(periferico.getInterfaz());
		currentPeriferico.setNucleos(periferico.getNucleos());
		currentPeriferico.setMemoria(periferico.getMemoria());
		currentPeriferico.setVelocidad(periferico.getVelocidad());
		currentPeriferico.setCantidad(periferico.getCantidad());
		currentPeriferico.setIp4(periferico.getIp4());
		currentPeriferico.setIp6(periferico.getIp6());
		currentPeriferico.setObservaciones(periferico.getObservaciones());
		currentPeriferico.setKnow_how(periferico.getKnow_how());
		
		_perifericoService.updatePeriferico(currentPeriferico);
		return new ResponseEntity<BinPeriferico>(currentPeriferico, HttpStatus.OK);	
		
	}
	
	//DELETE
	@RequestMapping(value = "/perifericos/{num_serie}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deletePeriferico(@PathVariable("num_serie") String num_serie) {
	
		System.out.println("course ID recived: " + num_serie);
	 
		BinPeriferico periferico = _perifericoService.findbyNumSerie(num_serie); 
		
	    if (periferico == null) {
	    	System.out.println("No se puede borrar periferico con num serie: " + num_serie );
	    	
	        return new ResponseEntity(new CustomErrorType("El equipo con Num serie: " + num_serie + " no fué encontrado."),
	        HttpStatus.NOT_FOUND);
	    }
	    _perifericoService.deleteEquipoByNumSerie(num_serie);
	        return new ResponseEntity<BinPeriferico>(HttpStatus.NO_CONTENT);
	        
	}	
	
}
