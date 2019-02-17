package dgac.inventario.entidades;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name="equipo")
public class BinEquipo implements Serializable {
	
	public BinEquipo () {
		
	}
	
	@Id
	@Column(name="no_inventario")
	private int no_inventario;	
			
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private BinUsuarioInventario usuario;
	
	@Column(name="id_responsable")
	private int id_responsable;
	
	@Column(name="no_factura")
	private String no_factura;
	
	@Column(name="no_serie")
	private String no_serie; 
	
	@Column(name="localizacion")
	private String localizacion; 
	
	@Column(name="marca")
	private String marca; 
	
	@Column(name="modelo")
	private String modelo;	
	
	@Column(name="tipo_equipo")
	private int tipo_equipo;
	
	@Column(name="num_arreglos")
	private int num_arreglos;
	
	@Column(name="tec_comunicacion")
	private int tec_comunicacion;
	
	@Column(name="tec_comunicacion_dif")
	private String  tec_comunicacion_dif;
	
	@Column(name="os")
	private int os; 
	
	@Column(name="os_version")
	private String os_version; 
	
	@Column(name="os_edicion")
	private String os_edicion; 
	
	@Column(name="os_arq")
	private int os_arq; 
	
	@Column(name="os_release")
	private String os_release; 
	
	@Column(name="num_procesadores")
	private int num_procesadores;
	
	@Column(name="num_ram_instaladas")
	private int num_ram_instaladas;
	
	@Column(name="tipo_licencia")
	private String tipo_licencia;
	
	@Column(name="licencia_inicio")
	private Date  licencia_inicio;
	
	@Column(name="licencia_fin")
	private Date  licencia_fin;
	
	@Column(name="unidad_optica")
	private String unidad_optica;
	
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

	//mapeo de la tabla equipo a la tabla trans_ram_equipo
//	@OneToMany(mappedBy="equipo",cascade= CascadeType.ALL)
//	@JsonIgnore
//	private Set<BinTransRamEquipo> trans_ram_equipos;

	
	public int getNo_inventario() {
		return no_inventario;
	}

	public void setNo_inventario(int no_inventario) {
		this.no_inventario = no_inventario;
	}

	public int getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	public String getNo_factura() {
		return no_factura;
	}

	public void setNo_factura(String no_factura) {
		this.no_factura = no_factura;
	}

	public String getNo_serie() {
		return no_serie;
	}

	public void setNo_serie(String no_serie) {
		this.no_serie = no_serie;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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

	public int getTipo_equipo() {
		return tipo_equipo;
	}

	public void setTipo_equipo(int tipo_equipo) {
		this.tipo_equipo = tipo_equipo;
	}

	public int getNum_arreglos() {
		return num_arreglos;
	}

	public void setNum_arreglos(int num_arreglos) {
		this.num_arreglos = num_arreglos;
	}

	public int getTec_comunicacion() {
		return tec_comunicacion;
	}

	public void setTec_comunicacion(int tec_comunicacion) {
		this.tec_comunicacion = tec_comunicacion;
	}

	public String getTec_comunicacion_dif() {
		return tec_comunicacion_dif;
	}

	public void setTec_comunicacion_dif(String tec_comunicacion_dif) {
		this.tec_comunicacion_dif = tec_comunicacion_dif;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

	public String getOs_version() {
		return os_version;
	}

	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}

	public String getOs_edicion() {
		return os_edicion;
	}

	public void setOs_edicion(String os_edicion) {
		this.os_edicion = os_edicion;
	}

	public int getOs_arq() {
		return os_arq;
	}

	public void setOs_arq(int os_arq) {
		this.os_arq = os_arq;
	}

	public String getOs_release() {
		return os_release;
	}

	public void setOs_release(String os_release) {
		this.os_release = os_release;
	}

	public int getNum_procesadores() {
		return num_procesadores;
	}

	public void setNum_procesadores(int num_procesadores) {
		this.num_procesadores = num_procesadores;
	}

	public int getNum_ram_instaladas() {
		return num_ram_instaladas;
	}

	public void setNum_ram_instaladas(int num_ram_instaladas) {
		this.num_ram_instaladas = num_ram_instaladas;
	}

	public String getTipo_licencia() {
		return tipo_licencia;
	}

	public void setTipo_licencia(String tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
	}

	public Date getLicencia_inicio() {
		return licencia_inicio;
	}

	public void setLicencia_inicio(Date licencia_inicio) {
		this.licencia_inicio = licencia_inicio;
	}

	public Date getLicencia_fin() {
		return licencia_fin;
	}

	public void setLicencia_fin(Date licencia_fin) {
		this.licencia_fin = licencia_fin;
	}

	public String getUnidad_optica() {
		return unidad_optica;
	}

	public void setUnidad_optica(String unidad_optica) {
		this.unidad_optica = unidad_optica;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BinUsuarioInventario getUsuario() {
		return usuario;
	}

	public void setUsuario(BinUsuarioInventario usuario) {
		this.usuario = usuario;
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

