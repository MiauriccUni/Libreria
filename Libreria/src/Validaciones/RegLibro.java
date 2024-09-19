package Validaciones;
import Controladores.LibroControlador;
import Modelos.Libros;
import java.util.Scanner;
public class RegLibro {
    public void RegistroLibro(){
        Scanner scan = new Scanner(System.in);
        LibroControlador librosControlador = new LibroControlador();
        try {
            librosControlador.crearArchivo();

        }catch (Exception e) {
            System.out.println("Error al crear el archivo: ");
            System.out.println(e.getMessage());
        }
        System.out.println("Ingrese el nombre del ISBN: ");
        String ISBN = scan.nextLine();
        System.out.println("Ingrese el titulo del libro: ");
        String titulo = scan.nextLine();
        System.out.println("Ingrese el nombre del autor: ");
        String autor = scan.nextLine();
        System.out.println("Ingrese la descripcion: ");
        String descripcion = scan.nextLine();
        System.out.println("Ingrese la cantidad: ");
        int cantidad = scan.nextInt();
        Libros libros = new Libros(ISBN, titulo, autor, descripcion, cantidad);
        librosControlador.guardarLibro(libros);
    }
    public void ListaLibros(){
        LibroControlador librosControlador = new LibroControlador();
        System.out.println(librosControlador.listarLibros());
    }
    public void BuscarLibro(String Titulo){
        LibroControlador librosControlador = new LibroControlador();
        System.out.println(librosControlador.BucarLibro(Titulo));
    }
    public void DevolverLibro(String Titulo){}
}
