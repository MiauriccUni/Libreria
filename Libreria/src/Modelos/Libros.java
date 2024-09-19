package Modelos;
public class Libros {
    private String ISBN;
    private String Titulo;
    private String Autor;
    private String Descipcion;
    private int Cantidad;
    public Libros() {
    }
    public Libros(String ISBN, String titulo, String autor, String descipcion, int cantidad) {
        this.ISBN = ISBN;
        Titulo = titulo;
        Autor = autor;
        Descipcion = descipcion;
        Cantidad = cantidad;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String autor) {
        Autor = autor;
    }
    public String getDescipcion() {
        return Descipcion;
    }
    public void setDescipcion(String descipcion) {
        Descipcion = descipcion;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
    @Override
    public String toString() {
        return "Libros{" +
                "ISBN='" + ISBN + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Descipcion='" + Descipcion + '\'' +
                ", Cantidad=" + Cantidad +
                '}'+"\n";
    }
}
