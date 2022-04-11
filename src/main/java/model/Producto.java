package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_productos")
public class Producto {
	@Id
	@Column(name = "id_prod")
	private String codigo;
	@Column(name = "des_prod")
	private String descripcion;
	@Column(name = "stk_prod")
	private int stock;
	@Column(name = "pre_prod")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria",insertable = false,updatable = false)
	private Categorias categoria;  //obtener la informacion categoria segun su campo
	
	private int idcategoria;  //grabar en la tabla producto
	
	@Column(name = "est_prod")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name = "idprovedor",insertable = false,updatable = false)
	private Provedor proveedor;  //obtener la informacion Provedor segun su campo
	
	private int idprovedor;   //grabar en la tabla Provedor
	

}
