package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinFactura;

public interface FacturaService {

	void saveFactura(BinFactura factura);
	
	List<BinFactura> findAllFacturas();
	
	BinFactura findbyNoFactura(String no_factura); //consultar por numero de factura
	
	void updateFactura(BinFactura factura); //editar factura	
	
	void deleteFactura(String no_factura); //baja factura
}
