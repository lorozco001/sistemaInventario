package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinCatProcesador;

public interface CatProcesadorDao {

	void saveCatProceasdor(BinCatProcesador catProcesador);
	
	List<BinCatProcesador> findAllCatProcesador();
	
	BinCatProcesador findByNombreProcesador(String nombre_procesador);
	
	void updateCatProcesador(BinCatProcesador catProcesador); //editar procesador	
}
