package chat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;


/**
 * Project name: PomidoraClient
 * Created by pavel on 02.12.2017.
 * Pavel Nikulin BS1-8
 * Copyright ©
 * v1.0
 */
public class ClientWindow extends JFrame implements ActionListener {

    private JPanel front = new JPanel(null){
        public void paintComponent(Graphics g){
            Image image = null;
            try {
                image = ImageIO.read(new File(new File("").getAbsolutePath() + "/src/pomidora.png"));
            } catch (IOException e) {}
            g.drawImage(image, -200, -20, null);
        }
    };
    private JPanel start = new JPanel();
    private JPanel chatField = new JPanel(new BorderLayout());
    private JPanel messageField = new JPanel(new BorderLayout());



    private JButton buttonStart = new JButton("Start");
    private JButton buttonConnect = new JButton("Connect");
    private JButton buttonAuthorize = new JButton("Go chat!");
    private JButton buttonSend = new JButton("send");



    protected JTextField textField = new JTextField(10);
    protected JTextArea txtArea = new JTextArea();



    public ClientWindow() {
        super("Pomidora");

        buttonStart.addActionListener( this );
        start.add(buttonStart);
        start.setOpaque(false);
        start.setBounds(front.getWidth()+100/2, 40, 200, 200);

        front.add(start);

        add(front);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300 , 300);
        setLocation(500, 300);
        setResizable(false);
        setVisible(true);

        reload(start);
    }


    protected void connect(){
        clean(start);

        JLabel topLabel = new JLabel("Enter server IP address:");

        buttonConnect.addActionListener( this );

        start.add(topLabel);
        start.add(textField);
        start.add(buttonConnect);

        reload(start);
    }

    protected void authorize(){
        clean(start);

        JLabel nameLabel = new JLabel("Enter your nickname:");

        buttonAuthorize.addActionListener( this );

        start.add(nameLabel);
        start.add(textField);
        start.add(buttonAuthorize);

        reload(start);
    }


    protected void chat(){
        clean(front);

        txtArea.setEnabled(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBackground(new Color(236, 236, 236));

        JScrollPane pane = new JScrollPane( txtArea ) ;
        pane.setAutoscrolls(true);

        chatField.setBounds(10, 10, 280, 200);
        chatField.setOpaque(false);
        chatField.add(pane, BorderLayout.CENTER);

        messageField.setBounds(10, 215, 280, 30);
        messageField.setOpaque(false);

        textField.setText("");
        textField.setBackground(new Color(236, 236, 236));
        buttonSend.addActionListener(this);

        messageField.add(textField, BorderLayout.CENTER);
        messageField.add(buttonSend, BorderLayout.EAST);


        front.add(chatField);
        front.add(messageField);




        reload(front);
    }

    //TODO make it normal
    public void printMessage(String mess){
        txtArea.append(mess + "\n");
    }






    public String getText() {
        return textField.getText();
    }

    protected void clean(JComponent o){
        o.removeAll();
    }

    protected void reload(JComponent o){
        o.repaint();
        revalidate();
    }












    @Override
    protected void processWindowEvent(final WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            ClientLoader.end();
        }
        super.processWindowEvent(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() ==  buttonStart) {
            connect();
        }
        if ( e.getSource() ==  buttonConnect) {
            ClientLoader.connect();
        }
        if ( e.getSource() ==  buttonAuthorize) {
            ClientLoader.authorize();
        }
        if ( e.getSource() ==  buttonSend) {
            ClientLoader.readChat();
            textField.setText("");
        }

    }
}
