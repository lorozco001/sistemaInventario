package dgac.inventario.dao;

import java.util.List;
import dgac.inventario.entidades.BinUsuarioInventario;

public interface UsuarioInventarioDao {
	
	void saveUsuario(BinUsuarioInventario usuario);//alta usuario	
	
	void deleteUsuarioById(int id_usuario);//baja usuario
	
	void deleteLogicoUsuarioByName(String nombre_completo);//baja usuario
	
	void updateUsuario(BinUsuarioInventario usuario);//editar usuario
	
	List<BinUsuarioInventario> findAllUsers();// consultar todos los usuarios
	
	BinUsuarioInventario findById(int id_usuario);//consultar usuario por id
	
	BinUsuarioInventario findByName(String nombre_completo);// consultar usuario por nombre

}
	

