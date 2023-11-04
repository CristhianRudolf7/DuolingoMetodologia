package VersionFinalAPoo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class Menu {
    // atributos
    ArrayList<pregunta> listaDePreguntas = new ArrayList<>();
    ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
 

    // metodos
    public void menu() {
        rellenaPreguntasStandar();
        listaDeUsuarios.add(new Usuario("1234", true));
        do {
            Usuario user;
            String[] opciones = { "Iniciar Sesión", "Registarse", "Descargar notas", "Salir" };
            int opcion = opcionMultiple(opciones, "Bienvenido", "Menú principal");
            switch (opcion) {
                case 0:// inicia seción
                    user = iniciaSesion();
                    if (user.esEstudiante()) {// si es un estudiante
                        estudiante(user);//inicia el menú de estudiante
                    } else if (user.esAdmin()) {// si es un administrador
                        admin(user);//inicia el menú de admin
                    }
                    break;
                case 1:// registrate
                    listaDeUsuarios.add(new Usuario());
                    break;
                case 2: // descargar notas
                    break;
                case 3:
                    int aux = JOptionPane.showConfirmDialog(null, "¡Esta seguro que quiere salir?");
                    if (aux == 0) {
                        System.exit(0);
                    }
                    break;
                default:
                    break;
            }
        } while (true);//solo se sale precionando x o salir

    }

    // inicio de seción
    public Usuario iniciaSesion() {
        String tokenaux;
        Usuario userFinal = null;
        boolean error = true;
        do {
            tokenaux = JOptionPane.showInputDialog("Ingrese su token de acceso:");// entrada del token
            if (tokenaux == null) {
                int aux = JOptionPane.showConfirmDialog(null, "¡Esta seguro que quiere salir?");
                if (aux == 0) {
                    System.exit(0);
                }
            } else {// busca e ltoken
                for (Usuario usuarioaux : listaDeUsuarios) {
                    if (usuarioaux.getToken().equals(tokenaux)) {
                        userFinal = usuarioaux;
                        error = false;
                        break;
                    }
                }

            }
        } while (error);
        return userFinal;// devuelve el usuario
    }

    // crea nuevo usuario
    public void registrate() {
        listaDeUsuarios.add(new Usuario());
        if (listaDeUsuarios.get(listaDeUsuarios.size() - 1).borrar()) {// elimina el objeto creado si le da a cancelar
                                                                       // en algun momento
            listaDeUsuarios.remove(listaDeUsuarios.size() - 1);
        }
    }

    public void estudiante(Usuario user) {
        int opcion;
        do {
            String[] opciones = { "Cuestionario", "Calificaciones", "Salir" };
            opcion = opcionMultiple(opciones, "¿Qué va a realizar?", "Menú Estudiante");
            switch (opcion) {
                case 0:// cuestionario
                    String[] opciones2 = { "Español a Ingles", "Ingles a Español", "Salir" };
                    opcion = opcionMultiple(opciones2, "Iniciar Cuestionario:", "Cuestionarios");
                    switch (opcion) {
                        case 0:// español a ingles
                            user.cuestionarioEspañol_Ingles(listaDePreguntas);
                            break;
                        case 1:// ingles a español
                            user.cuestionarioIngles_Español(listaDePreguntas);
                            break;

                        default:// salir o x
                            break;
                    }
                    break;
                case 1:// calificaciones
                    break;
                default:
                    break;
            }
        } while (opcion != 2);

    }

    // metodos para estudiantes
    // traduce ingles a español ; traduce de español a ingles;
    // inicia cuestionario random.
    // ver calificaciones.
    // descargar pdf.
    public void admin(Usuario user) {

    }

    private void rellenaPreguntasStandar(){
        //1 pregunta
        ArrayList <String>ArrayIngles=new ArrayList<>();
        Collections.addAll(ArrayIngles, "Misfortune","Journey","Fare","Campaign");
        ArrayList <String>ArrayEspañol=new ArrayList<>();
        Collections.addAll(ArrayEspañol, "Experiencia","Peligro","Recorrido","Odisea");
        listaDePreguntas.add(new pregunta("Aventura", "Adventure",ArrayIngles, ArrayEspañol));
        ArrayIngles.clear();
        ArrayEspañol.clear();
        //2 pregunta
        Collections.addAll(ArrayIngles,"Functional","Competent","Efficacious","Capable");
        Collections.addAll(ArrayEspañol, "Eficaz","Competente","Productivo","Hábil");
        listaDePreguntas.add(new pregunta("Eficiente", "Efficient", ArrayIngles, ArrayEspañol));
        ArrayIngles.clear();
        ArrayEspañol.clear();
        //pregunta 3
        Collections.addAll(ArrayIngles,"Outcome","Implication","Repercussion","Event");
        Collections.addAll(ArrayEspañol, "Resultado","Impacto","Efecto","Circunstancia");
        listaDePreguntas.add(new pregunta("Consequence", "Consecuencia", ArrayIngles, ArrayEspañol));
        ArrayIngles.clear();
        ArrayEspañol.clear();
        //pregunta 4
        Collections.addAll(ArrayIngles,"Luminous","Dynamic","Graphic","Lifekike");
        Collections.addAll(ArrayEspañol, "Brillante","Intenso","Colorido","Realista");
        listaDePreguntas.add(new pregunta("Vívido", "Vivid", ArrayIngles, ArrayEspañol));
        ArrayIngles.clear();
        ArrayEspañol.clear();
        //pregunta 5
        Collections.addAll(ArrayIngles,"Adaptable","Tough","Steadfast","Sturdy");
        Collections.addAll(ArrayEspañol, "Flexible","Resistente","Firme","Fuerte");
        listaDePreguntas.add(new pregunta("Resiliente", "Resilient", ArrayIngles, ArrayEspañol));
        ArrayIngles.clear();
        ArrayEspañol.clear();
    }

    public void calificaciones() throws DocumentException {// si accede a sus calificaciones con su token sin iniciar
                                                           // secion
        Usuario useraux = iniciaSesion();
        descargarPDF(useraux);
    }

    public void descargarPDF(Usuario user) throws DocumentException {
        String tokenaux = entradaStg("Ingrese su token:", "Descargar pdf");
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getToken().equals(tokenaux)) {
                user = usuario;
            }
        }
        if (user.equals(null)) {

        }

        try {
            Document documento = new Document();
            String titulo = user.getNombre() + ".pdf";
            String mensaje = "Calificaciones de " + user.getNombre() + ":\n";
            int i = 0;
            List<Calificaciones> calificaciones = user.getCalificaciones();
            for (Calificaciones calificacion : calificaciones) {
                i++;
                mensaje += "\nLas calificaiones del examen " + i + " son:\n";
                mensaje += "Total de preguntas: " + calificacion.getPreguntasRealizadas() + "\n";
                mensaje += "Preguntas correctas: " + calificacion.getPreguntasCorrectas() + "\n";
                double porcentajeAcierto = (double) calificacion.getPreguntasCorrectas()
                        / calificacion.getPreguntasRealizadas() * 100.0;
                mensaje += "Porcentaje de acierto: " + porcentajeAcierto + "%\n";
            }
            PdfWriter.getInstance(documento, new FileOutputStream(titulo));
            documento.open();
            Phrase escribir = new Phrase(mensaje);
            documento.add(escribir);
            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // metodos para admin
    // registra una pregunta.
    // mira las calificaciones de cada estudiante.

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

    public int opcionMultiple(String[] opciones, String Mensaje, String titulo) {
        int respuestaUsuario = JOptionPane.showOptionDialog(
                null,
                Mensaje,
                titulo,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_CANCEL_OPTION,
                null,
                opciones,
                opciones[0]);
        return respuestaUsuario; // Si preciona x devuelve -1
    }

}
