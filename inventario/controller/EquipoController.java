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

import dgac.inventario.util.CustomErrorType;
import dgac.inventario.entidades.BinEquipo;
import dgac.inventario.service.EquipoService;

@Controller
@RequestMapping(value="/v1")
public class EquipoController {
	
	@Autowired
	private EquipoService _equipoService;
	
	//CREATE
	@RequestMapping(value = "/equipos", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createEquipo(@RequestBody BinEquipo equipo, UriComponentsBuilder ucBuilder) {
        
		_equipoService.saveEquipo(equipo);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/equipos/{no_inventario}").buildAndExpand(equipo.getNo_inventario()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	//GET
	@RequestMapping(value = "/equipos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<BinEquipo>> getEquipo(){
			
		List<BinEquipo> equipos = new ArrayList<BinEquipo>();		
		equipos  = _equipoService.findAllEquipos();
		return new ResponseEntity<List<BinEquipo>>(equipos, HttpStatus.OK);		
	}
	
	//GET BY ID
	@RequestMapping(value = "/equipos/{no_inventario}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<BinEquipo> getEquipoByNoInventario(@PathVariable("no_inventario") int no_inventario){
		BinEquipo equipo = _equipoService.findbyNoInventario(no_inventario);
	    
		if (equipo == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	        // You many decide to return HttpStatus.NOT_FOUND
	    }
		return new ResponseEntity<BinEquipo>(equipo, HttpStatus.OK);
	}
		
	//UPDATE 
	@RequestMapping(value = "/equipos/{no_inventario}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateEquipos(@PathVariable("no_inventario") int no_inventario, @RequestBody BinEquipo equipo){
		
		BinEquipo currentEquipo = _equipoService.findbyNoInventario(no_inventario);
		
		if (currentEquipo == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del equipo con Num de Inventario:  " + no_inventario),
                    HttpStatus.NOT_FOUND);
		}
		
		//actualizar campos de equipo
		currentEquipo.setNo_inventario(equipo.getNo_inventario());
		currentEquipo.setId_responsable(equipo.getId_responsable());
		currentEquipo.setNo_factura(equipo.getNo_factura());
		currentEquipo.setNo_serie(equipo.getNo_serie());
		currentEquipo.setLocalizacion(equipo.getLocalizacion());
		currentEquipo.setMarca(equipo.getMarca());
		currentEquipo.setModelo(equipo.getModelo());
		currentEquipo.setTipo_equipo(equipo.getTipo_equipo());
		currentEquipo.setNum_arreglos(equipo.getNum_arreglos());
		currentEquipo.setTec_comunicacion(equipo.getTec_comunicacion());
		currentEquipo.setTec_comunicacion_dif(equipo.getTec_comunicacion_dif());
		currentEquipo.setOs(equipo.getOs());
		currentEquipo.setOs_version(equipo.getOs_version());
		currentEquipo.setOs_edicion(equipo.getOs_edicion());
		currentEquipo.setOs_arq(equipo.getOs_arq());
		currentEquipo.setOs_release(equipo.getOs_release());
		currentEquipo.setNum_procesadores(equipo.getNum_procesadores());
		currentEquipo.setNum_ram_instaladas(equipo.getNum_ram_instaladas());
		currentEquipo.setTipo_licencia(equipo.getTipo_licencia());
		currentEquipo.setLicencia_inicio(equipo.getLicencia_inicio());
		currentEquipo.setLicencia_fin(equipo.getLicencia_fin());
		currentEquipo.setUnidad_optica(equipo.getUnidad_optica());
		currentEquipo.setIp4(equipo.getIp4());
		currentEquipo.setIp6(equipo.getIp6());
		currentEquipo.setObservaciones(equipo.getObservaciones());
		currentEquipo.setKnow_how(equipo.getKnow_how());
		
		_equipoService.updateEquipo(currentEquipo);
		return new ResponseEntity<BinEquipo>(currentEquipo, HttpStatus.OK);			
	}
	
	//DELETE
	@RequestMapping(value = "/equipos/{no_inventario}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEquipo(@PathVariable("no_inventario") int no_inventario) {
	
		System.out.println("course ID recived: " + no_inventario);
	 
		BinEquipo equipo = _equipoService.findbyNoInventario(no_inventario);
		
	    if (equipo == null) {
	    	System.out.println("No se puede borrar equipo: " + no_inventario + "no se encuentra.");
	    	
	        return new ResponseEntity(new CustomErrorType("El equipo con Num Inventario: " + no_inventario + " no fué encontrado."),
	        HttpStatus.NOT_FOUND);
	    }
	    _equipoService.deleteEquipoByNoInventario(no_inventario);
	        return new ResponseEntity<BinEquipo>(HttpStatus.NO_CONTENT);
	        
	}
	
	
}
