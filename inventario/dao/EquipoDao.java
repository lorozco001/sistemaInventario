package dgac.inventario.dao;

import java.util.List;

import dgac.inventario.entidades.BinEquipo;

public interface EquipoDao {
	
	void saveEquipo(BinEquipo equipo);	//alta equipo	
	
	List<BinEquipo> findAllEquipos(); //consultar todos los equipos	
	
	BinEquipo findbyNoInventario(int no_inventario); //consultar por numero de inventario	
	
	void updateEquipo(BinEquipo equipo); //editar equipo	
	
	void deleteLogicoEquipoByNoInventario(int no_inventario); //baja equipo
}
