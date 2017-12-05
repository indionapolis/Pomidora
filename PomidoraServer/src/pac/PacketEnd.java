package pac;

import chat.ServerLoader;
import pac.OPacket;

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
public class PacketEnd extends OPacket {

    private String name;

    public PacketEnd(){

    }

    public PacketEnd(String name){
        this.name = name;
    }

    @Override
    public short getID() {
        return 3;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(name);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        name = dis.readUTF();
    }

    @Override
    public void handle() {

        if (ServerLoader.invalidate(getSocket())) return; //удаляем отправителя пакета и если он не авторизован то не сообщаем об удалении
        ServerLoader.users.keySet().forEach(s -> ServerLoader.sendPackets(s, new PacketEnd(name))); //отправляем сообщение о его отключении всем

    }
}
