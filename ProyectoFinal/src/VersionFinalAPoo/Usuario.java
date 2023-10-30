package VersionFinalAPoo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario {
    //atributos
    private String token;
    
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
