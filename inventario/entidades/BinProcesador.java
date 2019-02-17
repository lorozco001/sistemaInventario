package dgac.inventario.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procesador")
public class BinProcesador implements Serializable {
	
	public BinProcesador() {
		
	}
	
	@Id
	@Column(name = "id_procesador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_procesador;
	
	@Column(name = "tipo_procesador")
	private byte tipo_procesador;
	
	@Column(name = "tipo_procesador_diferente")
	private String tipo_procesador_diferente; 
	
	@Column(name = "modelo_procesador")
	private String modelo_procesador; 
	
	@Column(name = "cant_nucleos")
	private int cant_nucleos;  
	
	@Column(name = "cant_nucleos_gpu")
	private int cant_nucleos_gpu; 
	
	@Column(name = "velocidad")
	private float velocidad; 
	
	@Column(name = "escala_velocidad")
	private String escala_velocidad; 
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "arquitectura")
	private byte arquitectura; 
	
		
	public int getId_procesador() {
		return id_procesador;
	}
	public void setId_procesador(int id_procesador) {
		this.id_procesador = id_procesador;
	}
	
	public byte getTipo_procesador() {
		return tipo_procesador;
	}
	public void setTipo_procesador(byte tipo_procesador) {
		this.tipo_procesador = tipo_procesador;
	}
	
	public String getTipo_procesador_diferente() {
		return tipo_procesador_diferente;
	}
	public void setTipo_procesador_diferente(String tipo_procesador_diferente) {
		this.tipo_procesador_diferente = tipo_procesador_diferente;
	}
	
	public String getModelo_procesador() {
		return modelo_procesador;
	}
	public void setModelo_procesador(String modelo_procesador) {
		this.modelo_procesador = modelo_procesador;
	}
	
	public int getCant_nucleos() {
		return cant_nucleos;
	}
	public void setCant_nucleos(int cant_nucleos) {
		this.cant_nucleos = cant_nucleos;
	}
	
	public int getCant_nucleos_gpu() {
		return cant_nucleos_gpu;
	}
	public void setCant_nucleos_gpu(int cant_nucleos_gpu) {
		this.cant_nucleos_gpu = cant_nucleos_gpu;
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	public String getEscala_velocidad() {
		return escala_velocidad;
	}
	public void setEscala_velocidad(String escala_velocidad) {
		this.escala_velocidad = escala_velocidad;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public byte getArquitectura() {
		return arquitectura;
	}
	public void setArquitectura(byte arquitectura) {
		this.arquitectura = arquitectura;
	}
	
}
