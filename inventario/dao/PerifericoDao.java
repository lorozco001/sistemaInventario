package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinPeriferico;;

public interface PerifericoDao {

	void savePeriferico(BinPeriferico periferico);	//alta 	
	
	List<BinPeriferico> findAllPerifericos(); //consultar todos 
	
	BinPeriferico findbyNumSerie(String num_serie); //consultar por numero de serie	
	
	void updatePeriferico(BinPeriferico periferico); //editar 	
	
	void deleteLogicoEquipoByNumSerie(String num_serie); //baja 
}
