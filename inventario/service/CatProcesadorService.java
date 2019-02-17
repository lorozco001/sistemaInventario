package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinCatProcesador;

public interface CatProcesadorService {

	void saveCatProceasdor(BinCatProcesador catProcesador);
	
	List<BinCatProcesador> findAllCatProcesador();
	
	BinCatProcesador findByNombreProcesador(String nombre_procesador);
	
	void updateCatProcesador(BinCatProcesador catProcesador); //editar procesador	
}
