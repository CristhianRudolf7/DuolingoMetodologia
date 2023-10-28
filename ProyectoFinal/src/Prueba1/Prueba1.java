package Prueba1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Prueba1 {
    public static void main(String[] args) {
        ArrayList<String> ingles = new ArrayList<>(6);
        ingles.add("Like");
        ingles.add("go");
        ingles.add("mean");
        ingles.add("sell");
        ingles.add("read");
        ingles.add("live");
        ArrayList<String> esp = new ArrayList<>(6);
        esp.add("gustar");
        esp.add("ir");
        esp.add("significar");
        esp.add("vender");
        esp.add("leer");
        esp.add("vivir");
        
        int n = (int) (Math.floor(Math.random() * 6)); // Generar un índice válido
        
        String t = esp.get(n);
        String t1 = ingles.get(n);
        int[] ns = new int[3];
        
        for (int i = 0; i < 3; i++) {
            int numeroAleatorio;
            boolean repetido;

            do {
                repetido = false;
                numeroAleatorio = (int) (Math.floor(Math.random() * 6)); // Generar índices válidos

                // Verificar si el número ya está en la matriz
                for (int j = 0; j < i; j++) {
                    if (ns[j] == numeroAleatorio) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);

            ns[i] = numeroAleatorio;
        }
        
        String[] letras = { t1, ingles.get(ns[0]), ingles.get(ns[1]) };
        
        int e = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué significa " + t + " en inglés?" +
                "\n1. " + letras[0] + "\n2. " + letras[1] + "\n3. " + letras[2]));
        int nu;
        String txt = ingles.get(n);
        
        switch (e) {
            case 1:
                nu = ingles.indexOf(t1);
                comparar(nu, n);
                break;
            case 2:
                nu = ingles.indexOf(t1);
                comparar(nu, n);
                break;
            case 3:
                nu = ingles.indexOf(t1);
                comparar(nu, n);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Número mal ingresado");
                break;
        }
    }
    
    static void comparar(int nu, int n) {
        if (nu == n) {
            JOptionPane.showMessageDialog(null, "Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto");
        }
    }
}
