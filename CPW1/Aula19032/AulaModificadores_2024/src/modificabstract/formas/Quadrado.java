package modificabstract.formas;

public class Quadrado extends FormaGeometrica{
    public double calculaArea(){
       return getLado()*getLado();
    }
    public double calculaPerimetro(){
       return 4*getLado();
    }

}

