package dgac.inventario.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_catic_ram")
public class BinCatRam {

	@Id
	@Column(name = "id_catic_ram")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_catic_ram; 
	
	@Column(name = "nombre_ram")
	private String nombre_ram; 
	
	public BinCatRam() {
		
	}
	
	public int getId_catic_ram() {
		return id_catic_ram;
	}

	public void setId_catic_ram(int id_catic_ram) {
		this.id_catic_ram = id_catic_ram;
	}

	public String getNombre_ram() {
		return nombre_ram;
	}

	public void setNombre_ram(String nombre_ram) {
		this.nombre_ram = nombre_ram;
	}
	
}
