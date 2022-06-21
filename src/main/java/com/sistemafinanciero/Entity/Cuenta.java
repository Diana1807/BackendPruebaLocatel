package com.sistemafinanciero.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CUENTA")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_cuenta")
	private Integer idCuenta;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Persona persona;
	
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;
	
	@Column(name = "estado_linea", insertable = false, updatable=false)
	private boolean estadoLinea;
	
	@OneToMany(mappedBy = "cuenta", cascade = { CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.EAGER)
	List<MovimientoCuenta> listadoMovimientosCuenta = new ArrayList<MovimientoCuenta>();

	@Override
	public int hashCode() {
		return Objects.hash(idCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(idCuenta, other.idCuenta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuenta [idCuenta=");
		builder.append(idCuenta);
		builder.append(", persona=");
		builder.append(persona);
		builder.append(", tipoCuenta=");
		builder.append(tipoCuenta);
		builder.append(", estadoLinea=");
		builder.append(estadoLinea);
		builder.append(", listadoMovimientosCuenta=");
		builder.append(listadoMovimientosCuenta);
		builder.append("]");
		return builder.toString();
	}

	public Integer getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public boolean isEstadoLinea() {
		return this.estadoLinea;
	}

	public void setEstadoLinea(boolean estadoLinea) {
		this.estadoLinea = estadoLinea;
	}

	public List<MovimientoCuenta> getListadoMovimientosCuenta() {
		return this.listadoMovimientosCuenta;
	}

	public void setListadoMovimientosCuenta(List<MovimientoCuenta> listadoMovimientosCuenta) {
		this.listadoMovimientosCuenta = listadoMovimientosCuenta;
	}
	
}
