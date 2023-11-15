package proyectofinal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//reto con otro usuario, volver a ingresar contraseña al momento de registrar
public class Prueba4 {
    static ArrayList<String> verbosIngles = new ArrayList<>();
    static ArrayList<String> verbosEspanol = new ArrayList<>();
    static ArrayList<String> verbosInglesI = new ArrayList<>();
    static ArrayList<String> verbosEspanolI = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static MySQL con=new MySQL();
    static Connection cn=con.conectar();
    public static void main(String[] args){
        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n1. Ingresar con una cuenta\n2. Crear una cuenta\n0. Salir");
            if (opcion.equals("1")) {
                String token = JOptionPane.showInputDialog("Ingrese su token:");
                String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña");
                Usuario usuario = encontrarUsuario(usuarios, token, contraseña);
                obtenerVerbosIncorrectos(usuario);
                if (usuario != null) {
                    String menuD = "Bienvenido:\n";
                    menuD += "Nombre: " + usuario.getNombre() + "\n";
                    menuD += "Token: " + usuario.getToken() + "\n";

                    while (true) {
                        opcion = JOptionPane.showInputDialog(menuD + "¿Qué deseas realizar?\n1. Traducir del inglés al español\n2. Traducir del español al inglés\n3. Jugar minijuegos\n4. Ver calificaciones\n5. Descargar PDF de notas \n6. Comparar resultados\n7. Agregar palabras\n0. Salir");
                        if(opcion.equals("1")){
                            String eleccion = JOptionPane.showInputDialog("¿Deseas practicar tus preguntas erradas?");
                            if (eleccion.equals("1")){
                                CalificacionUsuario calificacion = traducir(verbosInglesI, verbosEspanolI, usuario);
                                usuario.agregarCalificacion(calificacion);
                                actualizarCalificaciones(calificacion.getPreguntasRealizadas(),calificacion.getPreguntasCorrectas(),calificacion.getPorcentajeAcierto(), usuario);
                            }
                            else if (eleccion.equals("0")){
                                CalificacionUsuario calificacion = traducir(verbosIngles, verbosEspanol,usuario);
                                usuario.agregarCalificacion(calificacion);
                                actualizarCalificaciones(calificacion.getPreguntasRealizadas(),calificacion.getPreguntasCorrectas(),calificacion.getPorcentajeAcierto(), usuario);}
                        }                    
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos. Intente nuevamente.");
                }
            }  
        }
    }
    public static boolean existeUsuario(String nombre) {
        // Consulta SQL para verificar la existencia del usuario en la tabla 'usuarios'
        String consulta = "SELECT COUNT(*) FROM usuarios WHERE nombre = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = cn.prepareStatement(consulta);
            statement.setString(1, nombre);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Obtener el resultado
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Devolver true si existe al menos un usuario con el nombre dado
            }

        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de excepciones, puedes personalizar según tus necesidades
        }

        return false; // Devolver false en caso de error o si no se encuentra el usuario
    }


    
    public static CalificacionUsuario traducir(ArrayList<String> lista1, ArrayList<String> lista2, Usuario usuario) {
        Random random = new Random();
        int totalPreguntas = 0;
        int preguntasCorrectas = 0;
        if (lista1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía. No hay preguntas disponibles.");
            return new CalificacionUsuario(totalPreguntas, preguntasCorrectas);
        }
        while (true) {
            int indice = random.nextInt(lista1.size());
            String verboIngles = lista1.get(indice);
            String traduccionCorrecta = lista2.get(indice);

            ArrayList<String> alternativas = new ArrayList<>();
            alternativas.add(traduccionCorrecta);

            while (alternativas.size() < 4) {
                String alternativa = lista2.get(random.nextInt(lista2.size()));
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
                return new CalificacionUsuario(totalPreguntas, preguntasCorrectas);
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
                guardarError(usuario,traduccionCorrecta);
            }
            totalPreguntas++;
        }
    }



    public static Usuario encontrarUsuario(ArrayList<Usuario> usuarios, String  token, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getToken().equals(token) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public static void verCalificaciones(Usuario usuario) {
        ArrayList<CalificacionUsuario> calificaciones = usuario.getCalificaciones();
        String mensaje="Calificaciones de " + usuario.getNombre() + ":\n";
        int i=0;
        for (CalificacionUsuario calificacion : calificaciones) {
            i++;
            mensaje+="\nLas calificaiones del examen "+i+" son:\n";
            mensaje+="Total de preguntas: "+calificacion.getPreguntasRealizadas()+"\n";
        mensaje+="Preguntas correctas: "+calificacion.getPreguntasCorrectas()+"\n";
        double porcentajeAcierto = (double) calificacion.getPreguntasCorrectas() / calificacion.getPreguntasRealizadas()* 100.0;
        mensaje+="Porcentaje de acierto: "+porcentajeAcierto+"%\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);}
   
    public static void guardarError(Usuario usuario, String palabra) {
        int indice;
        if (verbosEspanol.contains(palabra)) {
            indice = verbosEspanol.indexOf(palabra);
            String ingles = verbosIngles.get(indice);
            if (!verificarExistenciaError(usuario.getToken(), ingles, palabra)) {
                verbosEspanolI.add(palabra);
                verbosInglesI.add(ingles);
                try {
                    String consulta = "INSERT INTO " + usuario.getToken() + "incorrecto (ingles, espanol) VALUES (?, ?)";
                    PreparedStatement ps = cn.prepareStatement(consulta);
                    ps.setString(1, ingles);
                    ps.setString(2, palabra);
                    ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error al insertar en la base de datos: " + e.getMessage());
                }
            }
        } else if (verbosIngles.contains(palabra)) {
            indice = verbosIngles.indexOf(palabra);
            String espanol = verbosEspanol.get(indice);
            if (!verificarExistenciaError(usuario.getToken(), palabra, espanol)) {
                verbosInglesI.add(palabra);
                verbosEspanolI.add(espanol);
                try {
                    String consulta = "INSERT INTO " + usuario.getToken() + "incorrecto (ingles, espanol) VALUES (?, ?)";
                    PreparedStatement ps = cn.prepareStatement(consulta);
                    ps.setString(1, palabra);
                    ps.setString(2, espanol);
                    ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error al insertar en la base de datos: " + e.getMessage());
                }
            }
        }
    }

    public static boolean verificarExistenciaError(String token, String ingles, String espanol) {
        try {
            String consulta = "SELECT COUNT(*) as total FROM " + token + "incorrecto WHERE ingles = ? AND espanol = ?";
            PreparedStatement ps = cn.prepareStatement(consulta);
            ps.setString(1, ingles);
            ps.setString(2, espanol);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                return total > 0;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar existencia: " + e.getMessage());
        }
        return false; // Retorno por defecto en caso de error
    }


    public static void compararResultados(ArrayList<Usuario> usuarios) {
    }
    

    
    
    
    public static void agregarPalabras() {
        try {
            String palabraEspanol = JOptionPane.showInputDialog("Ingrese una palabra en español:");

            // Verificar si la palabra en español ya existe en la lista
            if (verbosEspanol.contains(palabraEspanol)) {
                JOptionPane.showMessageDialog(null, "Error: La palabra en español ya existe en la lista.");
                return;
            }

            String palabraIngles = JOptionPane.showInputDialog("Ingrese la traducción en inglés:");

            // Verificar si la palabra en inglés ya existe en la lista
            if (verbosIngles.contains(palabraIngles)) {
                JOptionPane.showMessageDialog(null, "Error: La palabra en inglés ya existe en la lista.");
                return;
            }

            // Agregar las palabras a las listas
            verbosEspanol.add(palabraEspanol);
            verbosIngles.add(palabraIngles);

            // Actualizar la tabla 'verbos' en la base de datos
            actualizarTablaVerbos(palabraEspanol, palabraIngles);

            JOptionPane.showMessageDialog(null, "Palabras agregadas correctamente.");

        } catch (Exception ex) {
            System.out.println("Error al agregar palabras: " + ex.getMessage());
        }
    }

    public static void actualizarTablaVerbos(String palabraEspanol, String palabraIngles) {
        try {
            // Verificar si la palabra en español ya existe en la tabla 'verbos'
            String consultaExistencia = "SELECT COUNT(*) as total FROM verbos WHERE Espanol = ?";
            PreparedStatement psExistencia = cn.prepareStatement(consultaExistencia);
            psExistencia.setString(1, palabraEspanol);
            ResultSet rsExistencia = psExistencia.executeQuery();

            if (rsExistencia.next()) {
                int totalExistencia = rsExistencia.getInt("total");

                // Si la palabra no existe, agregarla a la tabla 'verbos'
                if (totalExistencia == 0) {
                    String consultaInsercion = "INSERT INTO verbos (Espanol, Ingles) VALUES (?, ?)";
                    PreparedStatement psInsercion = cn.prepareStatement(consultaInsercion);
                    psInsercion.setString(1, palabraEspanol);
                    psInsercion.setString(2, palabraIngles);
                    psInsercion.executeUpdate();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La palabra en español ya existe en la tabla 'verbos'.");
                }
            }

            // Cerrar los recursos
            rsExistencia.close();
            psExistencia.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar la tabla 'verbos': " + e.getMessage());
        }
    }

    
    public static String creaToken(String nombre, String apellido){
        String token="";
            int nombrelong=nombre.length();
            int apellidolong=apellido.length();
            int index=0;
            for (int i = 0; i < 2; i++) {
                index=(int)Math.floor(Math.random()*(nombrelong));
                String charaux=""+nombre.charAt(index);
                charaux=charaux.toLowerCase();
                if((int)Math.round(Math.random())==1){ //en minuscula
                    token=token+charaux;
                }else{//en mayuscula
                    charaux=charaux.toUpperCase();
                    token=token+charaux;
                }
                
            }
            for (int i = 0; i < 2; i++) {
                index=(int)Math.floor(Math.random()*(apellidolong));
                String charaux=""+apellido.charAt(index);
                charaux=charaux.toLowerCase();
                if((int)Math.round(Math.random())==1){ //en minuscula
                    token=token+charaux;
                }else{//en mayuscula
                    charaux=charaux.toUpperCase();
                    token=token+charaux;
                }
            }
            System.out.println("token: "+token);
        do{
            JOptionPane.showMessageDialog(null, "Su token de acceso es:\n"+token+"\n(incluye mayusculas y minusculas)");
            String confirmador=JOptionPane.showInputDialog("para continuar, confirme su token:");
            if(confirmador.equals(token)){
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\nya puede iniciar sesión");
                return token;
            }else{
                JOptionPane.showMessageDialog(null, "EL token ingresado no es el correcto, intentelo otra vez");
            }
        }while(true);
    }
    
    public static void descargarPDF(Usuario usuario){
        try{
                                Document documento = new Document();
                                String titulo = usuario.getNombre()+".pdf";
                                String mensaje="Calificaciones de " + usuario.getNombre() + ":\n";
                                int i=0;
                                ArrayList<CalificacionUsuario> calificaciones = usuario.getCalificaciones();
                                for (CalificacionUsuario calificacion : calificaciones) {
                                    i++;
                                    mensaje+="\nLas calificaiones del examen "+i+" son:\n";
                                    mensaje+="Total de preguntas: "+calificacion.getPreguntasRealizadas()+"\n";
                                    mensaje+="Preguntas correctas: "+calificacion.getPreguntasCorrectas()+"\n";
                                    double porcentajeAcierto = (double) calificacion.getPreguntasCorrectas() / calificacion.getPreguntasRealizadas()* 100.0;
                                    mensaje+="Porcentaje de acierto: "+porcentajeAcierto+"%\n";
                                }
                                PdfWriter.getInstance(documento, new FileOutputStream(titulo));
                                documento.open();
                                Phrase escribir = new Phrase(mensaje);
                                documento.add(escribir);
                                documento.close();
                            }catch (Exception ex){
                                Logger.getLogger(Prueba4.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public static void actualizarCalificaciones(int preguntas, int acierto, double porcentaje, Usuario usuario) {
        try {
            int totalFilas = -1;

            // Obtener el total de filas en la tabla del usuario
            String consultaTotalFilas = "SELECT COUNT(*) as total_filas FROM " + usuario.getToken();
            PreparedStatement statementTotalFilas = cn.prepareStatement(consultaTotalFilas);
            ResultSet resultSetTotalFilas = statementTotalFilas.executeQuery();

            if (resultSetTotalFilas.next()) {
                totalFilas = resultSetTotalFilas.getInt("total_filas");
            }

            // Si el usuario no tiene registros, INSERT en lugar de UPDATE
                String insercionSQL = "INSERT INTO " + usuario.getToken() + " (preguntasRealizadas, preguntasCorrectas, porcentaje) VALUES (?, ?, ?)";
                PreparedStatement psInsercion = cn.prepareStatement(insercionSQL);
                psInsercion.setInt(1, preguntas);
                psInsercion.setInt(2, acierto);
                psInsercion.setDouble(3, porcentaje);
                psInsercion.executeUpdate();

            // Cerrar los recursos
            resultSetTotalFilas.close();
            statementTotalFilas.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar calificaciones: " + e.getMessage());
        }
    }

    public static void crearTable(Usuario usuario){
        try {
            Statement statement = cn.createStatement();
            statement.execute("CREATE TABLE " + usuario.getToken() + " (n INT AUTO_INCREMENT PRIMARY KEY, preguntasRealizadas INT, preguntasCorrectas INT, porcentaje DOUBLE)");
            statement.execute("CREATE TABLE " + usuario.getToken() + "incorrecto (n INT AUTO_INCREMENT PRIMARY KEY, ingles TEXT, espanol TEXT)");
        } catch (Exception e) {}
    }
    public static void guardarUsuario(Usuario usuario){
        try{
                    String consulta=
                    "INSERT INTO `usuarios`( `nombre`, `contraseña`, `token`) VALUES ('"+usuario.getNombre()+"','"+usuario.getContraseña()+"','"+usuario.getToken()+"');";
                    PreparedStatement ps=cn.prepareStatement(consulta);
                    ps.executeUpdate();
                }
                catch(Exception e){}
    }
    

    public static void ordenarPalabras() {
        try {
            // Obtener una oración aleatoria de la tabla 'oraciones'
            String consultaOracion = "SELECT oracion FROM oraciones ORDER BY RAND() LIMIT 1";
            Statement statementOracion = cn.createStatement();
            ResultSet resultSetOracion = statementOracion.executeQuery(consultaOracion);

            if (resultSetOracion.next()) {
                String oracionOriginal = resultSetOracion.getString("oracion");
                String oracionDesordenada = desordenarOracion(oracionOriginal);
                String respuestaUsuario = JOptionPane.showInputDialog("Ordena la siguiente oración:\n" + oracionDesordenada);

                // Verificar la respuesta del usuario
                if (respuestaUsuario.equalsIgnoreCase(oracionOriginal)) {
                    JOptionPane.showMessageDialog(null, "¡Correcto! La oración está ordenada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error. La oración correcta es: '" + oracionOriginal + "'");
                }
            }

            resultSetOracion.close();
            statementOracion.close();
        } catch (Exception ex) {
            System.out.println("Error al ordenar palabras: " + ex.getMessage());
        }
    }

    public static String desordenarOracion(String oracion) {
        List<String> palabras = Arrays.asList(oracion.split("\\s+"));
        Collections.shuffle(palabras);
        return String.join(" / ", palabras);
    }

    public static void completarOraciones() {
        try {
            // Obtener una oración aleatoria de la tabla 'oraciones'
            String oracionCompleta = obtenerOracionAleatoria();

            // Obtener una palabra aleatoria de la oración
            String[] palabras = oracionCompleta.split("\\s+");
            int indicePalabraFaltante = (int) (Math.random() * palabras.length);
            String palabraFaltante = palabras[indicePalabraFaltante];

            // Crear la oración con la palabra faltante reemplazada por un espacio en blanco
            String oracionIncompleta = oracionCompleta.replace(palabraFaltante, "______");

            // Solicitar al usuario que complete la palabra faltante
            String respuestaUsuario = JOptionPane.showInputDialog("Completa la siguiente oración:\n" + oracionIncompleta);

            // Verificar la respuesta del usuario
            if (respuestaUsuario.trim().equalsIgnoreCase(palabraFaltante.trim())) {
                JOptionPane.showMessageDialog(null, "¡Correcto! La palabra es: '" + palabraFaltante + "'");
            } else {
                JOptionPane.showMessageDialog(null, "Error. La respuesta correcta era: '" + palabraFaltante + "'");
            }

        } catch (Exception ex) {
            System.out.println("Error al completar oraciones: " + ex.getMessage());
        }
    }
    public static String obtenerOracionAleatoria() {
        try {
            String consultaOracion = "SELECT oracion FROM oraciones ORDER BY RAND() LIMIT 1";
            Statement statementOracion = cn.createStatement();
            ResultSet resultSetOracion = statementOracion.executeQuery(consultaOracion);

            if (resultSetOracion.next()) {
                return resultSetOracion.getString("oracion");
            }

        } catch (Exception ex) {
            System.out.println("Error al obtener oración aleatoria: " + ex.getMessage());
        }
        return ""; // Retorno por defecto en caso de error
    }

    public static void aumentarOraciones() {
        try {
            // Solicitar al usuario que ingrese una oración
            String nuevaOracion = JOptionPane.showInputDialog("Ingrese una nueva oración:");

            // Guardar la nueva oración en la tabla 'oraciones'
            guardarNuevaOracion(nuevaOracion);

            JOptionPane.showMessageDialog(null, "Oración agregada correctamente.");

        } catch (Exception ex) {
            System.out.println("Error al aumentar oraciones: " + ex.getMessage());
        }
    }

    // Método para guardar una nueva oración en la tabla 'oraciones'
    public static void guardarNuevaOracion(String oracion) {
        try {
            String consulta = "INSERT INTO oraciones (oracion) VALUES (?)";
            PreparedStatement ps = cn.prepareStatement(consulta);
            ps.setString(1, oracion);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar la nueva oración: " + e.getMessage());
        }
    }
}