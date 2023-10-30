package VersionFinalAPoo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario {
    //atributos
    private String token;
    private ArrayList<>
    //constructor
    public Usuario(){
        this.token=entradaStg();
    }
    private String entradaStg(String mensaje, String titulo){
        String aux="";
        aux=JOptionPane.showInputDialog(null,"ingrese"+mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
        
    }
}
