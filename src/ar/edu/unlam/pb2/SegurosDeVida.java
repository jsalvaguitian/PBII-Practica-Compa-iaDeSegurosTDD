package ar.edu.unlam.pb2;

public interface SegurosDeVida {

	void agregarBeneficiario(Persona hijo, TipoDeBeneficiario tipoBeneficiario);

	Integer obtenerCantidadDeBeneficiarios();

	Persona getAsegurado();

	Double getPremio();

}
