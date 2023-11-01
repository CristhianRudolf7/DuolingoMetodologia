package VersionFinalAPoo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Usuario {
    //atributos
    private String nombre;
    private String token;
    private List<Calificaciones> calificaciones;
    //constructor
    public Usuario(){
        creaToken();
    }

    private void creaToken(){
        this.nombre =entradaStg("su nombre","Creando token");
        
        String apellido=entradaStg("su apellido", "Creando token");
        if(nombre=="-1"||apellido=="-1"){
            this.token="-1";
        }else{
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
        
    }
    public boolean borrar(){
        if(this.token=="-1"){
            return true;
        }else{
            return false;
        }
    }

    private boolean iniciaPreguntaTraduceEspañol(pregunta pregunta){
        String[]listaPreguntasAux=new String[4];
        
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
            listaPreguntasAux[i]=pregunta.getOtrasRespuestas(i);
        }
        int elegido=opcionMultiple(listaPreguntasAux, "Traduzca: "+pregunta.getRespuestaIngles(),"Pregunta");//envia la pregunta al metodo de opciones multiples
        if(elegido!=-1){
            return true; //true mencionando que si se contestó
        }else{
            return false; //false mencionando que precionó x
        }
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
    private int opcionMultiple(String[]opciones,String Mensaje,String titulo){
        //la primera opcion es 0, luego 1, luego 2, etc. Si preciona x regresa un -1
        int opcion=JOptionPane.showOptionDialog(
        null,
        Mensaje,
        titulo,
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        opciones,
        opciones[0]);
        return opcion;
    }
    public String getToken(){
        return this.token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Calificaciones> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }
    

}
