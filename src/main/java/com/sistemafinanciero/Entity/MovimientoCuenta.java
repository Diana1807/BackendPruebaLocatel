package com.sistemafinanciero.Entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_MOVIMIENTOS_CUENTA")
public class MovimientoCuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_movimiento")
	private Integer idMovimientoCuenta;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cuenta")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	Cuenta cuenta;
	
	@Column(name = "tipo_transaccion")
	private String tipoTransaccion;
	
	@Column(name = "debe")
	private double debe;
	
	@Column(name = "haber")
	private double haber;
	
	@Column(name = "estado_linea", insertable = false, updatable=false)
	private boolean estadoLinea;
	
	@Column(name = "fecha_creacion", insertable = false, updatable=false)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date fechaCreacion;

	@Override
	public int hashCode() {
		return Objects.hash(idMovimientoCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimientoCuenta other = (MovimientoCuenta) obj;
		return Objects.equals(idMovimientoCuenta, other.idMovimientoCuenta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovimientoCuenta [idMovimientoCuenta=");
		builder.append(idMovimientoCuenta);
		builder.append(", cuenta=");
		builder.append(cuenta);
		builder.append(", tipoTransaccion=");
		builder.append(tipoTransaccion);
		builder.append(", debe=");
		builder.append(debe);
		builder.append(", haber=");
		builder.append(haber);
		builder.append(", estadoLinea=");
		builder.append(estadoLinea);
		builder.append("]");
		return builder.toString();
	}

	public Integer getIdMovimientoCuenta() {
		return this.idMovimientoCuenta;
	}

	public void setIdMovimientoCuenta(Integer idMovimientoCuenta) {
		this.idMovimientoCuenta = idMovimientoCuenta;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public double getDebe() {
		return this.debe;
	}

	public void setDebe(double debe) {
		this.debe = debe;
	}

	public double getHaber() {
		return this.haber;
	}

	public void setHaber(double haber) {
		this.haber = haber;
	}

	public boolean isEstadoLinea() {
		return this.estadoLinea;
	}

	public void setEstadoLinea(boolean estadoLinea) {
		this.estadoLinea = estadoLinea;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
