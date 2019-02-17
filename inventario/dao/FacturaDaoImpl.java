package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinEquipo;
import dgac.inventario.entidades.BinFactura;

@Repository
@Transactional
public class FacturaDaoImpl extends AbstractSession implements FacturaDao {

	//crear nueva factura
	@Override
	public void saveFactura(BinFactura factura) {
		
		getSession().persist(factura);
	}

	//buscar y listar todas las facturas
	@Override
	public List<BinFactura> findAllFacturas() {
		
		return getSession().createQuery("from BinFactura where activo=1").list();
	}

	//buscar una factura por su numero
	@Override
	public BinFactura findbyNoFactura(String no_factura) {
		
		return (BinFactura) getSession().get(BinFactura.class, no_factura);
	}

	@Override
	public void updateFactura(BinFactura factura) {
		
		getSession().update(factura);
	}

	@Override
	public void deleteLogicoFactura(String no_factura) {
		
		//busca la existencia de una factuar por su numero de factura
		BinFactura factura = findbyNoFactura(no_factura);
		factura.setActivo((byte)0);
		
		//si lo encuentra, lo borra  
		if (factura != null) {
			getSession().update(factura);
		}
		
	}
	
}
