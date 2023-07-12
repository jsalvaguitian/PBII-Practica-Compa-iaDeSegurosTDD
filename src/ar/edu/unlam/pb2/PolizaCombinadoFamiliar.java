package ar.edu.unlam.pb2;

import java.util.HashMap;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosDeVida, SegurosGenerales{

	private HashMap<Persona, TipoDeBeneficiario> beneficiarios;
	private Vivienda vivienda;
	
	public PolizaCombinadoFamiliar(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima,
			Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		this.beneficiarios = new HashMap<>();
		this.vivienda = null;
	}

	@Override
	public void agregarBienAsegurado(Posesion unBienAAsegurar) {
		this.vivienda = (Vivienda) unBienAAsegurar;
	}
	
	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipoBeneficiario) {
		this.beneficiarios.put(persona, tipoBeneficiario);
	}

	@Override
	public Integer obtenerCantidadDeBeneficiarios() {
		return this.beneficiarios.size();
	}
	@Override
	public Auto getAuto() {
		return null;
	}

	@Override
	public Persona getAsegurado() {
		return this.asegurado;
	}

	
	@Override
	public Double getPremio() {
		return this.premio;
	}

	

	@Override
	public Integer getNumeroDePoliza() {
		return this.numeroDePoliza;
	}

	
}
