package ar.edu.unlam.pb2;

import java.util.HashMap;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida{

	private HashMap<Persona, TipoDeBeneficiario> beneficiarios;
	
	public PolizaAccidentesPersonales(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima, Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		this.beneficiarios =new HashMap<>();
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
	public Persona getAsegurado() {
		return this.asegurado;
	}

	@Override
	public Double getPremio() {
		return this.premio;
	}

	

}
