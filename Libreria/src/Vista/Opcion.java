package Vista;
import Validaciones.RegLibro;
import Validaciones.RegPrestamos;
import Validaciones.RegUsuario;

import java.util.Scanner;

public class Opcion {
    public void Opciones(){
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        RegUsuario regUse = new RegUsuario();
        RegLibro regLib = new RegLibro();
        RegPrestamos regPre = new RegPrestamos();
        int op = 0;
        do {
            menu.menu();
            System.out.println("Indique una opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    regUse.RegistroUsuario();
                break;
                case 2:
                    regUse.ListaUsuarios();
                break;
                case 3:
                    regLib.RegistroLibro();
                break;
                case 4:
                    regLib.ListaLibros();
                break;
                case 5:
                    System.out.println("Por favor indique un usuario");
                    String s = sc.nextLine();
                    regUse.MostrarUsuario(s);
                break;
                case 6:
                    System.out.println("Por favor indique el titulo del libro");
                    String t = sc.nextLine();
                    regLib.BuscarLibro(t);
                break;
                case 7:
                    regPre.Prestamo();
                break;
                case 8:
                    regPre.mostrarPrestamo();
                break;
                case 11:
                    System.out.println("Hasta luego");
                break;
                default:
                    System.out.println("Favor indicar una opcion valida");
                break;
            }
        }while (op != 11);
    }
}
