package ar.edu.unlam.pb2;

public class Vivienda implements Posesion{

	private String domicilio;
	private String provincia;
	private String municipio;
	private String pais;
	
	public Vivienda(String domicilio, String provincia, String municipio, String pais) {
		this.domicilio = domicilio;
		this.pais = pais;
		this.municipio = municipio;
		this.provincia= provincia;
	}

}
