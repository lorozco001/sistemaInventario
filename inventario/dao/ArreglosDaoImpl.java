package dgac.inventario.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dgac.inventario.entidades.BinArreglos;

@Repository
@Transactional
public class ArreglosDaoImpl extends AbstractSession implements ArreglosDao{

	@Override

	//guardar arreglo
	public void saveArreglos(BinArreglos arreglos) {
		getSession().persist(arreglos);		

	}

	@Override
	public List<BinArreglos> findAllArreglos() {
		return getSession().createQuery("from BinArreglos").list();
	}

	@Override


	public BinArreglos findbyNoInventario(int no_inventario) {
		return (BinArreglos) getSession().get(BinArreglos.class, no_inventario);
	}

	@Override
	public void updateArreglos(BinArreglos arreglo) {
		getSession().update(arreglo);

	}

}
