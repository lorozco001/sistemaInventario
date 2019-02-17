package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinDiscoDuro;

public interface DiscoDuroService {


	void saveDiscoDuro(BinDiscoDuro discoDuro);
	
	List<BinDiscoDuro> findAllDiscoDuro();
	
	BinDiscoDuro findbyTipoDiscoDuro(String tipo_dd); //consultar por tipo de disco
	
	BinDiscoDuro findbyIdDiscoDuro(int id_disco_duro); //consultar por id disco
	
	void updatedDiscoDuro(BinDiscoDuro discoDuro); 

}
