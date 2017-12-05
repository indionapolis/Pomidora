package pac;

import chat.ClientWindow;
import chat.ClientLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Project name: PomidoraClient
 * Created by pavel on 26.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketMessage extends OPacket {

    private String name;

    private String message;

    public PacketMessage(){

    }

    public PacketMessage( String message){
        this.message = message;
    }

    @Override
    public short getID() {
        return 2;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException { //отправляем текст на сервер
        dos.writeUTF(message);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {  //получаем сообщения с сервера
        name = dis.readUTF();
        message = dis.readUTF();
    }

    @Override
    public void handle(ClientWindow window) {
        window.printMessage("[" + name + "] " + message);
        //TODO make it normal
    }

    @Override
    public void handle() {

    }
}
