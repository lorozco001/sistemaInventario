package dgac.inventario.service;

import java.util.List;
import dgac.inventario.entidades.BinProveedor;

public interface ProveedorService {

	void saveProveedor(BinProveedor proveedor);//alta proveedor
	
	void deleteProvedorByRfc(String rfc);//eliminar proveedor
	
	void deleteProvedorByName(String nombre_provedor);
	
	void updateProveedor(BinProveedor proveedor);//editar proveedor
	
	List<BinProveedor> findAllProveedores();// consultar todos los proveedores
	
	BinProveedor findByRfc(String rfc);// consultar proveedor por rfc
	
	BinProveedor findByName(String nombre_provedor);// consultar proveedor por rfc
}
