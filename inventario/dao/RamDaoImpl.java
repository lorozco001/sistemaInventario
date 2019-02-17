package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinFactura;
import dgac.inventario.entidades.BinRam;

@Repository
@Transactional
public class RamDaoImpl extends AbstractSession implements RamDao {

	@Override
	public void saveRam(BinRam ram) {
		getSession().persist(ram);
	}

	@Override
	public List<BinRam> findAllRam() {
		return getSession().createQuery("from BinRam").list();
	}

	@Override
	public BinRam findbyTipoRam(byte tipo_ram) {
		return (BinRam) getSession().get(BinRam.class, tipo_ram);
	}

	@Override
	public void updateRam(BinRam ram) {
		getSession().update(ram);		
	}

	
}
