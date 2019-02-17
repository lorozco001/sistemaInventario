package dgac.inventario.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import dgac.inventario.entidades.BinUsuarioInventario;

@Repository
@Transactional
public class UsuarioInventarioImpl extends AbstractSession implements UsuarioInventarioDao{

	//insert 
	public void saveUsuario(BinUsuarioInventario usuario) {
		getSession().persist(usuario);
	}
	
	//borrar usuario
	public void deleteUsuarioById(int id_usuario) {
		BinUsuarioInventario usuario = findById(id_usuario);
		if (usuario != null) {			
			getSession().delete(usuario);	
		}
	}
	
	//actualizar un usuario
	public void updateUsuario(BinUsuarioInventario usuario) {
		getSession().update(usuario);
	}
	
	//listar todos los usuarios
	@SuppressWarnings("unchecked") //para suprimir avisos 
	public List<BinUsuarioInventario> findAllUsers(){
		return getSession().createQuery("from BinUsuarioInventario").list();
	}
	
	//buscar usuarios por id
	public BinUsuarioInventario findById(int id_usuario) {
		
		return (BinUsuarioInventario) getSession().get(BinUsuarioInventario.class, id_usuario);
	}
	
	//buscar usuario por nombre
	public BinUsuarioInventario findByName(String nombre_completo) {
		return (BinUsuarioInventario) getSession().createQuery(
				"from BinUsuarioInventario where nombre_completo = :nombre_completo")
				.setParameter("nombre_completo", nombre_completo).uniqueResult();
	}

}
