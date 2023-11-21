import java.util.Scanner;
public class Buscaminas {
    public static void main(String[] args) {
        int numMinas = 0;
        int numCasillas;
        double lado, dificultad;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.print("Tamaño: ");
            lado = teclado.nextDouble();
            teclado.nextLine();
        } while (lado < 4);
        do{
            System.out.print("Dificultad: ");
            dificultad = teclado.nextDouble();
            teclado.nextLine();
        } while (dificultad < 1);
        numCasillas = (int) Math.pow(lado, 2.00);
        dificultad = dificultad/100;
        Casilla[][] campo = new Casilla[(int)lado][(int)lado];
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                campo[y][x] = new Casilla(x, y, dificultad);
                if(campo[y][x].getMina()){
                    numMinas++;
                }
            }
        }
        for(int i = 0; i < lado; i++){
            for(int j = 0; j < lado; j++){
                campo[j][i].setValor(campo[j][i].valorar(campo));
            }
        }
        boolean jugar = true;
        int x, y;
        while (jugar && numCasillas > numMinas){
            do{
                System.out.print("Posición x: ");
                x = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Posición y: ");
                y = teclado.nextInt();
                teclado.nextLine();
            } while (campo[y][x].getDescubierta() && x >= 0 && x < lado && y >= 0 && y < lado);
            jugar = campo[y][x].descubrir();
            if(jugar){
                numCasillas--;
            }
            for(int i = 0; i < lado; i++){
                for(int j = 0; j < lado; j++){
                    System.out.print(campo[i][j]);
                }
                System.out.print("\n");
            }
        }
        if(!jugar){
            System.out.println("Explotó una mina. ");
        } else System.out.println("No desenterraste ninguna mina. ");
    }
}