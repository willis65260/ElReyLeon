// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Ejecutar implements ActionListener
{
    JButton btnNewButton;
    JButton btnJugadores;
    JButton btnSalir;
    JButton btnAyuda;
    JButton btnInstrucciones;
    private JFrame frame;
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.btnNewButton) {
            new ElReyLeon(1, this.frame);
        }
        else if (e.getSource() == this.btnJugadores) {
            new ElReyLeon(2, this.frame);
        }
        else if (e.getSource() == this.btnSalir) {
            System.exit(0);
        }
        else if (e.getSource() == this.btnAyuda) {
            new Ayuda(this.frame);
        }
        else if (e.getSource() == this.btnInstrucciones) {
            new Instrucciones(this.frame);
        }
        else {
            System.out.println("Algo salio mal we");
        }
        this.frame.setVisible(false);
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Ejecutar();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Ejecutar() {
        this.initialize();
    }
    
    private void initialize() {
        (this.frame = new JFrame()).setBounds(100, 100, 509, 329);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout(null);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        (this.btnNewButton = new JButton("1 JUGADOR")).setFont(new Font("Tahoma", 1, 12));
        this.btnNewButton.setForeground(new Color(255, 255, 255));
        this.btnNewButton.setBackground(new Color(102, 102, 204));
        this.btnNewButton.setBounds(60, 145, 126, 23);
        this.btnNewButton.addActionListener(this);
        this.frame.getContentPane().add(this.btnNewButton);
        (this.btnJugadores = new JButton("2 JUGADORES")).setFont(new Font("Tahoma", 1, 12));
        this.btnJugadores.setForeground(new Color(255, 255, 255));
        this.btnJugadores.setBackground(new Color(51, 153, 102));
        this.btnJugadores.setBounds(60, 179, 126, 23);
        this.btnJugadores.addActionListener(this);
        this.frame.getContentPane().add(this.btnJugadores);
        (this.btnSalir = new JButton("SALIR")).setFont(new Font("Tahoma", 1, 12));
        this.btnSalir.setForeground(Color.WHITE);
        this.btnSalir.setBackground(new Color(204, 51, 51));
        this.btnSalir.setBounds(386, 237, 83, 23);
        this.btnSalir.addActionListener(this);
        this.frame.getContentPane().add(this.btnSalir);
        (this.btnAyuda = new JButton("AYUDA")).setForeground(new Color(0, 0, 0));
        this.btnAyuda.setFont(new Font("Tahoma", 1, 12));
        this.btnAyuda.setBackground(new Color(255, 255, 153));
        this.btnAyuda.setBounds(370, 27, 92, 23);
        this.btnAyuda.addActionListener(this);
        this.frame.getContentPane().add(this.btnAyuda);
        (this.btnInstrucciones = new JButton("INSTRUCCIONES")).setForeground(new Color(0, 0, 0));
        this.btnInstrucciones.setFont(new Font("Tahoma", 1, 12));
        this.btnInstrucciones.setBackground(new Color(255, 204, 153));
        this.btnInstrucciones.setBounds(343, 54, 140, 23);
        this.btnInstrucciones.addActionListener(this);
        this.frame.getContentPane().add(this.btnInstrucciones);
        final JLabel lblNewLabel = new JLabel("¿DESEA JUGAR?");
        lblNewLabel.setFont(new Font("Tahoma", 1, 18));
        lblNewLabel.setBounds(47, 120, 157, 14);
        this.frame.getContentPane().add(lblNewLabel);
        final JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("Recursos/menu.png")));
        lblNewLabel_1.setBounds(0, 0, 493, 290);
        this.frame.getContentPane().add(lblNewLabel_1);
    }
}
