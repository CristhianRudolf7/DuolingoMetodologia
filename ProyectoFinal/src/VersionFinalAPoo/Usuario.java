package VersionFinalAPoo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {
    // atributos
    private String nombre;
    private String apellido;
    private String token;
    private ArrayList<Calificaciones> calificaciones = new ArrayList<>();
    boolean esEstudiante;
    boolean esAdmin;

    // constructor
    public Usuario(String token, boolean esAdmin) {
        this.token = token;
        this.esAdmin = esAdmin;
        if (!esAdmin) {
            this.esEstudiante = true;
        }
    }

    public Usuario() {
        creaToken();
    }

    private void creaToken(){
        this.nombre =entradaStg("su nombre","Creando token");
        this.apellido=entradaStg("su apellido", "Creando token");
        token="";
        if(nombre=="-1"||apellido=="-1"){
            this.token="-1";
        }else{
            int nombrelong=nombre.length();
            int apellidolong=apellido.length();
            int index=0;
            for (int i = 0; i < 2; i++) {
                index=(int)Math.floor(Math.random()*(nombrelong));
                String charaux=""+nombre.charAt(index);
                charaux=charaux.toLowerCase();
                if((int)Math.round(Math.random())==1){ //en minuscula
                    this.token=token+charaux;
                }else{//en mayuscula
                    charaux=charaux.toUpperCase();
                    this.token=token+charaux;
                }
                
            }
            for (int i = 0; i < 2; i++) {
                index=(int)Math.floor(Math.random()*(apellidolong));
                String charaux=""+apellido.charAt(index);
                charaux=charaux.toLowerCase();
                if((int)Math.round(Math.random())==1){ //en minuscula
                    this.token=token+charaux;
                }else{//en mayuscula
                    charaux=charaux.toUpperCase();
                    this.token=token+charaux;
                }
            }
            System.out.println("token: "+token);
        }
        do{
            JOptionPane.showMessageDialog(null, "Su token de acceso es:\n"+token+"\n(incluye mayusculas y minusculas)");
            String confirmador=JOptionPane.showInputDialog("para continuar, confirme su token:");
            if(confirmador.equals(token)){
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\nya puede iniciar sesión");
                break;
            }else{
                JOptionPane.showMessageDialog(null, "EL token ingresado no es el correcto, intentelo otra vez");
            }
        }while(true);
        this.esEstudiante=true;
        this.esAdmin=false;
    }

    public boolean borrar() {
        if (this.token == "-1") {
            return true;
        } else {
            return false;
        }
    }

    public void cuestionarioEspañol_Ingles(ArrayList<pregunta> listaDePreguntas) { // inica el cuestionario de 5
                                                                                   // preguntas

        ArrayList<pregunta> listaSeleccionada = new ArrayList<>();
        for (int i = 0; i < 4; i++) {// añade las preguntas de forma aleatoria
            if (i == 0) {
                listaSeleccionada
                        .add(listaDePreguntas.get((int) Math.floor(Math.random() * (listaDePreguntas.size() - 1))));
            } else {
                boolean repetir = true;
                do {
                    pregunta preguntaAux = listaDePreguntas
                            .get((int) Math.floor(Math.random() * (listaDePreguntas.size() - 1)));
                    if (!listaSeleccionada.contains(preguntaAux)) {
                        listaSeleccionada.add(preguntaAux);
                        System.out.println(listaSeleccionada.toString()); // auxiliar para saber si hay algun error
                        repetir = false;
                    }
                } while (repetir);
            }
        }
        int correctas = 0;
        int totales = 0;
        for (pregunta pregunta : listaSeleccionada) {
            boolean correcto = pregunta.iniciaPreguntaEspañolIngles();
            if (correcto) {
                correctas++;
            }
            totales++;
        }
        calificaciones.add(new Calificaciones(totales, correctas));// añade lo respondido a calificaciones, una nueva
                                                                   // calificacion por 1 questionario
    }

    public void cuestionarioIngles_Español(ArrayList<pregunta> listaDePreguntas) { // inica el cuestionario de 5
                                                                                   // preguntas
        ArrayList<pregunta> listaSeleccionada = new ArrayList<>();
        for (int i = 0; i < 4; i++) {// añade las preguntas de forma aleatoria
            if (i == 0) {
                listaSeleccionada
                        .add(listaDePreguntas.get((int) Math.floor(Math.random() * (listaDePreguntas.size() - 1))));
            } else {
                boolean repetir = true;
                do {
                    pregunta preguntaAux = listaDePreguntas
                            .get((int) Math.floor(Math.random() * (listaDePreguntas.size() - 1)));
                    if (!listaSeleccionada.contains(preguntaAux)) {
                        listaSeleccionada.add(preguntaAux);
                        repetir = false;
                    }
                } while (repetir);
            }
        }
        int correctas = 0;
        int totales = 0;
        for (pregunta pregunta : listaSeleccionada) {
            boolean correcto = pregunta.iniciaPreguntaInglesEspañol();
            if (correcto) {
                correctas++;
            }
            totales++;
        }
        calificaciones.add(new Calificaciones(totales, correctas));// añade lo respondido a calificaciones.
    }

    private String entradaStg(String mensaje, String titulo) {
        String cadena = null;
        while (cadena == null || cadena.isEmpty()) {
            cadena = JOptionPane.showInputDialog(null, "Ingrese " + mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            System.out.println(cadena);
            if (cadena == null) { // para que cancele la creación de un candidato
                return "-1";
            } else if (cadena.matches(".*\\d+.*")) { // si contiene algún numero
                cadena = null;
            }
        }
        return cadena;
    }

    public boolean esEstudiante() {
        return esEstudiante;
    }

    public boolean esAdmin() {
        return esAdmin;
    }

    public String getToken() {
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

    public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

}
