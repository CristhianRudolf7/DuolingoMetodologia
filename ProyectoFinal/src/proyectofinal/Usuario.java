package proyectofinal;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String contraseña;
    private String token;
    private ArrayList<CalificacionUsuario> calificaciones;

    public Usuario(String nombre, String contraseña, String token) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.token = token;
        this.calificaciones = new ArrayList<>();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getNombre() {
        return nombre;
    }


    public String getContraseña() {
        return contraseña;
    }

    public ArrayList<CalificacionUsuario> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(CalificacionUsuario calificacion) {
        calificaciones.add(calificacion);
    }
    public double getPorcentajeMedioPrecision() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (CalificacionUsuario calificacion : calificaciones) {
            sum += calificacion.getPorcentajeAcierto();
        }
        return sum / calificaciones.size();
}

}

