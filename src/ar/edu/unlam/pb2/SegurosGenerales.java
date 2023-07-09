package ar.edu.unlam.pb2;

public interface SegurosGenerales {

	void agregarBienAsegurado(Posesion unBienAAsegurar);

	Integer getNumeroDePoliza();

	Auto getAuto();

	Persona getAsegurado();

	Double getPremio();

	

	

}
