// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.net.URL;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ElReyLeon extends JPanel implements ActionListener
{
    JFrame V;
    Image imgTablero;
    vector_Etiqueta[][] vEti;
    int posfr;
    int posfc;
    ImageIcon figura;
    JPanel panelDado;
    JButton bDado;
    ImageIcon imgDado;
    int numGenerado;
    defTablero[] T;
    int ubicacionS;
    int ubicacionP;
    int numero_jugadores;
    Jugador Simba;
    Jugador Pumba;
    boolean OdioLasBanderas;
    JFrame ventana_anterior;
    JButton imagen_jugador1;
    JButton imagen_jugador2;
    
    public ElReyLeon(final int numero_jugadores, final JFrame ventana_anterior) {
        this.ventana_anterior = ventana_anterior;
        this.numero_jugadores = numero_jugadores;
        this.OdioLasBanderas = true;
        this.construirTablero();
        this.Simba = new Jugador(this.vEti, this.T, this.bDado, 0, "Simba", this.V, ventana_anterior);
        (this.imagen_jugador1 = new JButton()).setIcon(this.Simba.figura);
        this.panelDado.add(this.imagen_jugador1);
        if (numero_jugadores != 1) {
            this.Pumba = new Jugador(this.vEti, this.T, this.bDado, 2, "Pumba", this.V, ventana_anterior);
            (this.imagen_jugador2 = new JButton()).setIcon(this.Pumba.figura);
            this.imagen_jugador2.setEnabled(false);
            this.panelDado.add(this.imagen_jugador2);
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        System.out.println("botones " + this.numero_jugadores);
        if (this.numero_jugadores == 1) {
            this.Simba.AgregarMovimiento(this.TirarDado());
            this.Simba.MoverJugador();
        }
        else {
            System.out.println("entro al else ");
            if (this.OdioLasBanderas) {
                if (!this.Simba.cazzu) {
                    this.Simba.AgregarMovimiento(this.TirarDado());
                    this.Simba.MoverJugador();
                    this.imagen_jugador2.setEnabled(true);
                    this.imagen_jugador1.setEnabled(false);
                }
                else {
                    this.Simba.cazzu = false;
                }
                this.OdioLasBanderas = false;
            }
            else {
                if (!this.Pumba.cazzu) {
                    this.Pumba.AgregarMovimiento(this.TirarDado());
                    this.Pumba.MoverJugador();
                    this.imagen_jugador1.setEnabled(true);
                    this.imagen_jugador2.setEnabled(false);
                }
                else {
                    this.Pumba.cazzu = false;
                }
                this.OdioLasBanderas = true;
            }
        }
    }
    
    public int TirarDado() {
        final Random R = new Random();
        this.numGenerado = 1 + R.nextInt(6);
        final URL ruta = this.getClass().getResource("Recursos/dado" + this.numGenerado + ".png");
        this.bDado.setIcon(new ImageIcon(ruta));
        return this.numGenerado;
    }
    
    public void construirTablero() {
        this.OdioLasBanderas = true;
        (this.V = new JFrame("Serpientes y escaleras version El Rey Leon")).setSize(900, 700);
        this.V.setLocationRelativeTo(this);
        this.setSize(900, 700);
        this.setLayout(new GridLayout(5, 6));
        this.ubicacionP = 1;
        this.ubicacionS = 1;
        this.vEti = new vector_Etiqueta[5][6];
        for (int r = 0; r < this.vEti.length; ++r) {
            for (int c = 0; c < this.vEti[0].length; ++c) {
                this.vEti[r][c] = new vector_Etiqueta();
                this.add(this.vEti[r][c].PanelInterno);
            }
        }
        this.posfr = 4;
        this.posfc = 0;
        URL ruta = this.getClass().getResource("Recursos/pumba5.gif");
        ruta = this.getClass().getResource("Recursos/fondo.png");
        this.imgTablero = new ImageIcon(ruta).getImage();
        this.V.add(this, "Center");
        (this.panelDado = new JPanel()).setLayout(new GridLayout(3, 1));
        ruta = this.getClass().getResource("Recursos/dadochido.gif");
        this.imgDado = new ImageIcon(ruta);
        (this.bDado = new JButton(this.imgDado)).setOpaque(false);
        this.bDado.setContentAreaFilled(false);
        this.bDado.setBorderPainted(false);
        this.panelDado.add(this.bDado);
        this.V.add(this.panelDado, "West");
        this.bDado.addActionListener(this);
        this.V.setVisible(true);
        this.V.setDefaultCloseOperation(2);
        this.V.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent windowEvent) {
                ElReyLeon.this.ventana_anterior.setVisible(true);
            }
        });
        this.V.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(final WindowEvent e) {
            }
            
            @Override
            public void windowGainedFocus(final WindowEvent e) {
            }
        });
        (this.T = new defTablero[31])[1] = new defTablero(1, 4, 0, 0);
        this.T[2] = new defTablero(2, 4, 1, 0);
        this.T[3] = new defTablero(3, 4, 2, 18);
        this.T[4] = new defTablero(4, 4, 3, 0);
        this.T[5] = new defTablero(5, 4, 4, 0);
        this.T[6] = new defTablero(6, 4, 5, 0);
        this.T[7] = new defTablero(7, 3, 5, 0);
        this.T[8] = new defTablero(8, 3, 4, 16);
        this.T[9] = new defTablero(9, 3, 3, 0);
        this.T[10] = new defTablero(10, 3, 2, 0);
        this.T[11] = new defTablero(11, 3, 1, 1);
        this.T[12] = new defTablero(12, 3, 0, 0);
        this.T[13] = new defTablero(13, 2, 0, 24);
        this.T[14] = new defTablero(14, 2, 1, 0);
        this.T[15] = new defTablero(15, 2, 2, 4);
        this.T[16] = new defTablero(16, 2, 3, 0);
        this.T[17] = new defTablero(17, 2, 4, 0);
        this.T[18] = new defTablero(18, 2, 5, 0);
        this.T[19] = new defTablero(19, 1, 5, 7);
        this.T[20] = new defTablero(20, 1, 4, 0);
        this.T[21] = new defTablero(21, 1, 3, 0);
        this.T[22] = new defTablero(22, 1, 2, 29);
        this.T[23] = new defTablero(23, 1, 1, 0);
        this.T[24] = new defTablero(24, 1, 0, 0);
        this.T[25] = new defTablero(25, 0, 0, 6);
        this.T[26] = new defTablero(26, 0, 1, 0);
        this.T[27] = new defTablero(27, 0, 2, 0);
        this.T[28] = new defTablero(28, 0, 3, 9);
        this.T[29] = new defTablero(29, 0, 4, 0);
        this.T[30] = new defTablero(30, 0, 5, 0);
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imgTablero, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public static void main(final String[] args) {
    }
}
