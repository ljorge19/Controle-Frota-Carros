package frotaCarros.api.model;

public class Viagem {

	private double distancia;
	private Carro carro;
	private long preco;

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public long getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

}
