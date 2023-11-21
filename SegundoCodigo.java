import java.util.Scanner;

public class SegundoCodigo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = teclado.nextLine();
        for(int i = 0; i < 10; i++){
            System.out.println("Que feo eres " + nombre);
        }
    }
}
