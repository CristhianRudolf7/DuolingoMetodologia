package Prueba3;
public class Calificaciones {
    private int preguntasRealizadas;
    private int preguntasCorrectas;

    public Calificaciones(int preguntasRealizadas, int preguntasCorrectas) {
        this.preguntasRealizadas = preguntasRealizadas;
        this.preguntasCorrectas = preguntasCorrectas;
    }

    public int getPreguntasRealizadas() {
        return preguntasRealizadas;
    }

    public int getPreguntasCorrectas() {
        return preguntasCorrectas;
    }

    public double getPorcentajeAcierto() {
        if (preguntasRealizadas == 0) {
            return 0.0;
        }
        return ((double) preguntasCorrectas / preguntasRealizadas) * 100.0;
    }
}


