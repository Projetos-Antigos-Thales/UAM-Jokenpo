package jokenpo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main(String[] args) {

        try {

            // Inicializa objetos que serão utilizados para iniciar o servidor
            Registry registro = null;
            Partida obj = new Partida();

            // Inicia o Servidor
            Remote remote = UnicastRemoteObject.exportObject(obj, 0);
            registro = LocateRegistry.createRegistry(1099);
            registro.rebind("jokenpo", remote);

            // Informa que o Servidor foi iniciado
            System.err.println("--- Jokenpô Iniciado");

        } catch (Exception e) {
            System.err.println("--- Erro na Inicialização do Jokenpô: " + e.getMessage());
        }

    }
}
