package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinCatRam;

public interface CatRamService {

	void saveCatRam(BinCatRam catRam);
	
	List<BinCatRam> findAllCatRam();
	
	BinCatRam findByNombreRam(String nombre_ram);
	
	void updateCatRam(BinCatRam catRam); //editar ram	
}
