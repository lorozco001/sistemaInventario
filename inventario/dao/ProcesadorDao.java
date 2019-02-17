package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinProcesador;

public interface ProcesadorDao {

	void saveProcesador(BinProcesador procesador);	//alta procesador	
	
	List<BinProcesador> findAllProcesadores(); //consultar todos los procesadores	
	
	BinProcesador findbyID(int id_procesador); //consultar por id de procesador 	
	
	void updateProcesador(BinProcesador procesador); //editar procesador	
}
