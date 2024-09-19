package Modelos;
public class Usuario {
    private String Identificacion;
    private String nombre;
    private String direccion;
    private String correo;
    private String celular;
    public Usuario() {
    }
    public Usuario(String identificacion, String nombre, String direccion, String celular,String correo) {
        Identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                '}'+"\n";
    }
}
