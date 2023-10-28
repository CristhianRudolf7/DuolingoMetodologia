package VersionFinalAPoo;

public class Calificaciones {
    //atributos
    private int respuestasCorrectas;
    private int preguntasTotales;
    //métodos
    public Calificaciones(int respuestasCorrectas, int preguntasTotales){
        this.respuestasCorrectas=respuestasCorrectas;
        this.preguntasTotales=preguntasTotales;
    }
    public int getRespuestasCorrectas(){
        return respuestasCorrectas;
    }
    public int getPreguntasTotales(){
        return preguntasTotales;
    }
}
