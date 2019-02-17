package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.ProcesadorDao;
import dgac.inventario.entidades.BinProcesador;

@Service("procesadorService")
@Transactional
public class ProcesadorServiceImpl implements ProcesadorService {
	
	@Autowired
	private ProcesadorDao _ProcesadorDao;

	@Override
	public void saveProcesador(BinProcesador procesador) {
		_ProcesadorDao.saveProcesador(procesador);	
	}

	@Override
	public List<BinProcesador> findAllProcesadores() {		
		return _ProcesadorDao.findAllProcesadores();
	}

	@Override
	public BinProcesador findbyID(int id_procesador) {		
		return _ProcesadorDao.findbyID(id_procesador);
	}

	@Override
	public void updateProcesador(BinProcesador procesador) {		
		_ProcesadorDao.updateProcesador(procesador);
	}

}
