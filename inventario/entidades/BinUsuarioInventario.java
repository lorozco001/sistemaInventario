package dgac.inventario.entidades;

import java.io.Serializable;
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
@Table(name = "usuario")

public class BinUsuarioInventario implements Serializable {
	
	public BinUsuarioInventario() {
		
	}
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column(name = "id_area_dgac")
	private int id_area_dgac;
	
	@Column(name = "no_empleado")
	private int no_empleado;
	
	@Column(name = "tipo_usuario")
	private int tipo_usuario;
	
	@Column(name = "nombre_completo")
	private String nombre_completo;
	
	@Column(name = "perfil_usuario")
	private int perfil_usuario;	
	
	@Column(name="activo")
	private byte activo;
	
	@OneToMany(mappedBy="usuario",cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<BinEquipo> equipos;
	
	
	//setters y getters de la clase usuario
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_area_dgac() {
		return id_area_dgac;
	}

	public void setId_area_dgac(int id_area_dgac) {
		this.id_area_dgac = id_area_dgac;
	}

	public int getNo_empleado() {
		return no_empleado;
	}

	public void setNo_empleado(int no_empleado) {
		this.no_empleado = no_empleado;
	}

	public int getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public int getPerfil_usuario() {
		return perfil_usuario;
	}

	public void setPerfil_usuario(int perfil_usuario) {
		this.perfil_usuario = perfil_usuario;
	}

	public Set<BinEquipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<BinEquipo> equipos) {
		this.equipos = equipos;
	}
	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}
}

