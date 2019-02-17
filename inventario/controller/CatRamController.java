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

import dgac.inventario.entidades.BinCatRam;
import dgac.inventario.service.CatRamService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")

public class CatRamController {

	@Autowired
	private CatRamService _catRamService;
	
	//CREATE
	@RequestMapping(value = "/catRam", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createCatRam(@RequestBody BinCatRam catRam, UriComponentsBuilder ucBuilder) {
        
		_catRamService.saveCatRam(catRam);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/catRam/{no_inventario}").buildAndExpand(catRam.getId_catic_ram()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }	
	
	//GET
	@RequestMapping(value = "/catRam", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinCatRam>> getCatRam(){
			
		List<BinCatRam> catRam = new ArrayList<BinCatRam>();		
		catRam  = _catRamService.findAllCatRam();
		return new ResponseEntity<List<BinCatRam>>(catRam, HttpStatus.OK);		
	}

	//UPDATE 
	@RequestMapping(value = "/catRam/{nombre_ram}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateCatRam(@PathVariable("nombre_ram") String nombre_ram, @RequestBody BinCatRam catRam){
		
		BinCatRam currentCatRam = _catRamService.findByNombreRam(nombre_ram);
		
		if (currentCatRam == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del catalogo ram:  " + nombre_ram),
                    HttpStatus.NOT_FOUND);
		}
	
		currentCatRam.setId_catic_ram(catRam.getId_catic_ram());
		currentCatRam.setNombre_ram(catRam.getNombre_ram());
		
		_catRamService.updateCatRam(currentCatRam);
		return new ResponseEntity<BinCatRam>(currentCatRam, HttpStatus.OK);
	}	
	
}
