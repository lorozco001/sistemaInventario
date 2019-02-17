package dgac.inventario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgac.inventario.dao.FacturaDao;
import dgac.inventario.entidades.BinFactura;

@Service("facturaService")
@Transactional
public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private FacturaDao _facturaDao;
	
	@Override
	public void saveFactura(BinFactura factura) {
		_facturaDao.saveFactura(factura);
	}

	@Override
	public List<BinFactura> findAllFacturas() {
		return _facturaDao.findAllFacturas();
	}

	@Override
	public BinFactura findbyNoFactura(String no_factura) {		
		return _facturaDao.findbyNoFactura(no_factura);
	}

	@Override
	public void updateFactura(BinFactura factura) {		
		_facturaDao.updateFactura(factura);		
	}

	@Override
	public void deleteFactura(String no_factura) {		
		_facturaDao.deleteLogicoFactura(no_factura);		
	}

}
