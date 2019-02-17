package dgac.inventario.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_catic_procesador")
public class BinCatProcesador {
	
	public BinCatProcesador() {
		
	}
	
	@Id
	@Column(name = "id_catic_procesador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_catic_procesador;
	
	@Column(name = "nombre_procesador")
	public String nombre_procesador; 
	
	
	
	public int getId_catic_procesador() {
		return id_catic_procesador;
	}
	public void setId_catic_procesador(int id_catic_procesador) {
		this.id_catic_procesador = id_catic_procesador;
	}
	
	public String getNombre_procesador() {
		return nombre_procesador;
	}
	public void setNombre_procesador(String nombre_procesador) {
		this.nombre_procesador = nombre_procesador;
	}

}
