package clientecalculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorCalculadora {

    public static void main(String[] args) {

        try {
            System.out.println("Creando socket servidor calculadora");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("192.168.0.1", 5555);
            serverSocket.bind(addr);

            System.out.println("****** Aceptando conexiones ******");

            Socket newSocket = serverSocket.accept();

            System.out.println("****** Conexion recibida ******");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            //Almancenamos el mensaje (bytes) en un string
            byte[] mensaje = new byte[25];
            is.read(mensaje);
            //PARSEAMOS EL STRING DE BYTES A STRING
            System.out.println("Mensaje recibido: " + new String(mensaje));
            
            //

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }

}
