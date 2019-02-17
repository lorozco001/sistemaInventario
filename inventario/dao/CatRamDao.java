package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinCatRam;

public interface CatRamDao {

	void saveCatRam(BinCatRam catRam);
	
	List<BinCatRam> findAllCatRam();
	
	BinCatRam findByNombreRam(String nombre_ram);
	
	void updateCatRam(BinCatRam catRam); //editar ram	
}
