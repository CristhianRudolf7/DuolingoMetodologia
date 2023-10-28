package Prueba1;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
public class Prueba2{
    public static void main (String[]args){
        ArrayList<String> ingles = new ArrayList<>(6);
        ingles.add("Like");
        ingles.add("go");
        ingles.add("mean");
        ingles.add("sell");
        ingles.add("read");
        ingles.add("live");
        ArrayList<String> esp = new ArrayList<>(6);
        esp.add("Like");
        esp.add("gustar");
        esp.add("ir");
        esp.add("significar");
        esp.add("vender");
        esp.add("leer");
        int[] prueba = new int[3];

        for (int i = 0; i <3; i++) {
            int numeroAleatorio;
            boolean repetido;

            do {
                repetido = false;
                numeroAleatorio = (int) (Math.floor(Math.random() * 5) + 1);

                // Verificar si el número ya está en la matriz
                for (int j = 0; j < i; j++) {
                    if (prueba[j] == numeroAleatorio) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);

            prueba[i] = numeroAleatorio;
        }
        int n=(int) (Math.floor(Math.random() * (5-1+1)) + 1);
        String t=esp.get(n);
        String t1=ingles.get(n);
        String t2=ingles.get(prueba[1]);
        String t3=ingles.get(prueba[2]);
        int[]ns=new int[3];
        for (int i = 0; i <3; i++) {
            int numeroAleatorio;
            boolean repetido;

            do {
                repetido = false;
                numeroAleatorio = (int) (Math.floor(Math.random() * 2) + 1);

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
        String[] letras={t1,t2,t3};
        
        int e = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué significa "+t+" en ingles?"+
                "\n1. "+letras[ns[0]]+"\n2. "+letras[ns[1]]+"\n3. "+letras[ns[2]]));
        int nu;
        String txt =ingles.get(n);
        switch(e){
            case 1:
                nu=ingles.indexOf(letras[ns[0]]);
                comparar(nu, n);
                break;
            case 2:
                nu=ingles.indexOf(letras[ns[1]]);
                comparar(nu, n);
                break;
            case 3:
                nu=ingles.indexOf(letras[ns[2]]);
                comparar(nu, n);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Numero mal ingresado");
                break;
        }
    }
    static void comparar(int nu, int n){
        if(nu==n){
            JOptionPane.showMessageDialog(null, "Correcto");
        }
        else{
            JOptionPane.showMessageDialog(null, "Inorrecto");
        }}
}

