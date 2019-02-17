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

import dgac.inventario.entidades.BinFactura;
import dgac.inventario.service.FacturaService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class FacturaController {

	@Autowired
	private FacturaService _facturaService;
	
	//GET ALL - GET BY ID
		@RequestMapping(value = "/facturas", method = RequestMethod.GET, headers = "Accept=application/json")
	    public ResponseEntity<List<BinFactura>> getFacturas(@RequestParam(value="no_factura", required=false) String no_factura){
			List<BinFactura> facturas = new ArrayList<BinFactura>();
			
			if (no_factura == null) {
				facturas = _facturaService.findAllFacturas();
		        if (facturas.isEmpty()) {
		            return new ResponseEntity(HttpStatus.NO_CONTENT);	           
		        }		   
				return new ResponseEntity<List<BinFactura>>(facturas, HttpStatus.OK);
				
			} else {
				BinFactura factura = _facturaService.findbyNoFactura(no_factura);
				if (facturas == null) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
				}
				
				facturas.add(factura);
				return new ResponseEntity<List<BinFactura>>(facturas, HttpStatus.OK);
			}		
			
	    }
		
	//CREATE
	@RequestMapping(value = "/facturas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createFactura(@RequestBody BinFactura factura, UriComponentsBuilder ucBuilder) {
		
		//verifica que no exita una factura con el mismo numero
		if (_facturaService.findbyNoFactura(factura.getNo_factura()) != null) {
			return new ResponseEntity(new CustomErrorType("No se puede guardar la factura n° " +
					factura.getNo_factura() + "por que ya existe."), HttpStatus.CONFLICT);
		}
		
		_facturaService.saveFactura(factura);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/facturas/{id}").buildAndExpand(factura.getNo_factura()).toUri());
        
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	
	
	//actualizar los campos de una factura
	@RequestMapping(value = "/facturas/{no_factura}", method = RequestMethod.PATCH)
	public ResponseEntity<?> updateEquipos(@PathVariable("no_factura") String no_factura, @RequestBody BinFactura factura){
		
		BinFactura currentFactura = _facturaService.findbyNoFactura(no_factura);
		
		if (currentFactura == null) {
			return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos de la factura con Num:  " + no_factura),
                    HttpStatus.NOT_FOUND);
		}
		
		//actualizar campos de equipo
		currentFactura.setNo_factura(factura.getNo_factura());
		currentFactura.setRfc(factura.getRfc());
		currentFactura.setNo_resguardo(factura.getNo_resguardo());
		currentFactura.setFecha_emision(factura.getFecha_emision());
		currentFactura.setAnios_garantia(factura.getAnios_garantia());
		currentFactura.setSubtotal(factura.getSubtotal());
		currentFactura.setIva(factura.getIva());
		currentFactura.setTotal(factura.getTotal());		
		
		_facturaService.updateFactura(currentFactura);
		return new ResponseEntity<BinFactura>(currentFactura, HttpStatus.OK);			
	}
	
	//delete
	@RequestMapping(value = "/facturas/{no_factura}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEquipo(@PathVariable("no_factura") String no_factura) {
	
		System.out.println("factura ID: " + no_factura);	 
		BinFactura factura = _facturaService.findbyNoFactura(no_factura);
		
	    if (factura == null) {
	    	System.out.println("No se puede borrar la factura: " + no_factura + "no se encuentra.");
	    	
	        return new ResponseEntity(new CustomErrorType("La factura con Num: " + no_factura + " no fué encontrado."),
	        HttpStatus.NOT_FOUND);
	    }
	    _facturaService.deleteFactura(no_factura);
	        return new ResponseEntity<BinFactura>(HttpStatus.NO_CONTENT);
	        
	}
	    
}
