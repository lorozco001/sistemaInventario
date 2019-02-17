package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.RamDao;
import dgac.inventario.entidades.BinRam;

@Service("ramService")
@Transactional
public class RamServiceImpl implements RamService {

	@Autowired
	private RamDao _ramDao;
	
	@Override
	public void saveRam(BinRam ram) {
		_ramDao.saveRam(ram);
	}

	@Override
	public List<BinRam> findAllRam() {
		return _ramDao.findAllRam();
	}

	@Override
	public BinRam findbyTipoRam(byte tipo_ram) {
		return _ramDao.findbyTipoRam(tipo_ram);
	}

	@Override
	public void updateRam(BinRam ram) {
		_ramDao.updateRam(ram);
	}

}
