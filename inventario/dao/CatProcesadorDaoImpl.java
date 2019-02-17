package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinCatProcesador;

@Repository
@Transactional
public class CatProcesadorDaoImpl extends AbstractSession implements CatProcesadorDao {

	@Override
	public void saveCatProceasdor(BinCatProcesador catProcesador) {
		getSession().persist(catProcesador);		
	}

	@Override
	public List<BinCatProcesador> findAllCatProcesador() {
		return getSession().createQuery("from BinCatProcesador").list();
	}

	@Override
	public BinCatProcesador findByNombreProcesador(String nombre_procesador) {
		return (BinCatProcesador) getSession().get(BinCatProcesador.class, nombre_procesador);
	}

	@Override
	public void updateCatProcesador(BinCatProcesador catProcesador) {		
		getSession().update(catProcesador);
	}

}
