package Modelos;
import java.time.LocalDate;
public class Prestamos{
    private String Identificacion;
    private String ISBN;
    private Usuario usuario;
    private Libros libros;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    public Prestamos() {
    }
    public Prestamos(Usuario usuario, Libros libros, LocalDate fechaPrestamo, LocalDate fechaEntrega) {
        this.usuario = usuario;
        this.libros = libros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Libros getLibros() {
        return libros;
    }
    public void setLibros(Libros libros) {
        this.libros = libros;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    @Override
    public String toString() {
        return "Prestamos{" +
                "Identificacion='" + Identificacion + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", usuario=" + usuario +
                ", libros=" + libros +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaEntrega=" + fechaEntrega +
                '}'+"\n";
    }
}
