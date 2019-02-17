package dgac.inventario.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "periferico")
public class BinPeriferico implements Serializable{
	
	public BinPeriferico() {
		
	}
	
	@Id
	@Column(name="no_factura")
	private String no_factura; 
	
	@Column(name="num_serie")
	private String num_serie; 
	
	@Column(name="id_tipos_eq_perifs")
	private int id_tipos_eq_perifs; 
	
	@Column(name="id_usuario")
	private int id_usuario; 
	
	@Column(name="id_responsable")
	private int id_responsable;
	
	@Column(name="no_inventario")
	private int no_inventario; 
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modelo")
	private String modelo; 
	
	@Column(name="localizacion")
	private String localizacion;
	
	@Column(name="interfaz")
	private String interfaz;
	
	@Column(name="nucleos")
	private int nucleos;
	
	@Column(name="memoria")
	private String  memoria; 
	
	@Column(name="velocidad")
	private String velocidad;  
	
	@Column(name="cantidad")
	private int cantidad; 
	
	@Column(name="ip4")
	private String ip4; 
	
	@Column(name="ip6")
	private String ip6;	
	
	@Column(name="observaciones")
	private String observaciones; 
	
	@Column(name="know_how")
	private String know_how;

	@Column(name="activo")
	private byte activo;
	
	
	public String getNo_factura() {
		return no_factura;
	}

	public void setNo_factura(String no_factura) {
		this.no_factura = no_factura;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public int getId_tipos_eq_perifs() {
		return id_tipos_eq_perifs;
	}

	public void setId_tipos_eq_perifs(int id_tipos_eq_perifs) {
		this.id_tipos_eq_perifs = id_tipos_eq_perifs;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	public int getNo_inventario() {
		return no_inventario;
	}

	public void setNo_inventario(int no_inventario) {
		this.no_inventario = no_inventario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}

	public int getNucleos() {
		return nucleos;
	}

	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getIp4() {
		return ip4;
	}

	public void setIp4(String ip4) {
		this.ip4 = ip4;
	}

	public String getIp6() {
		return ip6;
	}

	public void setIp6(String ip6) {
		this.ip6 = ip6;
	}		
	
	public String getKnow_how() {
		return know_how;
	}

	public void setKnow_how(String know_how) {
		this.know_how = know_how;
	}

	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

}
