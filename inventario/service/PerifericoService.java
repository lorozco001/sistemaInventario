package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinPeriferico;

public interface PerifericoService {
	
	void savePeriferico(BinPeriferico periferico);	//alta 	
	
	List<BinPeriferico> findAllPerifericos(); //consultar todos 
	
	BinPeriferico findbyNumSerie(String num_serie); //consultar por numero de serie	
	
	void updatePeriferico(BinPeriferico periferico); //editar 	
	
	void deleteEquipoByNumSerie(String num_serie); //baja 
}
