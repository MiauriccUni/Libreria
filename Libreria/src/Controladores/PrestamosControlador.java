package Controladores;
import Modelos.Libros;
import Modelos.Prestamos;
import Modelos.Usuario;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class PrestamosControlador {
    static final String PRESTAMOS = "Prestamos.txt";
    public String crear(){
        try {
            File file = new File(PRESTAMOS);
            file.createNewFile();
        }catch (IOException e){
            System.out.println("No se pudo crear el archivo");
        }
        return "Archivo creado correctamente";
    }
    public String guardar(Prestamos prestamos){
        return  prestamos.getLibros()+","+prestamos.getUsuario()+","+prestamos.getFechaPrestamo()+","+prestamos.getFechaEntrega();
    }
    public String PrestarVal(Usuario usuario, Libros libros){
        String msg = "";
        if(libros.getCantidad() >= 1){
            LocalDate fechaPrestamo = LocalDate.now();
            LocalDate fechaEntrega = fechaPrestamo.plusDays(7);
            Prestamos prestamos = new Prestamos(usuario, libros, fechaPrestamo, fechaEntrega);
            RealizarPrestamo(prestamos);
            msg = "Se realiza el prestamo";
        }else{
            msg = "El libro " + usuario.getNombre() + " no tiene copias disponibles para prestar.";
        }
        return msg;
    }
    public void RealizarPrestamo(Prestamos prestamo){
        FileWriter writer = null;
        BufferedWriter buffer = null;
        try{
            writer = new FileWriter(PRESTAMOS);
            buffer = new BufferedWriter(writer);
            buffer.write(this.guardar(prestamo));
            buffer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                buffer.close();
            }catch (IOException e){
                System.out.println("No se pudo cerrar el archivo");
                System.out.println(e.getMessage());
            }
        }
    }
    public ArrayList<Prestamos> MostrarPrestamos() {
        ArrayList<Prestamos> prestamos = new ArrayList<>();
        try {
            FileReader reader = new FileReader("PRESTAMOS.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String libroData = datos[0].substring(datos[0].indexOf("{") + 1, datos[0].indexOf("}"));
                    String[] libroFields = libroData.split(", ");
                    Libros libros = new Libros();
                    libros.setISBN(libroFields[0].split("=")[1].replace("'", ""));
                    libros.setTitulo(libroFields[1].split("=")[1].replace("'", ""));
                    libros.setAutor(libroFields[2].split("=")[1].replace("'", ""));
                    libros.setDescipcion(libroFields[3].split("=")[1].replace("'", ""));
                    libros.setCantidad(Integer.parseInt(libroFields[4].split("=")[1]));
                    String usuarioData = datos[1].substring(datos[1].indexOf("{") + 1, datos[1].indexOf("}"));
                    String[] usuarioFields = usuarioData.split(", ");
                    Usuario usuario = new Usuario();
                    usuario.setNombre(usuarioFields[0].split("=")[1].replace("'", ""));
                    usuario.setDireccion(usuarioFields[1].split("=")[1].replace("'", ""));
                    usuario.setCorreo(usuarioFields[2].split("=")[1].replace("'", ""));
                    usuario.setCelular(usuarioFields[3].split("=")[1].replace("'", ""));
                    Prestamos prestamo = new Prestamos();
                    prestamo.setLibros(libros);
                    prestamo.setUsuario(usuario);
                    prestamo.setFechaPrestamo(LocalDate.parse(datos[2]));
                    prestamo.setFechaEntrega(LocalDate.parse(datos[3]));
                    prestamos.add(prestamo);
                    System.out.println("Added Prestamos: " + prestamo);
                }
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prestamos;
    }
    public void DevolverPrestamo(String id) {


        File inputFile = new File("C:\\Programacion con Patrones\\Libreria\\Libros.txt");
        File tempFile = new File("Libros.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
          BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

         String currentLine;

         while ((currentLine = reader.readLine()) != null) {
             if (currentLine.startsWith(id + ",")) {
                 String[] parts = currentLine.split(",");
                 int currentValue = Integer.parseInt(parts[4]);
                 parts[4] = String.valueOf(currentValue + 1);
                 currentLine = String.join(",", parts);
             }
             writer.write(currentLine + System.lineSeparator());
         }
        } catch (IOException e) {
         e.printStackTrace();
        }
        if (!inputFile.delete()) {
         System.out.println("No se logro borrar el archivo");
         return;
        }
        if (!tempFile.renameTo(inputFile)) {
         System.out.println("Error al renombrar el archivo");
        }
    }
}



