package dgac.inventario.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dgac.inventario.dao.UsuarioInventarioDao;
import dgac.inventario.entidades.BinUsuarioInventario;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioInventarioDao _usuarioDao;

	@Override
	public void saveUsuario(BinUsuarioInventario usuario) {
		_usuarioDao.saveUsuario(usuario);
		
	}

	@Override
	public void deleteUsuarioById(int id_usuario) {
		_usuarioDao.deleteUsuarioById(id_usuario);
	}
	
	@Override
	public void deleteUsuarioByName(String nombre_completo) {
		_usuarioDao.deleteLogicoUsuarioByName(nombre_completo);
	}

	@Override
	public void updateUsuario(BinUsuarioInventario usuario) {
		_usuarioDao.updateUsuario(usuario);
	}

	@Override
	public List<BinUsuarioInventario> findAllUsers() {
		List<BinUsuarioInventario> listaUsuarios = _usuarioDao.findAllUsers();
		return listaUsuarios;
	}

	@Override
	public BinUsuarioInventario findById(int id_usuario) {
		BinUsuarioInventario usuario = _usuarioDao.findById(id_usuario);
		return usuario;
	}

	@Override
	public BinUsuarioInventario findByName(String nombre_completo) {
		BinUsuarioInventario usuario = _usuarioDao.findByName(nombre_completo);
		return usuario;
	}
	
	
	
}
