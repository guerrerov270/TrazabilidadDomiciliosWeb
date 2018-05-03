package co.uq.pmvpedidos.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// @NotEmpty
	// @Size(min=7,max=10)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String direccion;

	private String empresa;

	@NotEmpty
	private String zona;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	private String resenia;

	@OneToMany(mappedBy = "clienteF", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Factura> facturas;

	// @OneToMany(mappedBy = "clienteD", fetch = FetchType.LAZY, cascade =
	// CascadeType.ALL, orphanRemoval = true)
	// private List<Direccion> direcciones;
	//
	// @OneToMany(mappedBy = "clienteT", fetch = FetchType.LAZY, cascade =
	// CascadeType.ALL, orphanRemoval = true)
	// private List<Telefono> telefonos;

	public Cliente() {
		facturas = new ArrayList<Factura>();
		// direcciones = new ArrayList<Direccion>();
		// telefonos = new ArrayList<Telefono>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

	// public List<Direccion> getDirecciones() {
	// return direcciones;
	// }
	//
	// public void setDirecciones(List<Direccion> direcciones) {
	// this.direcciones = direcciones;
	// }
	//
	// public void addDireccion(Direccion direccion) {
	// direcciones.add(direccion);
	// }
	//
	// public List<Telefono> getTelefonos() {
	// return telefonos;
	// }
	//
	// public void setTelefonos(List<Telefono> telefonos) {
	// this.telefonos = telefonos;
	// }
	//
	// public void addTelefono(Telefono telefono) {
	// telefonos.add(telefono);
	// }

	// public String getTelefono() {
	// return telefono;
	// }
	//
	// public void setTelefono(String telefono) {
	// this.telefono = telefono;
	// }

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getResenia() {
		return resenia;
	}

	public void setResenia(String resenia) {
		this.resenia = resenia;
	}

	@Override
	public String toString() {
		return nombre + "-" + id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
