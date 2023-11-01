package VersionFinalAPoo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
    //atributos
    ArrayList<pregunta>listaDePreguntas=new ArrayList<>();
    ArrayList<Usuario>listaDeUsuarios=new ArrayList<>();
    //metodos
    //inicio de seción
    public void iniciaSesion(){
        String tokenaux=JOptionPane.showInputDialog("Ingrese su token de acceso:");
    }
    //crea nuevo usuario
    public void registrate(){
        listaDeUsuarios.add(new Usuario());
        if(listaDeUsuarios.get(listaDeUsuarios.size()-1).borrar()){//elimina el objeto creado si le da a cancelar en algun momento
            listaDeUsuarios.remove(listaDeUsuarios.size()-1);
        }
    }
    //metodos para usuarios
        //traduce ingles a español ; traduce de español a ingles;
        //inicia cuestionario random.
        //ver calificaciones.
        //descargar pdf.
        
    //metodos para admin
        //registra una pregunta.
        //mira las calificaciones de cada estudiante.
    
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

}
