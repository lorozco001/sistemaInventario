package dgac.inventario.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "disco_duro")
public class BinDiscoDuro implements Serializable{

	public BinDiscoDuro() {
		
	}

	@Id
	@Column(name = "id_disco_duro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_disco_duro;
	
	@Column(name = "no_inventario")
	private int no_inventario; 

	@Column(name = "tecnologia_dd")
	private int tecnologia_dd; 

	@Column(name = "capacidad_total")
	private float capacidad_total;

	@Column(name = "escala_capacidad")
	private String escala_capacidad;

	@Column(name = "tipo_dd")
	private String tipo_dd;
	
	public int getId_disco_duro() {
		return id_disco_duro;
	}
	public void setId_disco_duro(int id_disco_duro) {
		this.id_disco_duro = id_disco_duro;
	}
	public int getNo_inventario() {
		return no_inventario;
	}
	public void setNo_inventario(int no_inventario) {
		this.no_inventario = no_inventario;
	}
	public int getTecnologia_dd() {
		return tecnologia_dd;
	}
	public void setTecnologia_dd(int tecnologia_dd) {
		this.tecnologia_dd = tecnologia_dd;
	}
	public float getCapacidad_total() {
		return capacidad_total;
	}
	public void setCapacidad_total(float capacidad_total) {
		this.capacidad_total = capacidad_total;
	}
	public String getEscala_capacidad() {
		return escala_capacidad;
	}
	public void setEscala_capacidad(String escala_capacidad) {
		this.escala_capacidad = escala_capacidad;
	}
	public String getTipo_dd() {
		return tipo_dd;
	}
	public void setTipo_dd(String tipo_dd) {
		this.tipo_dd = tipo_dd;
	}

}
