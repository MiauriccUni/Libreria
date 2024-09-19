package Validaciones;
import Controladores.LibroControlador;
import Controladores.PrestamosControlador;
import Controladores.UsuarioControlador;
import Modelos.Libros;
import Modelos.Prestamos;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
public class RegPrestamos {
    public void Prestamo(){
        PrestamosControlador p = new PrestamosControlador();
        LibroControlador l = new LibroControlador();
        UsuarioControlador u = new UsuarioControlador();
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ISBN del libro.");
        String ISBN = sc.nextLine();
        System.out.println("Indique la identificacion del usuario.");
        String Identificacion = sc.nextLine();
        Libros lib = new Libros();
        Usuario usu = new Usuario();
        lib = l.BucarLibro(ISBN);
        usu = u.BuscarUsuario(Identificacion);
       System.out.println(p.PrestarVal(usu,lib));
    }
    public void mostrarPrestamo(){
        PrestamosControlador p = new PrestamosControlador();
        ArrayList<Prestamos> prestamos = p.MostrarPrestamos();
        System.out.println(prestamos);
    }
}
