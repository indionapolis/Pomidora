package pac;

import chat.ClientWindow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Project name: PomidoraClient
 * Created by pavel on 25.10.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketAuthorize extends OPacket {

    private String name;

    public PacketAuthorize(){}

    public PacketAuthorize(String name){
        this.name = name;
    }

    @Override
    public short getID() {
        return 1;
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
    public void handle(ClientWindow window) {
        window.printMessage("new user connect: " + name);
        System.out.println("new user connect: " + name);
    }

    @Override
    public void handle() {

    }
}
