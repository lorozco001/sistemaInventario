package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinCatRam;
import dgac.inventario.entidades.BinFactura;

@Repository
@Transactional
public class CatRamDaoImpl extends AbstractSession implements CatRamDao {

	@Override
	public void saveCatRam(BinCatRam catRam) {		
		getSession().persist(catRam);
	}

	@Override
	public List<BinCatRam> findAllCatRam() {
		return getSession().createQuery("from BinCatRam").list();
	}

	@Override
	public void updateCatRam(BinCatRam catRam) {		
		getSession().update(catRam);	
	}

	@Override
	public BinCatRam findByNombreRam(String nombre_ram) {
		return (BinCatRam) getSession().get(BinCatRam.class, nombre_ram);
	}

}
