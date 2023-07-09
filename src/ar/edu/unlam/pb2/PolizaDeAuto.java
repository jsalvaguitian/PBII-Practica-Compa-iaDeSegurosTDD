package ar.edu.unlam.pb2;
//implements SegurosGenerales

public class PolizaDeAuto extends Poliza implements SegurosGenerales {
	private Auto bienAsegurado;

	public PolizaDeAuto(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima, Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
	}

	@Override
	public Integer getNumeroDePoliza() {
		return this.numeroDePoliza;
	}

	@Override
	public Auto getAuto() {
		return this.bienAsegurado;
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
	public void agregarBienAsegurado(Posesion unBienAAsegurar) {
		this.bienAsegurado = (Auto) unBienAAsegurar;		
	}
	

}
