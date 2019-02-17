package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinRam;

public interface RamService {

	void saveRam(BinRam ram);
	
	List<BinRam> findAllRam();
	
	BinRam findbyTipoRam(byte tipo_ram); //consultar por tipo de ram
	
	void updateRam(BinRam ram); //editar ram	
}
