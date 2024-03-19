package modificabstract.formas;

public abstract class FormaGeometrica {
	private double lado;
	
	public FormaGeometrica(){}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "FormaGeometrica [lado=" + lado + "]";
	}
	
	   public abstract double calculaArea();
	   public abstract double calculaPerimetro();

}
