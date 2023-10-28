package Prueba3;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Prueba2 {

    public static void main(String[] args) throws IOException {
        // Crear un servidor TCP
        ServerSocket ss = new ServerSocket(8080);

        // Aceptar una conexión del cliente
        Socket s = ss.accept();

        // Crear un flujo de entrada para leer los datos del cliente
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        // Crear un flujo de salida para enviar datos al cliente
        PrintWriter pw = new PrintWriter(s.getOutputStream());

        // Leer el número del cliente
        String numero = dis.readUTF();

        // Mostrar el número por pantalla
        System.out.println("El número del cliente es: " + numero);

        // Enviar un mensaje al cliente Python para indicarle que el servidor Java ha terminado de leer los datos
        pw.println("fin");
        pw.flush();

        // Cerrar la conexión
        s.close();
    }
}
