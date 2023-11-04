package VersionFinalAPoo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class pregunta {
    //atributos
    String palabraEspañol;
    String palabraIngles;
    ArrayList<String>otrasRespuestasIngles;
    ArrayList<String>otrasRespuestasEspañol;

    

    //metodos
    //constructores
    public pregunta(){ //crea la pregunta
        otrasRespuestasEspañol=new ArrayList<>();
        otrasRespuestasIngles=new ArrayList<>();
        this.palabraEspañol=entradaString("la pregunta:");
        this.palabraIngles=entradaString("la respuesta correcta:");
        while (otrasRespuestasIngles.size()<4) {
            otrasRespuestasIngles.add(entradaString("una respuesta incorrecta (ingles)"));
        }
        while (otrasRespuestasIngles.size()<4) {
            otrasRespuestasEspañol.add(entradaString("una respuesta incorrecta (español)"));
        }
    }
    public pregunta(String correctaEspañol, String correctaIngles, ArrayList<String> AlternativasIngles,ArrayList<String> AlternativasEspañol) { 
        otrasRespuestasEspañol=new ArrayList<>();
        otrasRespuestasIngles=new ArrayList<>();
        this.palabraEspañol = correctaEspañol;
        this.palabraIngles = correctaIngles;
        for (String string : AlternativasEspañol) {
            this.otrasRespuestasEspañol.add(string);
        }
        for (String string : AlternativasIngles) {
            this.otrasRespuestasIngles.add(string);
        }
    }



    //entrada
    private String entradaString(String mensaje){
        String aux=null;
        do{
            aux=JOptionPane.showInputDialog(null,"Ingrese "+mensaje);
            if(aux!=null&& aux.matches(".*\\d+.*")){
                int aux2=JOptionPane.showConfirmDialog(null, "Esta seguro que quiere registrar:\n"+aux);
                if(aux2==0){
                    break;
                }
            }
        }while(true);
        return aux;
    }
    /*
     * Inicia la pregunta
     */

    //inicia pregunta español (pregunta) a ingles (respuestas)
    
    public boolean iniciaPreguntaEspañolIngles() {
        // Crear un array para almacenar las opciones, incluyendo la respuesta correcta
        // y otras opciones
        String[] opciones = new String[4];

        // Agregar la respuesta correcta y otras opciones al array
        opciones[0] = palabraIngles;
        for (int i = 0; i < 3; i++) {
            opciones[i + 1] = this.otrasRespuestasIngles.get(i);
        }

        // Mezclar todas las opciones de forma aleatoria
        mezclarArray(opciones);

        // Identificar la posición de la respuesta correcta en el array
        int respuestaCorrectaIndex = 0;
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equals(palabraIngles)) {
                respuestaCorrectaIndex = i;
                break;
            }
        }

        // Llamar al método opcionMultiple() para que el usuario seleccione una opción
        int respuestaUsuario = opcionMultiple(palabraEspañol, opciones);

        // Verificar si la respuesta es correcta
        boolean respuestaCorrecta = (respuestaUsuario == respuestaCorrectaIndex);
        return respuestaCorrecta;
    }

    //inicia pregunta ingles (pregunta) a español (respuestas)

    public boolean iniciaPreguntaInglesEspañol() {
        // Crear un array para almacenar las opciones, incluyendo la respuesta correcta
        // y otras opciones
        String[] opciones = new String[4];

        // Agregar la respuesta correcta y otras opciones al array
        opciones[0] = palabraEspañol;
        for (int i = 0; i < 3; i++) {
            opciones[i + 1] = this.otrasRespuestasEspañol.get(i);
        }

        // Mezclar todas las opciones de forma aleatoria
        mezclarArray(opciones);

        // Identificar la posición de la respuesta correcta en el array
        int respuestaCorrectaIndex = 0;
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equals(palabraEspañol)) {
                respuestaCorrectaIndex = i;
                break;
            }
        }

        // Llamar al método opcionMultiple() para que el usuario seleccione una opción
        int respuestaUsuario = opcionMultiple(palabraIngles, opciones);

        // Verificar si la respuesta es correcta
        boolean respuestaCorrecta = (respuestaUsuario == respuestaCorrectaIndex);
        return respuestaCorrecta;
    }


    /*
     * Generador de  opciones múltiples y ottros métodos
     */

    public int opcionMultiple(String Pregunta, String[] opciones) {
        // Mostrar el cuestionario en JOptionPane
        String respuestaUsuario = (String) JOptionPane.showInputDialog(
                null,
                "Traduce la palabra '" + palabraEspañol + "':",
                "Cuestionario",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // Devolver el índice de la respuesta del usuario en el array de opciones
        for (int i = 0; i < opciones.length; i++) {
            if (respuestaUsuario != null && respuestaUsuario.equals(opciones[i])) {
                return i;
            }
        }
        return -1; // Si la respuesta es nula o no coincide con las opciones disponibles
    }

    public void mezclarArray(String[] array) { //aleatoriza el array que se le dá
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


    //setter y getters
    public String getPalabraEspañol() {
        return palabraEspañol;
    }
    public void setPalabraEspañol(String pregunta) {
        this.palabraEspañol = pregunta;
    }
    public String getPalabraIngles() {
        return palabraIngles;
    }
    public void setPalabraIngles(String respuesta) {
        this.palabraIngles = respuesta;
    }
    public String getOtrasRespuestas(int index) {
        return otrasRespuestasIngles.get(index);
    }

    public void setOtrasRespuestasIngles(ArrayList<String> otrasRespuestas) {
        this.otrasRespuestasIngles = otrasRespuestas;
    }
    public ArrayList<String> getOtrasRespuestasIngles() {
        return otrasRespuestasIngles;
    }
    
}
