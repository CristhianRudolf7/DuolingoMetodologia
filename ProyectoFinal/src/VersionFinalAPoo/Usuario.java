package VersionFinalAPoo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario {
    //atributos
    private String token;
    private ArrayList<>
    //constructor
    public Usuario(){
        this.token=creaToken();
    }
    private void creaToken(){

    }
    private String entradaStg() {
        String cadena = null;
        while (cadena == null || cadena.isEmpty()) {
            cadena = JOptionPane.showInputDialog(null, "Ingrese el nombre del candidato:", "Registro del candidato",
                    JOptionPane.INFORMATION_MESSAGE);
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
