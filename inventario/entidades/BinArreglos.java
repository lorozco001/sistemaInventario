package dgac.inventario.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "arreglos")

public class BinArreglos implements Serializable  {
	
	/* CONSTRUCTOR */
	public BinArreglos() {
		
	}

	@Id
	@Column(name = "no_inventario")
	public int no_inventario;

	@Column(name = "num_arreglo")
	public byte num_arreglo; 
	
	@Column(name = "esquema")
	public String esquema; 

	@Column(name = "tecnologia_dd")
	public String tecnologia_dd;	

	@Column(name = "capacidad_arr")
	public float capacidad_arr; 
	
	@Column(name = "escala_capacidad")
	public String escala_capacidad;

	public int getNo_inventario() {
		return no_inventario;
	}

	public void setNo_inventario(int no_inventario) {
		this.no_inventario = no_inventario;
	}

	public byte getNum_arreglo() {
		return num_arreglo;
	}

	public void setNum_arreglo(byte num_arreglo) {
		this.num_arreglo = num_arreglo;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getTecnologia_dd() {
		return tecnologia_dd;
	}

	public void setTecnologia_dd(String tecnologia_dd) {
		this.tecnologia_dd = tecnologia_dd;
	}

	public float getCapacidad_arr() {
		return capacidad_arr;
	}

	public void setCapacidad_arr(float capacidad_arr) {
		this.capacidad_arr = capacidad_arr;
	}

	public String getEscala_capacidad() {
		return escala_capacidad;
	}

	public void setEscala_capacidad(String escala_capacidad) {
		this.escala_capacidad = escala_capacidad;
	}

}