package dgac.inventario.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="trans_ram_equipo")
public class BinTransRamEquipo implements Serializable{

	@Id
	@Column(name = "id_ram")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_ram;
	
	//relacion muchos a uno entre las tablas ram y trans_ram_equipo
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_ram", referencedColumnName = "id_ram", insertable = false, updatable = false)
	private BinRam ram; 
	
	
	
	@Column(name = "no_inventario")
	public int no_inventario;
	
//	@ManyToOne(optional=true, fetch=FetchType.EAGER)
//	@JoinColumn(name="no_inventario")
//	private BinTransRamEquipo trans_ram_equipo;
	

	public int getId_ram() {
		return id_ram;
	}

	
	public void setId_ram(int id_ram) {
		this.id_ram = id_ram;
	}

	public int getNo_inventario() {
		return no_inventario;
	}

	public void setNo_inventario(int no_inventario) {
		this.no_inventario = no_inventario;
	}
	
}
