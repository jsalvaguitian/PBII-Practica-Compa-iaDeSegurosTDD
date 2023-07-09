package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompaniaDeSeguro {
	private String nombre;
	private List<Poliza>polizas;
	private List<Poliza>siniestros;

	public CompaniaDeSeguro(String nombre) {
		this.nombre = nombre;
		this.polizas = new ArrayList<>();
		this.siniestros = new ArrayList<>();
	}

	public void agregarPoliza(Poliza poliza) {
		
		this.polizas.add(poliza);
	}

	public Integer obtenerLaCantidadDePolizasEmitidas() {
		return this.polizas.size();
	}

	public void denunciarSiniestro(int numPoliza) throws PolizaInexistenteException{
		Poliza buscada = this.getPoliza(numPoliza);
		
		if(buscada != null) {
			this.siniestros.add(buscada);
		}else {
			throw new PolizaInexistenteException("Poliza de numero de poliza: "+ numPoliza + "es inexistente");
		}
		
	}

	public Poliza getPoliza(Integer numPoliza) {
		for(Poliza una: this.polizas) {
			if(una.getNumeroDePoliza().equals(numPoliza)) {
				return una;
			}
		}
		
		return null;
	}

	public void ordenarListaDePolizas() {
		Collections.sort(this.polizas);
		
	}

	public String getNombre() {
		return nombre;
	}

	public List<Poliza> getPolizas() {
		return polizas;
	}

	public List<Poliza> getSiniestros() {
		return siniestros;
	}
	
	

}
