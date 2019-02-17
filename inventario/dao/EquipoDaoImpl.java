package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinEquipo;

@Repository
@Transactional
public class EquipoDaoImpl extends AbstractSession implements EquipoDao{

	@Override
	public void saveEquipo(BinEquipo equipo) {
		getSession().persist(equipo);		
	}

	@Override
	public List<BinEquipo> findAllEquipos() {
		return getSession().createQuery("select no_inventario, marca, modelo, tipo_equipo, os, os_version from BinEquipo where activo=1").list();
	}

	//editar o actualizar equipo
	@Override
	public void updateEquipo(BinEquipo equipo) {	
		getSession().update(equipo);		

	}

	@Override
	public void deleteLogicoEquipoByNoInventario(int no_inventario) {
		
		//busca la existencia de un  equipo por su numero de inventario
		BinEquipo equipo = findbyNoInventario(no_inventario);
		//actualiza el estatus del equipo
		equipo.setActivo((byte)0);
		
		//si lo encuentra, lo borra
		if (equipo != null) {
			getSession().update(equipo);
		}
				
	}

	//buscar equipo por numero de inventario
	@Override
	public BinEquipo findbyNoInventario(int no_inventario) {
	
		return (BinEquipo) getSession().get(BinEquipo.class, no_inventario);
	}
	
}
