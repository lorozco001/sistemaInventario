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
@Table(name = "ram")
public class BinRam implements Serializable {

	public BinRam() {
		
	}
	
	@Id
	@Column(name = "id_ram")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ram; 
	
	@Column(name = "tipo_ram")
	private byte tipo_ram; 
	
	@Column(name = "tipo_ram_diferente")
	private String tipo_ram_diferente;
	
	@Column(name = "capacidad")
	private float capacidad; 
	
	@Column(name = "escala_capacidad")
	private String escala_capacidad;
	
	@Column(name = "velocidad")
	private int velocidad;
	
	@Column(name = "escala_velocidad")
	private String escala_velocidad;
	
	//mapea datos entre tablas ram y trans_ram_equipo
	@OneToMany(mappedBy="ram",cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<BinRam> ram;

	public int getId_ram() {
		return id_ram;
	}

	public void setId_ram(int id_ram) {
		this.id_ram = id_ram;
	}

	public byte getTipo_ram() {
		return tipo_ram;
	}

	public void setTipo_ram(byte tipo_ram) {
		this.tipo_ram = tipo_ram;
	}

	public String getTipo_ram_diferente() {
		return tipo_ram_diferente;
	}

	public void setTipo_ram_diferente(String tipo_ram_diferente) {
		this.tipo_ram_diferente = tipo_ram_diferente;
	}

	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

	public String getEscala_capacidad() {
		return escala_capacidad;
	}

	public void setEscala_capacidad(String escala_capacidad) {
		this.escala_capacidad = escala_capacidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getEscala_velocidad() {
		return escala_velocidad;
	}

	public void setEscala_velocidad(String escala_velocidad) {
		this.escala_velocidad = escala_velocidad;
	}

	public Set<BinRam> getRam() {
		return ram;
	}

	public void setRam(Set<BinRam> ram) {
		this.ram = ram;
	}
	
	

}
