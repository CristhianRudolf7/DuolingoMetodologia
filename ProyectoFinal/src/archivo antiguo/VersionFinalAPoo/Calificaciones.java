package VersionFinalAPoo;

public class Calificaciones {
    //atributos
    private int preguntasRealizadas;
    private int preguntasCorrectas;

    //metodos
    public Calificaciones(int preguntasRealizadas, int preguntasCorrectas){
        this.preguntasRealizadas=preguntasRealizadas;
        this.preguntasCorrectas=preguntasCorrectas;
    }
    public float getPorcentajeAcierto(){
        if(preguntasRealizadas==0){
            return 0;
        }
        return (float) 100*preguntasCorrectas/preguntasRealizadas;
    }

    //setter y getters

    public int getPreguntasRealizadas() {
        return preguntasRealizadas;
    }

    public void setPreguntasRealizadas(int preguntasRealizadas) {
        this.preguntasRealizadas = preguntasRealizadas;
    }

    public int getPreguntasCorrectas() {
        return preguntasCorrectas;
    }

    public void setPreguntasCorrectas(int preguntasCorrectas) {
        this.preguntasCorrectas = preguntasCorrectas;
    }
    

}
