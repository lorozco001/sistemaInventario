package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.CatRamDao;
import dgac.inventario.entidades.BinCatRam;

@Service("catRamService")
@Transactional
public class CatRamServiceImpl implements CatRamService{

	@Autowired
	private CatRamDao _catRamDao;
	
	@Override
	public void saveCatRam(BinCatRam catRam) {		
		_catRamDao.saveCatRam(catRam);		
	}

	@Override
	public List<BinCatRam> findAllCatRam() {		
		return _catRamDao.findAllCatRam();
	}

	@Override
	public void updateCatRam(BinCatRam catRam) {
		_catRamDao.updateCatRam(catRam);		
	}

	@Override
	public BinCatRam findByNombreRam(String nombre_ram) {		
		return _catRamDao.findByNombreRam(nombre_ram);
	}

}
