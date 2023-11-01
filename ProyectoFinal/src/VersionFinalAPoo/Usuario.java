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

    public void cuestionarioIngles_Español(ArrayList<pregunta> listaDePreguntas){ //inica el cuestionario de 5 preguntas
        ArrayList<pregunta>listaSeleccionada=new ArrayList<>();
        for (int i = 0; i < 5; i++) {//añade las preguntas de forma aleatoria
            if(i==0){
                listaDePreguntas.add(listaDePreguntas.get((int)Math.floor(Math.random()*(listaDePreguntas.size()-1))));
            }else{
                do{
                    pregunta preguntaAux=listaDePreguntas.get((int)Math.floor(Math.random()*(listaDePreguntas.size()-1)));
                    if(!listaSeleccionada.contains(preguntaAux)){
                        listaDePreguntas.add(preguntaAux);
                        break;
                    }
                }while(true);
            }
        }
        int correctas=0;
        int totales=0;
        for (pregunta pregunta : listaSeleccionada) {
            boolean correcto=pregunta.cuestionario();
            if(correcto){
                correctas++;
            }
            totales++;
        }
        calificaciones.add(new Calificaciones(totales, correctas));//añade lo respondido a calificaciones.
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
