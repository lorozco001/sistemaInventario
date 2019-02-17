package dgac.inventario.dao;

import java.util.List;
import dgac.inventario.entidades.BinProveedor;


public interface ProveedorDao {

	void saveProveedor(BinProveedor proveedor);//alta proveedor
	
	void deleteLogicoProvedorByRfc(String rfc);//eliminar proveedor

	void deleteProvedorByName(String nombre_provedor);
	
	void updateProveedor(BinProveedor proveedor);//editar proveedor
	
	List<BinProveedor> findAllProveedores();// consultar todos los proveedores
	
	BinProveedor findByRfc(String rfc);// consultar proveedor por rfc

	BinProveedor findByName(String nombre_provedor);// consultar proveedor por nombre
}
