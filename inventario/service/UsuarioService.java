package dgac.inventario.service;

import java.util.List;
import dgac.inventario.entidades.BinUsuarioInventario;

public interface UsuarioService {
	
	void saveUsuario(BinUsuarioInventario usuario);
	
	void deleteUsuarioById(int id_usuario);
	
	void deleteUsuarioByName(String nombre_completo);
	
	void updateUsuario(BinUsuarioInventario usuario);
	
	List<BinUsuarioInventario> findAllUsers();
	
	BinUsuarioInventario findById(int id_usuario);
	
	BinUsuarioInventario findByName(String nombre_completo);	
}
