package dgac.inventario.service;

import java.util.List;

import dgac.inventario.entidades.BinEquipo;

public interface EquipoService {
	
	void saveEquipo(BinEquipo equipo);
	
	List<BinEquipo> findAllEquipos();
	
	BinEquipo findbyNoInventario(int no_inventario);
	
	void updateEquipo(BinEquipo equipo);
	
	void deleteEquipoByNoInventario(int no_inventario);
}
