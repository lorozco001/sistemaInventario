package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.EquipoDao;
import dgac.inventario.entidades.BinEquipo;

@Service("equipoService")
@Transactional
public class EquipoServiceImpl implements EquipoService{
	
	@Autowired
	private EquipoDao _equipoDao;
	
	@Override
	public void saveEquipo(BinEquipo equipo) {
		
		_equipoDao.saveEquipo(equipo);		
	}
	
	@Override
	public List<BinEquipo> findAllEquipos() {
		
		return _equipoDao.findAllEquipos();
	}

	@Override
	public void updateEquipo(BinEquipo equipo) {
		
		_equipoDao.updateEquipo(equipo);
	}

	@Override
	public BinEquipo findbyNoInventario(int no_inventario) {		
		
		return _equipoDao.findbyNoInventario(no_inventario);
	}

	@Override
	public void deleteEquipoByNoInventario(int no_inventario) {
		
		_equipoDao.deleteLogicoEquipoByNoInventario(no_inventario);
	}

}
