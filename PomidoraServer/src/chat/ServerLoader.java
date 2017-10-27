package chat;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pac.OPacket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Project name: PomidoraServer
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v2.0
 */
public class ServerLoader {

    private static final int PORT = 4444;

    private static ServerSocket server;
    private static ServerHandler handler;
    public static Map<Socket, ClientHandler> handlers = new HashMap<>();
    public static Map<Socket, ClientHandler> users = new HashMap<>();




    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        start(PORT);
        handler();
        end();
    }




    /**
     * method start exe of server
     * @param port
     */
    private static void start(int port){
        System.out.println("Start server");
        try {
            server = new ServerSocket(port);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }




    /**
     *
     */
    private static void handler(){
        handler = new ServerHandler(server);
        handler.start();
        readChat();
    }




    /**
     * method to work with chat
     */
    private static void readChat(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNextLine()){           //если есть что чтать

                String line = scanner.nextLine(); //читаем чат

                if (line.equals("/end")){
                    end();
                }else {
                    System.out.println("no such command");
                }
            }else {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}
            }
        }
    }




    /**
     *
     * @param reciver
     * @param packet
     */
    public static void sendPackets(Socket reciver, OPacket packet){
        try {
            DataOutputStream dos = new DataOutputStream(reciver.getOutputStream());
            dos.writeShort(packet.getID());
            packet.write(dos); //передаем инфу
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }





    /**
     * method to stop execution of program
     */
    public static void end(){

        System.out.println("End server");
        try {
            server.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.exit(0); //выхожу из системы
    }

    public static ServerHandler getServerHandler(){
        return handler;
    }

    public static ClientHandler getHandler(Socket socket){
        return handlers.get(socket); //получаем клиента сокета
    }

    public static void invalidate(Socket socket){
        handlers.remove(socket);
        System.out.println(users.remove(socket).getNikName() + " disconnect");
    }
}
