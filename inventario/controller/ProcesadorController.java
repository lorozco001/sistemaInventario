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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import dgac.inventario.entidades.BinProcesador;
import dgac.inventario.service.ProcesadorService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class ProcesadorController {

	@Autowired
	private ProcesadorService _procesadorService;
	
	//CREATE
	@RequestMapping(value = "/procesador", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createProcesador(@RequestBody BinProcesador procesador, UriComponentsBuilder ucBuilder) {
        
		_procesadorService.saveProcesador(procesador);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/procesador/{id_procesador}").buildAndExpand(procesador.getId_procesador()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	//GET ALL 
	@RequestMapping(value = "/procesador", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<BinProcesador>> getProcesadores(){
		
		List<BinProcesador> procesadores = new ArrayList<BinProcesador>();		
		procesadores = _procesadorService.findAllProcesadores();
		return new ResponseEntity<List<BinProcesador>>(procesadores, HttpStatus.OK);
				
    }
	
	//GET BY ID
	@RequestMapping(value = "/procesador/{id_procesador}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<BinProcesador> getProcesadorById(@PathVariable("id_procesador") int id_procesador){
		
		BinProcesador procesador = _procesadorService.findbyID(id_procesador);
	    
		if (procesador == null) {
			return new ResponseEntity (HttpStatus.NOT_FOUND); 
	    }
		return new ResponseEntity<BinProcesador>(procesador, HttpStatus.OK);
	}
	
	//ACTUALIZAR PROCESADOR POR ID
	@RequestMapping(value = "/procesador/{id_procesador}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateProcesador(@PathVariable("id_procesador") int id_procesador, @RequestBody BinProcesador procesador){
		
		BinProcesador currentProcesador = _procesadorService.findbyID(id_procesador);
		
		if (currentProcesador == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del procesador con ID:  " + id_procesador),
                    HttpStatus.NOT_FOUND);
		}
	
		//actualizar campos de usuario
		currentProcesador.setId_procesador(procesador.getId_procesador());
		currentProcesador.setTipo_procesador(procesador.getTipo_procesador());
		currentProcesador.setTipo_procesador_diferente(procesador.getTipo_procesador_diferente());
		currentProcesador.setModelo_procesador(procesador.getModelo_procesador());
		currentProcesador.setCant_nucleos(procesador.getCant_nucleos());
		currentProcesador.setCant_nucleos_gpu(procesador.getCant_nucleos_gpu());
		currentProcesador.setVelocidad(procesador.getVelocidad());
		currentProcesador.setEscala_velocidad(procesador.getEscala_velocidad());
		currentProcesador.setMarca(procesador.getMarca());
		currentProcesador.setArquitectura(procesador.getArquitectura());
		
		_procesadorService.updateProcesador(currentProcesador);		
		return new ResponseEntity<BinProcesador>(currentProcesador, HttpStatus.OK);			
	} 
	
	
	
}
