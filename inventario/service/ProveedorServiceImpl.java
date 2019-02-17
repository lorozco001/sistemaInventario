package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.ProveedorDao;
import dgac.inventario.entidades.BinProveedor;

@Service("proveedorService")
@Transactional
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorDao _proveedorDao;
	
	@Override
	public void saveProveedor(BinProveedor proveedor) {
		_proveedorDao.saveProveedor(proveedor);		
	}

	@Override
	public void deleteProvedorByRfc(String rfc) {
		_proveedorDao.deleteLogicoProvedorByRfc(rfc);
		
	}

	@Override
	public void updateProveedor(BinProveedor proveedor) {
		_proveedorDao.updateProveedor(proveedor);
		
	}

	@Override
	public List<BinProveedor> findAllProveedores() {
		List<BinProveedor> listaProveedores = _proveedorDao.findAllProveedores();
		return listaProveedores;
	}

	@Override
	public BinProveedor findByRfc(String rfc) {
		BinProveedor proveedor =_proveedorDao.findByRfc(rfc);
		return proveedor;
	}

	@Override
	public BinProveedor findByName(String nombre_provedor) {
		BinProveedor proveedor =_proveedorDao.findByName(nombre_provedor);
		return proveedor;
	}

	@Override
	public void deleteProvedorByName(String nombre_provedor) {
		// TODO Auto-generated method stub
		_proveedorDao.deleteProvedorByName(nombre_provedor);
	}

}
