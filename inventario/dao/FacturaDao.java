package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinFactura;

public interface FacturaDao {

	void saveFactura(BinFactura factura);
	
	List<BinFactura> findAllFacturas();
	
	BinFactura findbyNoFactura(String no_factura); //consultar por numero de factura
	
	void updateFactura(BinFactura factura); //editar factura	
	
	void deleteLogicoFactura(String no_factura); //baja factura
}
