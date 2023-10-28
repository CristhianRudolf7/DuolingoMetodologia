package Prueba2;
import Prueba2.CalificacionUsuario;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;
    private List<CalificacionUsuario> calificaciones;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<CalificacionUsuario> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(CalificacionUsuario calificacion) {
        calificaciones.add(calificacion);
    }
}
