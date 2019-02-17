package dgac.inventario.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.ArreglosDao;
import dgac.inventario.entidades.BinArreglos;

@Service("arreglosService")
@Transactional
public class ArreglosServiceImpl implements ArreglosService {

	@Autowired
	private ArreglosDao _arreglosDao;
	
	@Override
	public void saveArreglos(BinArreglos arreglo) {
		_arreglosDao.saveArreglos(arreglo);
	}       

	@Override
	public List<BinArreglos> findAllArreglos() {
		return _arreglosDao.findAllArreglos();
	}

	@Override
	public BinArreglos findbyNoInventario(int no_inventario) {
		return _arreglosDao.findbyNoInventario(no_inventario);
	}

	@Override
	public void updateArreglos(BinArreglos arreglo) {
		_arreglosDao.updateArreglos(arreglo);
	}

}
