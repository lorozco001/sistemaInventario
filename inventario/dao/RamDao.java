package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinRam;;

public interface RamDao {

	void saveRam(BinRam ram);
	
	List<BinRam> findAllRam();
	
	BinRam findbyTipoRam(byte tipo_ram); //consultar por tipo de ram
	
	void updateRam(BinRam ram); //editar ram	
}
