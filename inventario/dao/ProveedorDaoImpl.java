package dgac.inventario.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import dgac.inventario.entidades.BinProveedor;


@Repository
@Transactional
public class ProveedorDaoImpl extends AbstractSession implements ProveedorDao{

	//insertar proveedor
	public void saveProveedor(BinProveedor proveedor) {
		getSession().persist(proveedor);
	}
	
	//eliminar proveedor por pfc
	public void deleteLogicoProvedorByRfc(String rfc) {
		BinProveedor proveedor = findByRfc(rfc);
		if (proveedor != null) {			
			getSession().delete(proveedor);	
		}	
	}

	//actualizar proveedor
	public void updateProveedor(BinProveedor proveedor) {
			getSession().update(proveedor);
		
	}

	//listar todos los proveedores
	@SuppressWarnings("unchecked") //para suprimir avisos
	public List<BinProveedor> findAllProveedores() {
		return getSession().createQuery("select rfc, nombre_provedor, telefono, telefono2, pag_web from BinProveedor").list();
	}

	//buscar proveedor por rfc
	public BinProveedor findByRfc(String rfc) {
		return (BinProveedor) getSession().get(BinProveedor.class, rfc);
//		return (BinProveedor) getSession().createQuery(
//				"from BinProveedor where rfc = :rfc")
//				.setParameter("rfc",rfc ).uniqueResult();
	}

	@Override
	public BinProveedor findByName(String nombre_provedor) {
		return (BinProveedor) getSession().createQuery(
				"from BinProveedor where nombre_provedor = :nombre_provedor")
		         .setParameter("nombre_provedor", nombre_provedor).uniqueResult();
	}

	@Override
	public void deleteProvedorByName(String nombre_provedor) {
		BinProveedor proveedor = findByName(nombre_provedor);
		if (proveedor != null) {			
			getSession().delete(proveedor);	
		
		}

	}

}
