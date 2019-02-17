package dgac.inventario.entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "factura")
public class BinFactura implements Serializable{

	public BinFactura() {
		
	}
	
	@Id
	@Column(name = "no_factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String no_factura;
	
	@Column(name = "rfc")
	private String rfc;
	
	@Column(name = "no_resguardo")
	private String no_resguardo;
	
	@Column(name = "fecha_emision")
	private Date fecha_emision;
	
	@Column(name = "anios_garantia")
	private int anios_garantia;
	
	@Column(name = "subtotal")
	private float subtotal;
	
	@Column(name = "iva")
	private float iva;
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "activo")
	private byte activo;
	
//	@OneToMany(mappedBy="factura",cascade= CascadeType.ALL)
//	@JsonIgnore
//	private Set<BinEquipo> equipo;
	
	public String getNo_factura() {
		return no_factura;
	}
	
	public void setNo_factura(String no_factura) {
		this.no_factura = no_factura;
	}
	
	public String getRfc() {
		return rfc;
	}
	
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	public String getNo_resguardo() {
		return no_resguardo;
	}
	
	public void setNo_resguardo(String no_resguardo) {
		this.no_resguardo = no_resguardo;
	}
	
	public Date getFecha_emision() {
		return fecha_emision;
	}
	
	public void setFecha_emision(Date fecha_emisión) {
		this.fecha_emision = fecha_emisión;
	}
	
	public int getAnios_garantia() {
		return anios_garantia;
	}
	
	public void setAnios_garantia(int anios_garantia) {
		this.anios_garantia = anios_garantia;
	}
	
	public float getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	public float getIva() {
		return iva;
	}
	
	public void setIva(float iva) {
		this.iva = iva;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}
}
