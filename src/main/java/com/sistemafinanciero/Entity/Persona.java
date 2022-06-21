package com.sistemafinanciero.Entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_PERSONA")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_persona")
	private Integer idPersona;

	@Column(name = "tipo_documento")
	private String tipoDocumento;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@Column(name = "primer_apellido")
	private String primerApellido;
	
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	
	@Column(name = "fecha_nacimiento")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  fechaNacimiento;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "estado_linea", insertable = false, updatable=false)
	private boolean estadoLinea;
	
	
	@OneToOne(mappedBy = "persona", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Cuenta cuenta;

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(idPersona, other.idPersona);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [idPersona=");
		builder.append(idPersona);
		builder.append(", tipoDocumento=");
		builder.append(tipoDocumento);
		builder.append(", numeroDocumento=");
		builder.append(numeroDocumento);
		builder.append(", primerNombre=");
		builder.append(primerNombre);
		builder.append(", segundoNombre=");
		builder.append(segundoNombre);
		builder.append(", primerApellido=");
		builder.append(primerApellido);
		builder.append(", segundoApellido=");
		builder.append(segundoApellido);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", estadoLinea=");
		builder.append(estadoLinea);
		//builder.append(", cuenta=");
		//builder.append(cuenta);
		builder.append("]");
		return builder.toString();
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEstadoLinea() {
		return this.estadoLinea;
	}

	public void setEstadoLinea(boolean estadoLinea) {
		this.estadoLinea = estadoLinea;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
