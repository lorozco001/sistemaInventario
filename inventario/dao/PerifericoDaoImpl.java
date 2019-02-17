package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinEquipo;
import dgac.inventario.entidades.BinPeriferico;

@Repository
@Transactional
public class PerifericoDaoImpl extends AbstractSession implements PerifericoDao{

	@Override
	public void savePeriferico(BinPeriferico periferico) {
		getSession().persist(periferico);
	}

	@Override
	public List<BinPeriferico> findAllPerifericos() {
		return getSession().createQuery("from BinPeriferico").list();
	}

	@Override
	public void updatePeriferico(BinPeriferico periferico) {
		getSession().update(periferico);
	}

	@Override
	public BinPeriferico findbyNumSerie(String num_serie) {
		return (BinPeriferico) getSession().get(BinPeriferico.class, num_serie);
	}

	@Override
	public void deleteLogicoEquipoByNumSerie(String num_serie) {
		//busca la existencia de un  equipo por su numero de inventario
		BinPeriferico periferico = findbyNumSerie(num_serie);
		
		//actualiza el estatus del equipo
		periferico.setActivo((byte)0);
				
		//si lo encuentra, lo borra
		if (periferico != null) {
			getSession().update(periferico);
		}
	}

}
