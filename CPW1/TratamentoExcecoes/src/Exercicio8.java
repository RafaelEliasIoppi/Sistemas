
public class Exercicio8 {
	public static void main(String args[]) {
		try {
			int a[] = new int[10];
			System.out.println("Acessando elemento 20 : " + a[20]);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException :" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException :" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("RuntimeException :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("Error :" + e.getMessage());
		} catch (Throwable e) {
			System.out.println("Throwable :" + e.getMessage());
		} //nos blocos catch primeiro colocamos as subclasses - por último a superclasse
	}
}
