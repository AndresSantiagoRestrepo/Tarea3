package caldas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ruta;
        Scanner sc = new Scanner(System.in);


        System.out.println("Escriba la ruta deonde es encuentra el archivo");
        ruta = sc.nextLine();


        System.out.println("usted dijo:" + ruta);

        ControlEstudiante control = new ControlEstudiante();
        control.leerCSV(ruta);
        control.print();
        control.escribirJSON();
    }
}