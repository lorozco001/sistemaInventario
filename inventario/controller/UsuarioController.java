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
import dgac.inventario.entidades.*;
import dgac.inventario.service.*;

@Controller
@RequestMapping(value="/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService _usuarioService;
	
	   //CREATE(CREAR USUARIO)
		@RequestMapping(value = "/usuario", method = RequestMethod.POST, headers = "Accept=application/json")
		public ResponseEntity<?> createUsuario(@RequestBody BinUsuarioInventario usuario, UriComponentsBuilder ucBuilder) {
			if (_usuarioService.findByName(usuario.getNombre_completo()) != null) {
				return new ResponseEntity(new CustomErrorType("No se puede crear usuario con el nombre  " + 
            		usuario.getNombre_completo() + " ya esxiste"),HttpStatus.CONFLICT);
			}
		_usuarioService.saveUsuario(usuario);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/v1/usuario/{id}").buildAndExpand(usuario.getId_usuario()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
	
	    //GET (OBTENER USUARIOS)
		@RequestMapping(value = "/usuarios", method = RequestMethod.GET, headers = "Accept=application/json")
	    public ResponseEntity<List<BinUsuarioInventario>> getUsuario(@RequestParam(value="nombre", required=false) String nombre){
			List<BinUsuarioInventario> usuarios = new ArrayList<BinUsuarioInventario>();
			
			if (nombre == null) {
				usuarios = _usuarioService.findAllUsers();
		        if (usuarios.isEmpty()) {
		            return new ResponseEntity(HttpStatus.NO_CONTENT);
		            // You many decide to return HttpStatus.NOT_FOUND
		        }
				return new ResponseEntity<List<BinUsuarioInventario>>(usuarios, HttpStatus.OK);
			} else {
				BinUsuarioInventario usuario = _usuarioService.findByName(nombre);
				if (usuario == null) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
				}
				usuarios.add(usuario);
				return new ResponseEntity<List<BinUsuarioInventario>>(usuarios, HttpStatus.OK);
			}		
	    }
	
		//FIND BY ID (BUSCAR POR ID)
		@RequestMapping(value = "/usuarios/busid/{id_usuario}", method = RequestMethod.GET, headers = "Accept=application/json")
		    public ResponseEntity<BinUsuarioInventario> getUsuarioByIdUsuario(@PathVariable("id_usuario") int id_usuario){
				BinUsuarioInventario usuario = _usuarioService.findById(id_usuario);
		        if (usuario == null) {
		            return new ResponseEntity(HttpStatus.NOT_FOUND);
		            // You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<BinUsuarioInventario>(usuario, HttpStatus.OK);
		    }
	
		//FIND BY ID (BUSCAR POR NOMBRE)
		@RequestMapping(value = "/usuarios/busnom/{nombre_completo}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public ResponseEntity<BinUsuarioInventario> getUsuarioByNombreUsuario(@PathVariable("nombre_completo") String nombre_competo){
			BinUsuarioInventario usuario = _usuarioService.findByName(nombre_competo);
	        if (usuario == null) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<BinUsuarioInventario>(usuario, HttpStatus.OK);
	    }
		
		//UPDATE (ACTUALIZAR POR ID)
		@RequestMapping(value = "/usuarios/actuid/{id_usuario}", method = RequestMethod.PATCH)
		public ResponseEntity<?> updateUsuario(@PathVariable("id_usuario") int id_usuario, @RequestBody BinUsuarioInventario usuario){
			
			BinUsuarioInventario currentUsuario = _usuarioService.findById(id_usuario);
			
			if (currentUsuario == null) {
				return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del usuario por Id:  " + id_usuario),
	                    HttpStatus.NOT_FOUND);
			}
		
			//actualizar campos de usuario
			currentUsuario.setId_usuario(usuario.getId_usuario());
			currentUsuario.setId_area_dgac(usuario.getId_area_dgac());
			currentUsuario.setNo_empleado(usuario.getNo_empleado());
			currentUsuario.setTipo_usuario(usuario.getTipo_usuario());
			currentUsuario.setNombre_completo(usuario.getNombre_completo());
			currentUsuario.setPerfil_usuario(usuario.getPerfil_usuario());
			
			_usuarioService.updateUsuario(currentUsuario);		
			return new ResponseEntity<BinUsuarioInventario>(currentUsuario, HttpStatus.OK);			
		} 
		
		//UPDATE (ACTUALIZAR POR NOMBRE)
		@RequestMapping(value = "/usuarios/actunom/{nombre_completo}", method = RequestMethod.PATCH)
		public ResponseEntity<?> updateUsuario(@PathVariable("nombre_completo") String nombre_completo, @RequestBody BinUsuarioInventario usuario){
			
			BinUsuarioInventario currentUsuario = _usuarioService.findByName(nombre_completo);
			
			if (currentUsuario == null) {
				return new ResponseEntity(new CustomErrorType("No se puede actualizar los datos del usuario con Nombre:  " + nombre_completo),
		                   HttpStatus.NOT_FOUND);
			}
		
			//actualizar campos de usuario
			currentUsuario.setId_usuario(usuario.getId_usuario());
			currentUsuario.setId_area_dgac(usuario.getId_area_dgac());
			currentUsuario.setNo_empleado(usuario.getNo_empleado());
			currentUsuario.setTipo_usuario(usuario.getTipo_usuario());
			currentUsuario.setNombre_completo(usuario.getNombre_completo());
			currentUsuario.setPerfil_usuario(usuario.getPerfil_usuario());
			
			_usuarioService.updateUsuario(currentUsuario);	
			return new ResponseEntity<BinUsuarioInventario>(currentUsuario, HttpStatus.OK);			
		}
		//DELETE (ELIMINAR POR ID)
		@RequestMapping(value = "/usuarios/elimid/{id_usuario}", method = RequestMethod.DELETE, headers = "Accept=application/json")
		public ResponseEntity<?> deleteUsuario(@PathVariable("id_usuario") int id_usuario) {
		
			System.out.println("Id de usuario recibido: " + id_usuario);
		 
			BinUsuarioInventario usuario = _usuarioService.findById(id_usuario);
			
		    if (usuario == null) {
		    	System.out.println("No se puede borrar el usuario por Id: " + id_usuario + "no se encuentra.");
		    	
		        return new ResponseEntity(new CustomErrorType("El usuario con Id: " + id_usuario + " no fué encontrado."),
		        HttpStatus.NOT_FOUND);
		    }
		    _usuarioService.deleteUsuarioById(id_usuario);
		        return new ResponseEntity<BinUsuarioInventario>(HttpStatus.NO_CONTENT);
		        
		}
		//DELETE (ELIMINAR POR NOMBRE)
		@RequestMapping(value = "/usuarios/elimnom/{nombre_completo}", method = RequestMethod.DELETE, headers = "Accept=application/json")
		public ResponseEntity<?> deleteUsuario(@PathVariable("nombre_completo") String nombre_completo) {
		
			System.out.println("Id de usuario recibido: " + nombre_completo);
		 
			BinUsuarioInventario usuario = _usuarioService.findByName(nombre_completo);
			
		    if (usuario == null) {
		    	System.out.println("No se puede borrar el usuario por Id: " + nombre_completo + "no se encuentra.");
		    	
		        return new ResponseEntity(new CustomErrorType("El usuario con Id: " + nombre_completo+ " no fué encontrado."),
		        HttpStatus.NOT_FOUND);
		    }
		    _usuarioService.deleteUsuarioByName(nombre_completo);
		        return new ResponseEntity<BinUsuarioInventario>(HttpStatus.NO_CONTENT);
		        
		}
}
