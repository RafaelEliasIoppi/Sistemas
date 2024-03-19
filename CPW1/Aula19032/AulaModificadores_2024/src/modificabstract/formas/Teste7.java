package modificabstract.formas;

public class Teste7 {
	public static void main(String[] args) {
		FormaGeometrica forma1 = new FormaGeometrica();
		FormaGeometrica forma2 = new Quadrado();
		FormaGeometrica vet[] = new FormaGeometrica[10];
		vet[0] = new FormaGeometrica();
		vet[1] = new Quadrado();
		vet[2] = new Retangulo();
		forma1.calculaArea();
	}
}
