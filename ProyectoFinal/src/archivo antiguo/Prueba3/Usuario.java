package Prueba3;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;
    private List<Calificaciones> calificaciones;

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

    public List<Calificaciones> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(Calificaciones calificacion) {
        calificaciones.add(calificacion);
    }
    public double getPorcentajeMedioPrecision() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Calificaciones calificacion : calificaciones) {
            sum += calificacion.getPorcentajeAcierto();
        }
        return sum / calificaciones.size();
}

}

