// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import java.net.URL;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.ImageIcon;

class ThreadDemo implements Runnable
{
    int nueva;
    ImageIcon figura;
    vector_Etiqueta[][] vEti;
    defTablero[] T;
    JButton bDado;
    Jugador jugador;
    LinkedList<Integer> movimientos;
    JFrame V;
    JFrame ventana_anterior;
    
    public ThreadDemo(final int posicion, final LinkedList<Integer> movimientos, final ImageIcon figura, final vector_Etiqueta[][] vEti, final defTablero[] T, final JButton bDado, final Jugador jugador, final JFrame V, final JFrame ventana_anterior) {
        this.movimientos = movimientos;
        this.figura = figura;
        this.vEti = vEti;
        this.T = T;
        this.bDado = bDado;
        this.jugador = jugador;
        this.V = V;
        this.ventana_anterior = ventana_anterior;
    }
    
    @Override
    public void run() {
        try {
            this.bDado.setEnabled(false);
            System.out.println(String.valueOf(this.nueva) + " " + this.jugador.posicion);
            while (!this.movimientos.isEmpty()) {
                this.nueva = this.jugador.movimientos.removeFirst() + this.jugador.posicion;
                if (this.nueva > 30) {
                    System.out.println("mas de 30, se agregaron " + (this.nueva - 30) * -1 + " a la linked list");
                    this.jugador.AgregarMovimiento((this.nueva - 30) * -1);
                    this.nueva = 30;
                }
                if (this.nueva >= this.jugador.posicion) {
                    JOptionPane.showMessageDialog(null, String.valueOf(this.jugador.nombre) + " avanza a la posicion " + this.nueva, "", 1, new ImageIcon(this.jugador.ruta));
                    while (this.jugador.posicion < this.nueva) {
                        this.MoverAdelante(this.jugador.posicion);
                        final Jugador jugador = this.jugador;
                        ++jugador.posicion;
                        Thread.sleep(500L);
                    }
                    this.MoverAdelante(this.jugador.posicion);
                }
                else if (this.nueva < this.jugador.posicion) {
                    JOptionPane.showMessageDialog(null, String.valueOf(this.jugador.nombre) + " retrocede a la posicion " + this.nueva, "", 1, new ImageIcon(this.jugador.ruta));
                    while (this.jugador.posicion > this.nueva) {
                        this.MoverAtras(this.jugador.posicion);
                        final Jugador jugador2 = this.jugador;
                        --jugador2.posicion;
                        Thread.sleep(500L);
                    }
                    this.MoverAtras(this.jugador.posicion);
                }
                else {
                    System.out.println("no esta entrando a los if's");
                }
                if (this.T[this.nueva].getAvance() != 0) {
                    System.out.println("Avance " + this.T[this.nueva].getAvance() + " posicion " + this.jugador.posicion);
                    this.jugador.AgregarMovimiento(this.T[this.nueva].getAvance() - this.jugador.posicion);
                    System.out.println("Se avanzaran " + this.jugador.movimientos.getFirst());
                }
                Thread.sleep(500L);
                System.out.println(this.jugador.movimientos);
                System.out.println(String.valueOf(this.jugador.nombre) + " se encuentra en la posicion " + this.jugador.posicion);
            }
            if (this.jugador.posicion == 30) {
                this.bDado.setEnabled(false);
                JOptionPane.showMessageDialog(null, String.valueOf(this.jugador.nombre) + " Ha llegado a la posicion " + this.jugador.posicion + " y ha ganado FELICIDADES!!!");
                this.ventana_anterior.setVisible(true);
                this.V.dispose();
                System.out.println("Alguien ya gano, adios");
            }
            if (this.jugador.posicion == 23) {
                this.jugador.cazzu = true;
            }
            this.bDado.setEnabled(true);
            final URL dado = this.getClass().getResource("Recursos/dadochido.gif");
            this.bDado.setIcon(new ImageIcon(dado));
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getStackTrace()[0].getLineNumber());
        }
    }
    
    public void MoverAdelante(final int i) {
        if (this.T[this.jugador.posicion].r % 2 == 0) {
            this.jugador.ActualizarFigura("D");
        }
        else {
            this.jugador.ActualizarFigura("I");
        }
        if (i > 1) {
            this.jugador.SetImageJugadorBeforeNull();
        }
        this.jugador.SetImageJugador();
    }
    
    public void MoverAtras(final int i) {
        if (this.T[this.jugador.posicion].r % 2 == 0) {
            this.jugador.ActualizarFigura("D");
        }
        else {
            this.jugador.ActualizarFigura("I");
        }
        if (i < 30) {
            this.jugador.SetImageJugadorAfterNull();
        }
        this.jugador.SetImageJugador();
    }
}
