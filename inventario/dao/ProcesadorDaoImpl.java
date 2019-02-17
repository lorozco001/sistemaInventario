package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinEquipo;
import dgac.inventario.entidades.BinProcesador;

@Repository
@Transactional
public class ProcesadorDaoImpl extends AbstractSession implements ProcesadorDao {

	//guardar datos de procesador
	@Override
	public void saveProcesador(BinProcesador procesador) {		
		getSession().persist(procesador);		
	}

	//listar todos los datos de un procesador
	@Override
	public List<BinProcesador> findAllProcesadores() {	
		return getSession().createQuery("from BinProcesador").list();
	}

	//buscar procesadores por id
	@Override
	public BinProcesador findbyID(int id_procesador) {		
		return (BinProcesador) getSession().get(BinProcesador.class, id_procesador);
	}

	//actualizar los datos del procesador
	@Override
	public void updateProcesador(BinProcesador procesador) {		
		getSession().update(procesador);		
	}

}
