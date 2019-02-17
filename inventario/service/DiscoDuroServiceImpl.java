package dgac.inventario.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.DiscoDuroDao;
import dgac.inventario.entidades.BinDiscoDuro;

@Service("discoDuroService")
@Transactional
public class DiscoDuroServiceImpl implements DiscoDuroService{

	@Autowired
	private DiscoDuroDao _discoDuroDao;
	
	@Override
	public void saveDiscoDuro(BinDiscoDuro discoDuro) {
		_discoDuroDao.saveDiscoDuro(discoDuro);
	}

	@Override
	public List<BinDiscoDuro> findAllDiscoDuro() {
		return _discoDuroDao.findAllDiscoDuro();
	}

	@Override
	public BinDiscoDuro findbyTipoDiscoDuro(String tipo_dd) {
		return _discoDuroDao.findbyTipoDiscoDuro(tipo_dd);
	}

	@Override
	public void updatedDiscoDuro(BinDiscoDuro discoDuro) {
		_discoDuroDao.updatedDiscoDuro(discoDuro);
	}

	@Override
	public BinDiscoDuro findbyIdDiscoDuro(int id_disco_duro) {
		return _discoDuroDao.findbyIdDiscoDuro(id_disco_duro);
	}

}
