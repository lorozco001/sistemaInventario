package dgac.inventario.service;

import java.util.List;


import dgac.inventario.entidades.BinArreglos;

public interface ArreglosService {

	void saveArreglos(BinArreglos arreglo);
	
	List<BinArreglos> findAllArreglos();
	
	BinArreglos findbyNoInventario(int no_inventario); //consultar por id disco
	
	void updateArreglos(BinArreglos arreglo); 

}
