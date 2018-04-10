package co.uq.pmvpedidos.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "zonas")
public class Zona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	@NotEmpty
	private Double precioEnvio;

	public Zona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(Double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	@Override
	public String toString() {
		return nombre + ":" + precioEnvio;
	}

}
