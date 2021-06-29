
package test;
import correcionconjunta.CorrecionConjunta;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class correcionTest {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int nroMovimientos, cantidadMovimiento;

        System.out.println("Cuantos movimientos desea realizar");
        nroMovimientos = teclado.nextInt();
        CorrecionConjunta[] puntos = new CorrecionConjunta[nroMovimientos+1];
        generarMovimientos(nroMovimientos, puntos);
        distanciaTotal(nroMovimientos, puntos);
    }

    public static void generarMovimientos(int n, CorrecionConjunta p[]) {
        String direccion = "";
        int x = 0;
        int y = 0;
        int i = 0;
        int aux;
        int valor = 0;
        p[0] = new CorrecionConjunta(x, y);
        for (i = 1; i < n+1; i++) {
            System.out.println("Ingrese el valor del movimiento numero " + i + ":");
            valor = teclado.nextInt();
            direccion = direccion();
            //System.out.println(direccion);
            if (direccion == "Izquierda") {
                x = p[i-1].getEjeX();
                x = x-valor;
            }
            else if (direccion == "Derecha") {
                x = p[i-1].getEjeX();
                x= x+valor;
            }

            else if (direccion == "Arriba") {
                y = p[i-1].getEjeY() ;
                y = y+valor;
            }
            if (direccion == "Abajo") {
                y = p[i-1].getEjeY();
                y = y-valor;
            }
            
            p[i] = new CorrecionConjunta(x, y);
            System.out.println("Nueva direccion: "+ direccion);
            System.out.println("Nuevas coordenadas: " + x +" "+ y);        
        }
    }

    public static String direccion() {
        String[] direcciones = {"Izquierda", "Derecha", "Arriba", "Abajo"};
        int numAleatorio = numeroAleatorio(0, direcciones.length - 1);
        //System.out.println(numAleatorio);
        return direcciones[numAleatorio];
    }

    public static int numeroAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void distanciaTotal(int n, CorrecionConjunta p[]){
        
     int dx=0;
        int dy=0;
        double distanciatotal=0;
        for (int i =0; i < n; i++) {
            dx = p[i+1].getEjeX()-p[i].getEjeX();
            double distancia_xf = Math.pow(dx, 2);
            dy = p[i+1].getEjeY()-p[i].getEjeY();
            double distancia_yf = Math.pow(dy, 2);      
            distanciatotal = distanciatotal + Math.sqrt(distancia_xf + distancia_yf);
       }
       System.out.println("La distancia total es: " + distanciatotal); 
    }
}

   

