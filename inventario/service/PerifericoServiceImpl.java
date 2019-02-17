package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.PerifericoDao;
import dgac.inventario.entidades.BinPeriferico;

@Service("perifericoService")
@Transactional
public class PerifericoServiceImpl implements PerifericoService {

	@Autowired
	private PerifericoDao _perifericoDao;
	
	@Override
	public void savePeriferico(BinPeriferico periferico) {
		_perifericoDao.savePeriferico(periferico);
	}

	@Override
	public List<BinPeriferico> findAllPerifericos() {
		return _perifericoDao.findAllPerifericos();
	}

	@Override
	public BinPeriferico findbyNumSerie(String num_serie) {
		return _perifericoDao.findbyNumSerie(num_serie);
	}

	@Override
	public void updatePeriferico(BinPeriferico periferico) {
		_perifericoDao.updatePeriferico(periferico);
	}

	@Override
	public void deleteEquipoByNumSerie(String num_serie) {
		_perifericoDao.deleteLogicoEquipoByNumSerie(num_serie);
	}

}
