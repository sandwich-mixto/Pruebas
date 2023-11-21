import java.util.Scanner;
public class PrimerCodigo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = teclado.nextLine();
        System.out.println("Enhorabuena, te llamas " + nombre);
    }
}