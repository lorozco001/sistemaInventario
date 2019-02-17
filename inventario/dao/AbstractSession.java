package dgac.inventario.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractSession {
	
	// para que spring busque la configuracion que hicimos de la base de datos (inyeccion de dependecias)
	
	@Autowired 
	@Qualifier("sessionInventario")
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sessionDgac")
	private SessionFactory sessionFactoryDgacDb;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected Session getSession2() {
		return sessionFactoryDgacDb.getCurrentSession();
	}
}
