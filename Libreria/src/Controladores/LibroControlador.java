package Controladores;
import Modelos.Libros;
import java.io.*;
import java.util.ArrayList;
public class LibroControlador {
    static final String NOMBRE_ARCHIVO = "Libros.txt";
    public String crearArchivo(){
        try{
            File file = new File(NOMBRE_ARCHIVO);
            file.createNewFile();
        }
        catch (IOException e){
            System.out.println("No se pudo crear el archivo");
        }
        return "Archivo creado correctamente";
    }
    public String RegistroLibro(Libros libro){
        return  libro.getISBN()+","+libro.getTitulo()+","+libro.getAutor()+","+libro.getDescipcion()+","+libro.getCantidad();
    }
    public void guardarLibro(Libros libro){
        FileWriter writer = null;
        BufferedWriter buffer = null;
        try {
            writer = new FileWriter(NOMBRE_ARCHIVO, true);
            buffer = new BufferedWriter(writer);
            buffer.write(this.RegistroLibro(libro));
            buffer.newLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                buffer.close();
            }
            catch (IOException e){
                System.out.println("No se pudo cerrar el archivo");
                System.out.println(e);
            }
        }
    }
    public ArrayList<Libros> listarLibros(){
        ArrayList<Libros> listaLibros = new ArrayList<>();
        try {
            FileReader fr = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if(datos.length == 5){
                    Libros libro = new Libros();
                    libro.setISBN(datos[0]);
                    libro.setTitulo(datos[1]);
                    libro.setAutor(datos[2]);
                    libro.setDescipcion(datos[3]);
                    libro.setCantidad(Integer.parseInt(datos[4]));
                    listaLibros.add(libro);
                }
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return listaLibros;
    }
    public Libros BucarLibro(String ISBN){
        for(Libros libro : listarLibros()){
            if(libro.getISBN().equals(ISBN)){
                return libro;
            }
            else {
                System.out.println("El libro no existe");
            }
        }
        return null;
    }
}
