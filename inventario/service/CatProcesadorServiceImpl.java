package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.CatProcesadorDao;
import dgac.inventario.entidades.BinCatProcesador;

@Service("catProcesadorService")
@Transactional
public class CatProcesadorServiceImpl implements CatProcesadorService {

	@Autowired
	private CatProcesadorDao _catProcesadorDao;
	
	@Override
	public void saveCatProceasdor(BinCatProcesador catProcesador) {
		_catProcesadorDao.saveCatProceasdor(catProcesador);
		
	}

	@Override
	public List<BinCatProcesador> findAllCatProcesador() {
		return _catProcesadorDao.findAllCatProcesador();
	}

	@Override
	public BinCatProcesador findByNombreProcesador(String nombre_procesador) {
		return _catProcesadorDao.findByNombreProcesador(nombre_procesador);
	}

	@Override
	public void updateCatProcesador(BinCatProcesador catProcesador) {
		
		_catProcesadorDao.updateCatProcesador(catProcesador);
	}

}
