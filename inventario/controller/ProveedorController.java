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

import dgac.inventario.entidades.BinProveedor;
import dgac.inventario.entidades.BinUsuarioInventario;
import dgac.inventario.service.ProveedorService;
import dgac.inventario.util.CustomErrorType;

@Controller
@RequestMapping(value="/v1")
public class ProveedorController {
	
	@Autowired
	private ProveedorService _proveedorService;
			//CREATE(CREAR USUARIO)
			@RequestMapping(value = "/proveedor", method = RequestMethod.POST, headers = "Accept=application/json")
			public ResponseEntity<?> createProveedor(@RequestBody BinProveedor proveedor, UriComponentsBuilder ucBuilder) {
				if (_proveedorService.findByName(proveedor.getNombre_provedor()) != null) {
					return new ResponseEntity(new CustomErrorType("No se puede crear usuario con el nombre  " + 
	            		proveedor.getNombre_provedor() + " ya esxiste"),HttpStatus.CONFLICT);
				}
			_proveedorService.saveProveedor(proveedor);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/v1/proveedor/{rfc}").buildAndExpand(proveedor.getRfc()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
			}
		
			 //GET (OBTENER USUARIOS)
			@RequestMapping(value = "/proveedor", method = RequestMethod.GET, headers = "Accept=application/json")
		    public ResponseEntity<List<BinProveedor>> getProveedor(@RequestParam(value="nombre", required=false) String nombre){
				List<BinProveedor> proveedores = new ArrayList<BinProveedor>();
				
				if (nombre == null) {
					proveedores = _proveedorService.findAllProveedores();
			        if (proveedores.isEmpty()) {
			            return new ResponseEntity(HttpStatus.NO_CONTENT);
			            // You many decide to return HttpStatus.NOT_FOUND
			        }
					return new ResponseEntity<List<BinProveedor>>(proveedores, HttpStatus.OK);
				} else {
					BinProveedor proveedor = _proveedorService.findByName(nombre);
					if (proveedor == null) {
						return new ResponseEntity(HttpStatus.NOT_FOUND);
					}
					proveedores.add(proveedor);
					return new ResponseEntity<List<BinProveedor>>(proveedores, HttpStatus.OK);
				}		
		    }
			//FIND BY ID (BUSCAR POR RFC)
			@RequestMapping(value = "/proveedor/busrfc/{rfc}", method = RequestMethod.GET, headers = "Accept=application/json")
			    public ResponseEntity<BinProveedor> getProveedorByRfcProveedor(@PathVariable("rfc") String rfc){
					BinProveedor proveedor = _proveedorService.findByRfc(rfc);
			        if (proveedor == null) {
			            return new ResponseEntity(HttpStatus.NOT_FOUND);
			            // You many decide to return HttpStatus.NOT_FOUND
			        }
			        return new ResponseEntity<BinProveedor>(proveedor, HttpStatus.OK);
			    }
			//FIND BY NAME (BUSCAR POR NOMBRE)
			@RequestMapping(value = "/proveedores/busnom/{nombre_provedor}", method = RequestMethod.GET, headers = "Accept=application/json")
		    public ResponseEntity<BinProveedor> getProveedorByNombreProveedor(@PathVariable("nombre_provedor") String nombre_provedor){
				BinProveedor proveedor = _proveedorService.findByName(nombre_provedor);
		        if (proveedor == null) {
		            return new ResponseEntity(HttpStatus.NOT_FOUND);
		            // You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<BinProveedor>(proveedor, HttpStatus.OK);
		    }
			//UPDATE (ACTUALIZAR POR ID)
			@RequestMapping(value = "/proveedor/acturfc/{rfc}", method = RequestMethod.PATCH)
			public ResponseEntity<?> updateProveedorRfc(@PathVariable("rfc") String rfc, @RequestBody BinProveedor proveedor){
				
				BinProveedor currentProveedor = _proveedorService.findByRfc(rfc); // findById(id_usuario);
				
				if (currentProveedor == null) {
					return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del usuario por Id:  " + rfc),
		                    HttpStatus.NOT_FOUND);
				}
			
				//actualizar campos de usuario
				currentProveedor.setRfc(proveedor.getRfc());
				currentProveedor.setNombre_provedor(proveedor.getNombre_provedor());
				currentProveedor.setDomicilio_fiscal(proveedor.getDomicilio_fiscal());
				currentProveedor.setDomicilio_particular(proveedor.getDomicilio_particular());
				currentProveedor.setTelefono(proveedor.getTelefono());
				currentProveedor.setTelefono2(proveedor.getTelefono2());
				currentProveedor.setEmail(proveedor.getEmail());
				currentProveedor.setPag_web(proveedor.getPag_web());
				currentProveedor.setTipo_persona(proveedor.getTipo_persona());
				currentProveedor.setActivo(proveedor.getActivo());
		
				
				_proveedorService.updateProveedor(currentProveedor);		
				return new ResponseEntity<BinProveedor>(currentProveedor, HttpStatus.OK);			
			}
			
			
			
			//UPDATE (ACTUALIZAR POR NOMBRE)

			@RequestMapping(value = "/proveedor/actunom/{nombre_provedor}", method = RequestMethod.PATCH)
			public ResponseEntity<?> updateProveedorNombre(@PathVariable("nombre_provedor") String nombre_provedor, @RequestBody BinProveedor proveedor){
				
				BinProveedor currentProveedor = _proveedorService.findByName(nombre_provedor); // findById(id_usuario);
				
				if (currentProveedor == null) {
					return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del usuario por Id:  " + nombre_provedor),
		                    HttpStatus.NOT_FOUND);
				}
			
				//actualizar campos de usuario
				currentProveedor.setRfc(proveedor.getRfc());
				currentProveedor.setNombre_provedor(proveedor.getNombre_provedor());
				currentProveedor.setDomicilio_fiscal(proveedor.getDomicilio_fiscal());
				currentProveedor.setDomicilio_particular(proveedor.getDomicilio_particular());
				currentProveedor.setTelefono(proveedor.getTelefono());
				currentProveedor.setTelefono2(proveedor.getTelefono2());
				currentProveedor.setEmail(proveedor.getEmail());
				currentProveedor.setPag_web(proveedor.getPag_web());
				currentProveedor.setTipo_persona(proveedor.getTipo_persona());
				currentProveedor.setActivo(proveedor.getActivo());
			
				_proveedorService.updateProveedor(currentProveedor);		
				return new ResponseEntity<BinProveedor>(currentProveedor, HttpStatus.OK);			
			} 
			//DELETE (ELIMINAR POR ID)
			@RequestMapping(value = "/proveedor/elimrfc/{rfc}", method = RequestMethod.DELETE, headers = "Accept=application/json")
			public ResponseEntity<?> deleteProveedorRfc(@PathVariable("rfc") String rfc) {
			
				System.out.println("Id de usuario recibido: " + rfc);
			 
				BinProveedor proveedor = _proveedorService.findByRfc(rfc);
				
			    if (proveedor == null) {
			    	System.out.println("No se puede borrar el usuario por Id: " + rfc + "no se encuentra.");
			    	
			        return new ResponseEntity(new CustomErrorType("El usuario con Id: " + rfc + " no fué encontrado."),
			        HttpStatus.NOT_FOUND);
			    }
			    _proveedorService.deleteProvedorByRfc(rfc);
			        return new ResponseEntity<BinProveedor>(HttpStatus.NO_CONTENT);
			        
			}
			//DELETE (ELIMINAR POR NOMBRE)
			@RequestMapping(value = "/proveedor/elimnom/{nombre_provedor}", method = RequestMethod.DELETE, headers = "Accept=application/json")
			public ResponseEntity<?> deleteProvedorNombre(@PathVariable("nombre_provedor") String nombre_provedor) {
			
				System.out.println("Id de usuario recibido: " + nombre_provedor);
			 
				BinProveedor proveedor = _proveedorService.findByName(nombre_provedor);
				
			    if (proveedor == null) {
			    	System.out.println("No se puede borrar el usuario por Id: " + nombre_provedor + "no se encuentra.");
			    	
			        return new ResponseEntity(new CustomErrorType("El usuario con Id: " + nombre_provedor + " no fué encontrado."),
			        HttpStatus.NOT_FOUND);
			    }
			    _proveedorService.deleteProvedorByName(nombre_provedor);
			        return new ResponseEntity<BinUsuarioInventario>(HttpStatus.NO_CONTENT);
			        
			}
}
