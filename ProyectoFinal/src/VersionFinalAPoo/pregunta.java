package VersionFinalAPoo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class pregunta {
    //atributos
    String palabraEspañol;
    String respuestaIngles;
    ArrayList<String>otrasRespuestasIngles=new ArrayList<>();

    //atributo si esta respuesta se guarda en un usuario
    String respuestaEscogida;

    //metodos
    //constructor
    public pregunta(){
        this.palabraEspañol=entradaString("la pregunta:");
        this.respuestaIngles=entradaString("la respuesta correcta:");
        while (otrasRespuestasIngles.size()<4) {
            otrasRespuestasIngles.add(entradaString("una respuesta incorrecta"));
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
    //setter y getters
    public String getPalabraEspañol() {
        return palabraEspañol;
    }
    public void setPalabraEspañol(String pregunta) {
        this.palabraEspañol = pregunta;
    }
    public String getRespuestaIngles() {
        return respuestaIngles;
    }
    public void setRespuestaIngles(String respuesta) {
        this.respuestaIngles = respuesta;
    }
    public String getOtrasRespuestas(int index) {
        return otrasRespuestasIngles.get(index);
    }

    public void setOtrasRespuestasIngles(ArrayList<String> otrasRespuestas) {
        this.otrasRespuestasIngles = otrasRespuestas;
    }
    public String getRespuestaEscogida() {
        return respuestaEscogida;
    }
    public void setRespuestaEscogida(String respuestaEscogida) {
        this.respuestaEscogida = respuestaEscogida;
    }
    public ArrayList<String> getOtrasRespuestasIngles() {
        return otrasRespuestasIngles;
    }
    
}
