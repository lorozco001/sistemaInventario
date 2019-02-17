package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinProcesador;

public interface ProcesadorService {
	
	void saveProcesador(BinProcesador procesador);	//alta procesador	
	
	List<BinProcesador> findAllProcesadores(); //consultar todos los procesadores	
	
	BinProcesador findbyID(int id_procesador); //consultar por id de procesador 	
	
	void updateProcesador(BinProcesador procesador); //editar procesador	
	
	//void deleteProcesadorByNoInventario(int no_inventario); //baja procesador

}
