package Prueba1;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Set;

public class Prueba4 {
    static int[] prueba=new int[3];
    static int[] ns=new int[3];
    static int numeroAleatorio, i, j, n, e, nu;
    static boolean repetido;
    static String t,t1,t2,t3,txt;
    public static void main(String[] args) {
        ArrayList<String> ingles=new ArrayList<>(6);
        ingles.add("like");ingles.add("go");ingles.add("mean");ingles.add("sell");ingles.add("read");ingles.add("live");
        ingles.add("miss");
        ingles.add("kiss");
        ingles.add("eat");
        ingles.add("ask");
        ingles.add("spell");
        ingles.add("run");
        ArrayList<String> esp = new ArrayList<>(6);
        esp.add("gustar");
        esp.add("ir");
        esp.add("significar");
        esp.add("vender");
        esp.add("leer");
        esp.add("vivir");
        esp.add("extrañar");
        esp.add("besar");
        esp.add("comer");
        esp.add("preguntar");
        esp.add("deletrear");
        esp.add("correr");
        int opcion;
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que deseas realizar?"+
                    "\n1. Traducir del ingles al español\n2. Traducir del español al ingles\n0. Salir"));
            switch(opcion){
                case 1:
                    MAIN(ingles, esp);
                    break;
                case 2:
                    MAIN(esp,ingles);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número mal ingresado");
                    break;}
        }while(opcion!=0);}
    static void MAIN(ArrayList<String> A1,ArrayList<String> A2){
        Set<Integer> uniqueIndexes = new HashSet<>();
        while (uniqueIndexes.size() < 3) {
            numeroAleatorio = (int) (Math.floor(Math.random() * 3));
            uniqueIndexes.add(numeroAleatorio);}
        Iterator<Integer>iterator=uniqueIndexes.iterator();
        for(i=0;i<3;i++){
            ns[i] = iterator.next();}
        for (i=0;i<3;i++){
            do{
                repetido = false;
                numeroAleatorio = (int) (Math.floor(Math.random() * 5) + 1);
                for (j=0;j<i;j++){
                    if (prueba[j] == numeroAleatorio){
                        repetido = true;
                        break;}}
            }while(repetido);

            prueba[i] = numeroAleatorio;}
        n=(int) (Math.floor(Math.random() * (5 - 1 + 1)) + 1);
        t=A1.get(n);
        t1=A2.get(n);
        t2=A2.get(prueba[1]);
        t3=A2.get(prueba[2]);
        String[] letras={t1, t2, t3};

        e = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué significa " + t + " en inglés?" +
                "\n1. " + letras[ns[0]] + "\n2. " + letras[ns[1]] + "\n3. " + letras[ns[2]]));
        txt = A2.get(n);
        switch(e){
            case 1:
                nu = A2.indexOf(letras[ns[0]]);
                comparar(nu, n, A2);
                break;
            case 2:
                nu = A2.indexOf(letras[ns[1]]);
                comparar(nu, n, A2);
                break;
            case 3:
                nu = A2.indexOf(letras[ns[2]]);
                comparar(nu, n, A2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Número mal ingresado");
                break;}}
    static void comparar(int nu, int n, ArrayList<String> A2) {
        if (nu == n) {
            JOptionPane.showMessageDialog(null, "Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto, la traducción correcta es: "+A2.get(n));
        }
    }
}

