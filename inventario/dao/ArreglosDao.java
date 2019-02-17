package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinArreglos;;

public interface ArreglosDao {

	void saveArreglos(BinArreglos arreglos);//Alta Arreglo

	List<BinArreglos> findAllArreglos();
	
	BinArreglos findbyNoInventario(int no_inventario); //consultar por id disco
	
	void updateArreglos (BinArreglos arreglos); //editar arreglo
	

}

