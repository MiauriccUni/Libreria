package Validaciones;
import java.util.Scanner;

import Controladores.UsuarioControlador;
import Modelos.Usuario;

public class RegUsuario {
    public void RegistroUsuario() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        try {
            usuarioControlador.crearArchivo();

        }catch (Exception e) {
            System.out.println("Error al crear el archivo: ");
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su número de identificación");
        String numero = scanner.nextLine();
        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la direccion del Usuario: ");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el numero telefonico del Usuario: ");
        String telefonico = scanner.nextLine();
        System.out.println("Ingrese el correo del Usuario: ");
        String correo = scanner.nextLine();
        Usuario usuario = new Usuario(numero,nombre, direccion,telefonico, correo);
        usuarioControlador.guardarUsuario(usuario);
    }
    public void ListaUsuarios() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        System.out.println(usuarioControlador.MostrarUsuarios());
    }
    public void MostrarUsuario(String identificacion) {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        System.out.println(usuarioControlador.BuscarUsuario(identificacion));
    }
}