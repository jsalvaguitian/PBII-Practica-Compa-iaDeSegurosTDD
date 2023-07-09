package ar.edu.unlam.pb2;

public class Poliza implements Comparable<Poliza>{
	protected Integer numeroDePoliza;
	protected Persona asegurado;
	protected Double sumaAsegurada;
	protected Double prima;
	protected Double premio;
	protected Boolean fueSiniestro;
	
	public Poliza(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada,Double prima, Double premio) {
		this.numeroDePoliza = numeroDePoliza;
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.premio = premio;	
		this.fueSiniestro = false;
	}

	public void setNumeroDePoliza(Integer numeroDePoliza) {
		this.numeroDePoliza = numeroDePoliza;
	}

	public void setAsegurado(Persona asegurado) {
		this.asegurado = asegurado;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public void setPrima(Double prima) {
		this.prima = prima;
	}

	public void setPremio(Double premio) {
		this.premio = premio;
	}

	public boolean fueRobado() {
		this.fueSiniestro = true;
		return fueSiniestro;
	}

	public Integer getNumeroDePoliza() {
		return numeroDePoliza;
	}

	public Persona getAsegurado() {
		return asegurado;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public Double getPrima() {
		return prima;
	}

	public Double getPremio() {
		return premio;
	}

	public Boolean getFueSiniestro() {
		return fueSiniestro;
	}

	public boolean tuvoAlgunAccidente() {
		this.fueSiniestro = true;
		return fueSiniestro;
	}

	@Override
	public int compareTo(Poliza o) {
		return o.getAsegurado().getNombre().compareTo(this.getAsegurado().getNombre());
	}

	@Override
	public String toString() {
		return "Poliza [numeroDePoliza=" + numeroDePoliza + ", asegurado=" + asegurado + ", sumaAsegurada="
				+ sumaAsegurada + ", prima=" + prima + ", premio=" + premio + ", fueSiniestro=" + fueSiniestro + "]";
	}
	
	

	
	
	
	
	

}
