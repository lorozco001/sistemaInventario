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

import dgac.inventario.entidades.BinDiscoDuro;
import dgac.inventario.service.DiscoDuroService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class DiscoDuroControlller {

	@Autowired
	private DiscoDuroService _discoDuroService;
	
	//CREATE
	@RequestMapping(value = "/discoDuro", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createDiscoDuro(@RequestBody BinDiscoDuro discoDuro, UriComponentsBuilder ucBuilder) {
        
		_discoDuroService.saveDiscoDuro(discoDuro);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/discoDuro/{id_disco_duro}").buildAndExpand(discoDuro.getId_disco_duro()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }	
	
	//GET
	@RequestMapping(value = "/discoDuro", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinDiscoDuro>> getDiscoDuro(){
			
		List<BinDiscoDuro> discoDuro = new ArrayList<BinDiscoDuro>();		
		discoDuro  = _discoDuroService.findAllDiscoDuro();
		return new ResponseEntity<List<BinDiscoDuro>>(discoDuro, HttpStatus.OK);		
	}	
	
	//UPDATE
	@RequestMapping(value = "/discoDuro/{id_disco_duro}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateDiscoDuro(@PathVariable("id_disco_duro") int id_disco_duro, @RequestBody BinDiscoDuro discoDuro){
		
		BinDiscoDuro currentDiscoDuro = _discoDuroService.findbyIdDiscoDuro(id_disco_duro);
		
		if (currentDiscoDuro == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del disco duro:  " + id_disco_duro),
                    HttpStatus.NOT_FOUND);
		}
	
		currentDiscoDuro.setId_disco_duro(discoDuro.getId_disco_duro());
		currentDiscoDuro.setNo_inventario(discoDuro.getNo_inventario());
		currentDiscoDuro.setTecnologia_dd(discoDuro.getTecnologia_dd());
		currentDiscoDuro.setCapacidad_total(discoDuro.getCapacidad_total());
		currentDiscoDuro.setEscala_capacidad(discoDuro.getEscala_capacidad());
		currentDiscoDuro.setTipo_dd(discoDuro.getTipo_dd());
		
		
		_discoDuroService.updatedDiscoDuro(currentDiscoDuro);
		return new ResponseEntity<BinDiscoDuro>(currentDiscoDuro, HttpStatus.OK);
	}
	
	
}
