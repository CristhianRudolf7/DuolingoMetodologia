package Prueba2;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba6 {
    public static void main(String[] args) throws DocumentException{
        // Listas de verbos en inglés y sus traducciones en español
        List<String> verbosIngles = new ArrayList<>();
        Collections.addAll(verbosIngles, "arrived", "become", "buy", "bring", "bite", "break", "cook", "come", "clean", "cry", "drive", "dive", "do");

        List<String> traduccionesEspanol = new ArrayList<>();
        Collections.addAll(traduccionesEspanol, "llegar", "llegar a ser", "comprar", "traer", "morder", "romper", "cocinar", "venir", "limpiar", "llorar", "manejar", "buzear", "hacer");

        // ArrayList para almacenar las calificaciones de los usuarios
        List<Usuario> usuarios = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n1. Ingresar con una cuenta\n2. Crear una cuenta\n0. Salir");
            if (opcion.equals("1")) {
                String correo = JOptionPane.showInputDialog("Ingrese su correo:");
                String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña");
                Usuario usuario = encontrarUsuario(usuarios, correo, contraseña);
                if (usuario != null) {
                    String menuD = "Bienvenido:\n";
                    menuD += "Nombre: " + usuario.getNombre() + "\n";
                    menuD += "Correo: " + usuario.getCorreo() + "\n";

                    while (true) {
                        opcion = JOptionPane.showInputDialog(menuD + "¿Qué deseas realizar?\n1. Traducir del inglés al español\n2. Traducir del español al inglés\n3. Ver calificaciones\n4. Descargar PDF de notas\n0. Salir");
                        if (opcion.equals("1")) {
                            CalificacionUsuario calificacion = traducirInglesEspanol(verbosIngles, traduccionesEspanol);
                            usuario.agregarCalificacion(calificacion);
                        } else if (opcion.equals("2")) {
                            CalificacionUsuario calificacion = traducirEspanolIngles(verbosIngles, traduccionesEspanol);
                            usuario.agregarCalificacion(calificacion);
                        } else if (opcion.equals("3")) {
                            verCalificaciones(usuario);
                        }
                        else if (opcion.equals("4")) {
                            try{
                                Document documento = new Document();
                                String titulo = usuario.getNombre()+".pdf";
                                String mensaje="Calificaciones de " + usuario.getNombre() + ":\n";
    int i=0;
    List<CalificacionUsuario> calificaciones = usuario.getCalificaciones();
    for (CalificacionUsuario calificacion : calificaciones) {
        i++;
        mensaje+="\nLas calificaiones del examen "+i+" son:\n";
        mensaje+="Total de preguntas: "+calificacion.getPreguntasRealizadas()+"\n";
    mensaje+="Preguntas correctas: "+calificacion.getPreguntasCorrectas()+"\n";
    double porcentajeAcierto = (calificacion.getPreguntasRealizadas() > 0) ? (double) calificacion.getPreguntasCorrectas() / calificacion.getPreguntasRealizadas()* 100.0 : 0.0;
    mensaje+="Porcentaje de acierto: "+porcentajeAcierto+"%\n";
    }
                                PdfWriter.getInstance(documento, new FileOutputStream(titulo));
                                documento.open();
                                Phrase escribir = new Phrase(mensaje);
                                documento.add(escribir);
                                documento.close();
                            }catch (FileNotFoundException ex){
                                Logger.getLogger(Prueba6.class.getName()).log(Level.SEVERE, null, ex);}
                        }
                        else if (opcion.equals("0")) {
                            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige 1, 2, 3 o 0.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos. Intente nuevamente.");
                }
            } else if (opcion.equals("2")) {
                String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
                String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
                String contraseñaNueva = JOptionPane.showInputDialog("Registre una contraseña:");
                String correoElectronico = nombre + apellido + "@gmail.com";
                Usuario nuevoUsuario = new Usuario(nombre, correoElectronico, contraseñaNueva);
                usuarios.add(nuevoUsuario);
                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente. Su correo electrónico es: " + correoElectronico);
            } else if (opcion.equals("0")) {
                continuar = false;
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static CalificacionUsuario traducirInglesEspanol(List<String> verbosIngles, List<String> traduccionesEspanol) {
    Random random = new Random();
    int totalPreguntas = 0;
    int preguntasCorrectas = 0;

    while (true) {
        int indice = random.nextInt(verbosIngles.size());
        String verboIngles = verbosIngles.get(indice);
        String traduccionCorrecta = traduccionesEspanol.get(indice);

        List<String> alternativas = new ArrayList<>();
        alternativas.add(traduccionCorrecta);

        while (alternativas.size() < 4) {
            String alternativa = traduccionesEspanol.get(random.nextInt(traduccionesEspanol.size()));
            if (!alternativas.contains(alternativa)) {
                alternativas.add(alternativa);
            }
        }

        Collections.shuffle(alternativas);

        String mensaje = "Traduce el verbo '" + verboIngles + "' al español:\n";
        for (int i = 0; i < alternativas.size(); i++) {
            mensaje += (i + 1) + ". " + alternativas.get(i) + "\n";
        }

        String respuesta = JOptionPane.showInputDialog(mensaje + "Ingresa tu respuesta o escribe 0 para salir al menú principal:");

        if (respuesta.equals("0")) {
            break; // Salir del bucle si se ingresa 0
        } else if (respuesta.equals("1") && alternativas.get(0).equals(traduccionCorrecta)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("2") && alternativas.get(1).equals(traduccionCorrecta)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("3") && alternativas.get(2).equals(traduccionCorrecta)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("4") && alternativas.get(3).equals(traduccionCorrecta)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La traducción correcta es: '" + traduccionCorrecta + "'\n\n");
        }

        totalPreguntas++;
    }
    return new CalificacionUsuario(totalPreguntas, preguntasCorrectas);
    // Aquí puedes agregar la calificación al usuario si lo deseas
}

public static CalificacionUsuario traducirEspanolIngles(List<String> verbosIngles, List<String> traduccionesEspanol) {
    Random random = new Random();
    int totalPreguntas = 0;
    int preguntasCorrectas = 0;

    while (true) {
        int indice = random.nextInt(verbosIngles.size());
        String traduccionEspanol = traduccionesEspanol.get(indice);
        String verboIngles = verbosIngles.get(indice);

        List<String> alternativas = new ArrayList<>();
        alternativas.add(verboIngles);

        while (alternativas.size() < 4) {
            String alternativa = verbosIngles.get(random.nextInt(verbosIngles.size()));
            if (!alternativas.contains(alternativa)) {
                alternativas.add(alternativa);
            }
        }

        Collections.shuffle(alternativas);

        String mensaje = "Traduce la palabra '" + traduccionEspanol + "' al inglés:\n";
        for (int i = 0; i < alternativas.size(); i++) {
            mensaje += (i + 1) + ". " + alternativas.get(i) + "\n";
        }

        String respuesta = JOptionPane.showInputDialog(mensaje + "Ingresa tu respuesta o escribe 0 para salir al menú principal:");

        if (respuesta.equals("0")) {
            break; // Salir del bucle si se ingresa 0
        } else if (respuesta.equals("1") && alternativas.get(0).equals(verboIngles)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("2") && alternativas.get(1).equals(verboIngles)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("3") && alternativas.get(2).equals(verboIngles)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else if (respuesta.equals("4") && alternativas.get(3).equals(verboIngles)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            preguntasCorrectas++;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La traducción correcta es: '" + verboIngles + "'\n\n");
        }

        totalPreguntas++;
    }
    return new CalificacionUsuario(totalPreguntas, preguntasCorrectas);

    // Aquí puedes agregar la calificación al usuario si lo deseas
}


    public static Usuario encontrarUsuario(List<Usuario> usuarios, String correo, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

   public static void verCalificaciones(Usuario usuario) {
    List<CalificacionUsuario> calificaciones = usuario.getCalificaciones();
    String mensaje="Calificaciones de " + usuario.getNombre() + ":\n";
    int i=0;
    for (CalificacionUsuario calificacion : calificaciones) {
        i++;
        mensaje+="\nLas calificaiones del examen "+i+" son:\n";
        mensaje+="Total de preguntas: "+calificacion.getPreguntasRealizadas()+"\n";
    mensaje+="Preguntas correctas: "+calificacion.getPreguntasCorrectas()+"\n";
    double porcentajeAcierto = (calificacion.getPreguntasRealizadas() > 0) ? (double) calificacion.getPreguntasCorrectas() / calificacion.getPreguntasRealizadas()* 100.0 : 0.0;
    mensaje+="Porcentaje de acierto: "+porcentajeAcierto+"%\n";
    }

    JOptionPane.showMessageDialog(null, mensaje.toString());
}



}



