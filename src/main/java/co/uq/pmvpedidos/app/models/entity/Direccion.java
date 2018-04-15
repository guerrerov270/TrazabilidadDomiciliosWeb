package co.uq.pmvpedidos.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoDireccion; // Karrera, Calle, Avenida

	private String numero1; // K19 C10N

	private String numero2;// 22N 18

	private String numero3;// 81 71

	private String tipoResidencia; // Casa, apto, oficina, local, manzana n casa n

	private String barrio;

	private String zonaID;

	public Direccion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	//
	// public Cliente getClienteD() {
	// return clienteD;
	// }
	//
	// public void setClienteD(Cliente clienteD) {
	// this.clienteD = clienteD;
	// }

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getNumero1() {
		return numero1;
	}

	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}

	public String getNumero3() {
		return numero3;
	}

	public void setNumero3(String numero3) {
		this.numero3 = numero3;
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	// @Override
	// public String toString() {
	// return "Direccion [id=" + id + ", tipoDireccion=" + tipoDireccion + ",
	// numero1=" + numero1 + ", numero2="
	// + numero2 + ", numero3=" + numero3 + ", tipoResidencia=" + tipoResidencia +
	// ", barrio=" + barrio
	// + ", zonaID=" + zonaID + "]";
	// }

	@Override
	public String toString() {
		return tipoDireccion + "/" + numero1 + "#" + numero2 + "-" + numero3 + " - " + tipoResidencia + " - "
				+ "Barrio:" + barrio + "- " + "zonaID: " + zonaID;
	}

}
