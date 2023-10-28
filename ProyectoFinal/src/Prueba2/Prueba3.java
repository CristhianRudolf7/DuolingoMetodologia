package Prueba2;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Prueba3 {
    public static void main(String[] args) {
        // Listas de verbos en inglés y sus traducciones en español
        List<String> verbosIngles = new ArrayList<>();
        Collections.addAll(verbosIngles, "arrived", "become", "buy", "bring", "bite", "break", "cook", "come", "clean", "cry", "drive", "dive", "do");

        List<String> traduccionesEspanol = new ArrayList<>();
        Collections.addAll(traduccionesEspanol, "llegar", "llegar a ser", "comprar", "traer", "morder", "romper", "cocinar", "venir", "limpiar", "llorar", "manejar", "buzear", "hacer");


        String[][] usuarios=new String[10][3];
        boolean continuar=true;
        while(continuar){
            String opcion=JOptionPane.showInputDialog("Seleccione una opción:\n1. Ingresar con una cuenta\n2. Crear una cuenta\n0. Salir");
            if(opcion.equals("1")){
                String correo=JOptionPane.showInputDialog("Ingrese su correo:");
                String contraseña=JOptionPane.showInputDialog("Ingrese su contraseña");
                boolean esusuario=false;
                int dindice = -1;
                for(int i=0;i<usuarios.length;i++){
                    if(usuarios[i][0]!=null&&usuarios[i][0].equals(correo)&&usuarios[i][1].equals(contraseña)){
                        esusuario=true;
                        dindice=i;
                        break;}}
                if(esusuario){
                    String menuD="Bienvenido:\n";
                    menuD+="Nombre: "+usuarios[dindice][2]+"\n";
                    menuD+="Correo: "+usuarios[dindice][0]+"\n";

while (true) {
            opcion = JOptionPane.showInputDialog(menuD+"¿Qué deseas realizar?\n1. Traducir del inglés al español\n2. Traducir del español al inglés\n0. Salir");
            if (opcion.equals("1")) {
                traducirInglesEspanol(verbosIngles, traduccionesEspanol);
            } else if (opcion.equals("2")) {
                traducirEspanolIngles(verbosIngles, traduccionesEspanol);
            } else if (opcion.equals("0")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige 1, 2 o 0.");
            }
        }
                }else{
                        JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos. Intente nuevamente.");  }
            }else if(opcion.equals("2")){
                String nombre=JOptionPane.showInputDialog("Ingrese su nombre:");
                String apellido=JOptionPane.showInputDialog("Ingrese su apellido:");

                String contraseñaNueva=JOptionPane.showInputDialog("Registre una contraseña:");
                String correoElectronico=nombre + apellido + "@gmail.com";
                    for(int i=0;i<usuarios.length;i++){
                        if (usuarios[i][0]==null){
                            usuarios[i][0]=correoElectronico;
                            usuarios[i][1]=contraseñaNueva;
                            usuarios[i][2]=nombre + " " + apellido;
                            break; } }

                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente. Su correo electrónico es: " + correoElectronico); } 
            else if(opcion.equals("0")){
                continuar = false;
            }else{
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");} } 



        
    }

    public static void traducirInglesEspanol(List<String> verbosIngles, List<String> traduccionesEspanol) {
        Random random = new Random();

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
                break;
            } else if (respuesta.equals("1") && alternativas.get(0).equals(traduccionCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("2") && alternativas.get(1).equals(traduccionCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("3") && alternativas.get(2).equals(traduccionCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("4") && alternativas.get(3).equals(traduccionCorrecta)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. La traducción correcta es: '" + traduccionCorrecta + "'\n\n");
            }
        }
    }

    public static void traducirEspanolIngles(List<String> verbosIngles, List<String> traduccionesEspanol) {
        Random random = new Random();

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
                break;
            } else if (respuesta.equals("1") && alternativas.get(0).equals(verboIngles)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("2") && alternativas.get(1).equals(verboIngles)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("3") && alternativas.get(2).equals(verboIngles)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else if (respuesta.equals("4") && alternativas.get(3).equals(verboIngles)) {
                JOptionPane.showMessageDialog(null, "¡Correcto!\n\n");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto. La traducción correcta es: '" + verboIngles + "'\n\n");
            }
        }
    }
}
        