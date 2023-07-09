package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

/* finalizacion esperada: 00:30
 * 
 * Inicie: 22:30
 * Termine: 00:40 (Solo haciendo 7 test)
 * Termine: 1:10 (con 8 test Lenta como tortuga -_-)
 * 
 * Compañia de Seguros vende POLIZAS DE SEGUROS
 * 
 * Poliza de vida(asegurado)
 * Cobra el segura el no asegurado
 * -----------------------------------
 * Poliza de seguros generales
 * -------------------------------
 * Poliza general y de vida (casa y la familia que viven ahi)
 * ===================================
 * suma asegurada : la plata que recibe el asegurado o el beneficiario
 * 
 * Prima: plata que paga la persona a la compañia para tener seguro
 * 
 * Premio: prima + impuesto
 * 
 * Beneficiario: En caso de seguro de vida, son las
 * personas que reciben el seguro de vida que puede
 * ser MAS DE UNO cada uno se divide por igual
 * */
public class TestParcial {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		poliza.agregarBienAsegurado(auto);
	
		assertEquals(NUMERO_DE_POLIZA, poliza.getNumeroDePoliza());
		assertEquals(auto, poliza.getAuto());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
	
		assertEquals((Integer)2, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
///////////////////////////////////////////////////////////////////////////////////	

	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;
		
		Vivienda casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona hija = new Persona("Maia", 65445231, 4);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		poliza.agregarBienAsegurado(casa);
	
		assertEquals((Integer)3, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
		//ARREGLAR GETAUTO
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0, 5000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0,60000.0));
		
		
		assertEquals((Integer)5, libra.obtenerLaCantidadDePolizasEmitidas());
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistenteException {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 6000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(libra.getPoliza(1).fueRobado());
		
	}
	
///////////////////////////////////////////////////////////////////////////////////	

	@Test 
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistenteException {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0, 6000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(libra.getPoliza(1).tuvoAlgunAccidente());
		
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	@Test (expected = PolizaInexistenteException.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistenteException {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 6000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0 , 6000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0, 6000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0, 6000.0));

		libra.denunciarSiniestro(5);

	}
///////////////////////////////////////////////////////////////////////////////////	

	/*Victor
	 *Pedro
	 *Natalia
	 *Juan
	 *Camila
	 */
	//Test Extra
	@Test 
	public void queSePuedaOrdenarLasPolizasPorNombreDesdeZhastaADeLosAsegurados() {
		
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		
		PolizaDeAuto polizaTestInicio = new PolizaDeAuto(5, new Persona("Victor", 652354, 24), 2000000.0, 5000.0,60000.0);
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0, 5000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(5, new Persona("Victor", 652354, 24), 2000000.0, 5000.0,60000.0));
		
		libra.ordenarListaDePolizas();
		
		assertEquals(polizaTestInicio.getAsegurado(), libra.getPolizas().get(0).getAsegurado());
		
		
	}

}
