package frotaCarros.api.model;

import frotaCarros.api.modelEnum.Categoria;
import frotaCarros.api.modelEnum.Status;

public class Carro {

	private int id;
	private String modelo;
	private double latitude;
	private double longitude;
	// private Status{ RUNNING_IN_PROGRESS, WAITING_FOR_RACE,
	// INACTIVE,UNDER_MAINTENANCE, FINISHING_RACE };
	private Status status;
	// private Categoria{ BASIC, WAITING_FOR_RACE, SHARED,EXECUTIVE, SPECIAL };
	private Categoria categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
