package Controladores;
import Modelos.Usuario;
import java.io.*;
import java.util.ArrayList;
public class UsuarioControlador {
    static final String NOMBRE_ARCHIVO="Usuarios.txt";
    public String crearArchivo(){
        try {
            File file = new File (NOMBRE_ARCHIVO);
            file.createNewFile();
        }
        catch (IOException e){
            System.out.println("No se pudo crear el archivo");
        }
        return "Archivo creado exitosamente";
    }
    public String RegistroUsuario(Usuario usuario) {
        return  usuario.getIdentificacion()+","+usuario.getNombre()+","+usuario.getDireccion()+","+usuario.getCorreo()+","+usuario.getCelular();
    }
    public void guardarUsuario(Usuario usuario) {
        FileWriter writer = null;
        BufferedWriter buffer = null;
        try {
            writer = new FileWriter(NOMBRE_ARCHIVO, true);
            buffer = new BufferedWriter(writer);
            buffer.write(this.RegistroUsuario(usuario));
            buffer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                buffer.close();
            }catch (IOException e) {
                System.out.println("Error al cerrar el archivo: ");
                System.out.println(e);
            }
        }
    }
    public ArrayList<Usuario> MostrarUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try{
            FileReader fr = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine())!= null){
                String[] datos = linea.split(",");
                if(datos.length == 5){
                    Usuario usuario = new Usuario();
                    usuario.setIdentificacion(datos[0]);
                    usuario.setNombre(datos[1]);
                    usuario.setDireccion(datos[2]);
                    usuario.setCorreo(datos[3]);
                    usuario.setCelular(datos[4]);
                    listaUsuarios.add(usuario);
                }
            }
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    public Usuario BuscarUsuario(String identificacion){
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        for(Usuario usuario : usuarioControlador.MostrarUsuarios()){
            if (usuario.getIdentificacion().equals(identificacion)){
                return usuario;
            }else {
                System.out.println("El usuario no existe");
            }
        }
        return null;
    }
}