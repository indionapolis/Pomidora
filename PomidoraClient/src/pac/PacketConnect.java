package pac;

import chat.ClientWindow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Project name: PomidoraClient
 * Created by pavel on 02.12.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v0.0
 */
public class PacketConnect extends OPacket{
    private String name;


    public PacketConnect() throws UnknownHostException {
        this.name = InetAddress.getLocalHost().getHostAddress();
    }

    @Override
    public short getID() {
        return 0;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(name);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
    }

    @Override
    public void handle() {
    }

    @Override
    public void handle(ClientWindow window) {

    }
}
