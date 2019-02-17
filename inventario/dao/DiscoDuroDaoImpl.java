package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinDiscoDuro;

@Repository
@Transactional
public class DiscoDuroDaoImpl extends AbstractSession implements DiscoDuroDao {

	@Override
	public void saveDiscoDuro(BinDiscoDuro discoDuro) {
		getSession().persist(discoDuro);
	}

	@Override
	public List<BinDiscoDuro> findAllDiscoDuro() {
		return getSession().createQuery("from BinDiscoDuro").list();
	}

	@Override
	public BinDiscoDuro findbyTipoDiscoDuro(String tipo_dd) {
		return (BinDiscoDuro) getSession().get(BinDiscoDuro.class, tipo_dd);
	}

	@Override
	public void updatedDiscoDuro(BinDiscoDuro discoDuro) {
		getSession().update(discoDuro);
	}

	@Override
	public BinDiscoDuro findbyIdDiscoDuro(int id_disco_duro) {
		return (BinDiscoDuro)getSession().get(BinDiscoDuro.class, id_disco_duro) ;

	}

}
