package dgac.inventario.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")

public class BinProveedor implements Serializable{

	public BinProveedor(){
		
	}
	
	@Id
	@Column(name = "rfc")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String rfc;
	
	@Column(name = "nombre_provedor")
	private String nombre_provedor;
	
	@Column(name = "domicilio_fiscal")
	private String domicilio_fiscal;
	
	@Column(name = "domicilio_particular")
	private String domicilio_particular;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "telefono2")
	private String telefono2;	
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "pag_web")
	private String pag_web;
	
	@Column(name= "tipo_persona")
	private byte tipo_persona;
	
	@Column(name="activo")
	private byte activo;

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre_provedor() {
		return nombre_provedor;
	}

	public void setNombre_provedor(String nombre_provedor) {
		this.nombre_provedor = nombre_provedor;
	}

	public String getDomicilio_fiscal() {
		return domicilio_fiscal;
	}

	public void setDomicilio_fiscal(String domicilio_fiscal) {
		this.domicilio_fiscal = domicilio_fiscal;
	}

	public String getDomicilio_particular() {
		return domicilio_particular;
	}

	public void setDomicilio_particular(String domicilio_particular) {
		this.domicilio_particular = domicilio_particular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPag_web() {
		return pag_web;
	}

	public void setPag_web(String pag_web) {
		this.pag_web = pag_web;
	}

	public byte getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(byte tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	
}
