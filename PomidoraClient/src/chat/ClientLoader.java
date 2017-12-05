package chat;

import pac.*;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.Buffer;
import java.rmi.ServerException;
import java.util.Scanner;

//путь Desktop/programs/PomidoraClient/out/production/PomidoraClient
//команда java -classpath ./ chat.ClientLoader
/**
 * Project name: PomidoraClient
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v2.0
 */
//TODO проверка жив ли объект
public class ClientLoader {

    private static final int PORT = 5555; //эта нет
    private static String address; //эта хуйня может меняться
    private static InetAddress IP;
    private static Socket server; //connection server

    private static ClientHandler handler;

    private static boolean isNamed = false;
    private static String name = "none";

    private static ClientWindow WINDOW = new ClientWindow();

    /**
     * Set up of user
     */
    public static void main(String[] args) {
    }




    //TODO обработать ошибку если подключаюсь к несуществующему серверу
    /**
     * Method to connect with server
     */
    protected static void connect(){
        try {
            address = WINDOW.getText();
            if (!address.matches("^[0-9]{1,3}+\\.+[0-9]{1,3}+\\.+[0-9]{1,3}+\\.+[0-9]{1,3}$")){
                //ip address masc
                WINDOW.textField.setText("");
                return;
            }
            try {  //пробуем подключиться к серверу по IP


                IP = InetAddress.getByName(address);

                server = new Socket(IP, PORT);


                sendPacket(new PacketConnect());
                System.out.println("You successfully connect to the server");

                WINDOW.textField.setText("");
                WINDOW.authorize();

                handler = new ClientHandler(server, WINDOW);
                handler.start();

                //TODO next step
            }catch (UnknownHostException | NoRouteToHostException | ConnectException e){
                System.out.println("Not valid IP address: " + e.getLocalizedMessage());
                WINDOW.textField.setText("");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }






    protected static void authorize(){
        if (!isNamed) {
            name = WINDOW.getText();
            if (name.equals("")) return;
            isNamed = true;
            sendPacket(new PacketAuthorize(name));  //отправляем пакет с сообщением авторизации
            WINDOW.chat();
        }
    }


    /**
     * method to work with chat
     */
    protected static void readChat(){

        String line = WINDOW.getText();

        if (line.equals("/end")) {
            //end();
        }else if (line.equals("")) return;

        sendPacket(new PacketMessage(line));  //отправляем пакет с сообщением

    }




    /**
     * method send packet on server
     * @param packet packet
     */
    public static void sendPacket(OPacket packet){
        try {
            DataOutputStream dos = new DataOutputStream(server.getOutputStream());  //создаем новый поток через сокет
            dos.writeShort(packet.getID());     //записывваем вид пакета для стороны получателя
            packet.write(dos);      //передаем инфу в формате пакета
            dos.flush();            //отправляем инфу
        }catch (IOException e){
            e.printStackTrace();
        }
    }




    //TODO нормальное закрытие окна
    /**
     * method to stop execution of program
     */
    public static void end(){
        if (server == null){
            return;
        }else {
            sendPacket(new PacketEnd(name));
            //TODO отправлять пакет отключения от сервера
            System.out.println("End user");
            try {
                server.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
