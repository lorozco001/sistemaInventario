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

import dgac.inventario.entidades.BinRam;
import dgac.inventario.service.RamService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class RamController {

	@Autowired
	private RamService _ramService;
	
	//CREATE
	@RequestMapping(value = "/ram", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createRam(@RequestBody BinRam ram, UriComponentsBuilder ucBuilder) {
        
		_ramService.saveRam(ram);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/equipos/{no_inventario}").buildAndExpand(ram.getId_ram()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	//GET ALL
		@RequestMapping(value = "/ram", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List<BinRam>> getRam(){
				
			List<BinRam> ram = new ArrayList<BinRam>();		
			ram  = _ramService.findAllRam();
			return new ResponseEntity<List<BinRam>>(ram, HttpStatus.OK);		
		}
		
	//GET BY TIPO RAM
		@RequestMapping(value = "/ram/{tipo_ram}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<BinRam> getRamByTipoRam(@PathVariable("tipo_ram") byte tipo_ram){
			BinRam ram = _ramService.findbyTipoRam(tipo_ram); 
		    
			if (ram == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
		        // You many decide to return HttpStatus.NOT_FOUND
		    }
			return new ResponseEntity<BinRam>(ram, HttpStatus.OK);
		}
	
	//UPDATE RAM
		@RequestMapping(value = "/ram/{tipo_ram}", method = RequestMethod.PATCH)
		public ResponseEntity<?> updateRam(@PathVariable("tipo_ram") byte tipo_ram, @RequestBody BinRam ram){
			
			BinRam currentRam = _ramService.findbyTipoRam(tipo_ram);
			
			if (currentRam == null) {
				return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos de la ram con Num:  " + tipo_ram),
	                    HttpStatus.NOT_FOUND);
			}
			
			//actualizar campos de equipo
			currentRam.setId_ram(ram.getId_ram());
			currentRam.setTipo_ram(ram.getTipo_ram());
			currentRam.setTipo_ram_diferente(ram.getTipo_ram_diferente());
			currentRam.setCapacidad(ram.getCapacidad());
			currentRam.setEscala_capacidad(ram.getEscala_capacidad());
			currentRam.setVelocidad(ram.getVelocidad());
			currentRam.setEscala_velocidad(ram.getEscala_velocidad());
			
			_ramService.updateRam(currentRam);
			return new ResponseEntity<BinRam>(currentRam, HttpStatus.OK);			
		}
}
