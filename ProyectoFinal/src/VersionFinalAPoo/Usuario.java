package VersionFinalAPoo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Prueba3.CalificacionUsuario;

public class Usuario {
    //atributos
    private String token;
    private List<CalificacionUsuario> calificaciones=new ArrayList<>();
    private ArrayList<pregunta> preguntasRespondidas=new ArrayList<>();
    //constructor
    public Usuario(){
        creaToken();
    }
    private void creaToken(){
        String nombre =entradaStg("su nombre","Creando token");
        String apellido=entradaStg("su apellido", "Creando token");
        int nombrelong=nombre.length();
        int apellidolong=apellido.length();
        int index=0;
        for (int i = 0; i < 2; i++) {
            index=(int)Math.floor(Math.random()*(nombrelong));
            this.token=token+nombre.charAt(index);
        }
        for (int i = 0; i < 2; i++) {
            index=(int)Math.floor(Math.random()*(apellidolong));
            this.token=token+apellido.charAt(index);
        }
    }

    private void iniciaPregunta(pregunta pregunta){
        String mensaje="";
        ArrayList<String>listaPreguntasAux=new ArrayList<>();
        listaPreguntasAux.add(pregunta.getRespuestaIngles());
        ArrayList<Integer>yaElegidas=new ArrayList<>();
        int j=0;
        for (int i = 0; i < 4; i++) { //añade de forma aleatoria 1 respuesta
            if(i==0){
                j=(int)Math.floor(Math.random()*(pregunta.getOtrasRespuestasIngles().size()-1));
            }else{
                boolean repetir=true;
                do {
                    j=(int)Math.floor(Math.random()*(pregunta.getOtrasRespuestasIngles().size()-1));
                    if(!yaElegidas.contains(j)){
                        yaElegidas.add(j);
                        repetir=false;
                    }
                }while (repetir);
            }
            listaPreguntasAux.add(pregunta.getOtrasRespuestas(j));
        }
        mensaje=pregunta.getPalabraEspañol()+"\n";
        int opcion=0;
        for (String aux2String: listaPreguntasAux) {
            mensaje+="("+opcion+") "+aux2String+"\n";
        }
        //falta un metodo para mostrar el mensaje e iniciar el cuestionario con el mensaje
            //el mensaje tiene este formato: 
                /* ingles
                 * respuesta random
                 * respuesta random
                 * respuesta random    una de esas es la correcta.
                 * respuesta random
                 * //* */
    }

    private String entradaStg(String mensaje,String titulo) {
        String cadena = null;
        while (cadena == null || cadena.isEmpty()) {
            cadena = JOptionPane.showInputDialog(null, "Ingrese "+mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
            System.out.println(cadena);
            if (cadena == null) { // para que cancele la creación de un candidato
                return "-1";
            } else if (cadena.matches(".*\\d+.*")) { // si contiene algún numero
                cadena = null;
            }
        }
        return cadena;
    }
}
