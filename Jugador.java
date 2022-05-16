// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.LinkedList;

class Jugador
{
    int posicion;
    boolean cazzu;
    LinkedList<Integer> movimientos;
    URL ruta;
    ImageIcon figura;
    vector_Etiqueta[][] vEti;
    defTablero[] T;
    JButton bDado;
    int pos_interna;
    String nombre;
    JFrame V;
    JFrame ventana_anterior;
    
    public Jugador(final vector_Etiqueta[][] vEti, final defTablero[] T, final JButton bDado, final int pos_interna, final String nombre, final JFrame V, final JFrame ventana_anterior) {
        this.vEti = vEti;
        this.T = T;
        this.bDado = bDado;
        this.nombre = nombre;
        this.pos_interna = pos_interna;
        this.V = V;
        this.ventana_anterior = ventana_anterior;
        this.cazzu = false;
        this.posicion = 1;
        this.movimientos = new LinkedList<Integer>();
        this.ruta = this.getClass().getResource("Recursos/" + nombre + "D.gif");
        this.figura = new ImageIcon(this.ruta);
        this.SetImageJugador();
    }
    
    public void ActualizarFigura(final String actualizar) {
        this.ruta = this.getClass().getResource("Recursos/" + this.nombre + actualizar + ".gif");
        this.figura = new ImageIcon(this.ruta);
    }
    
    public void AgregarMovimiento(final int mov) {
        System.out.println("Salio " + mov + " en el dado");
        this.movimientos.add(mov);
        System.out.println("Se agrego " + this.movimientos + " a la lista de movimientos");
    }
    
    public void MoverJugador() {
        final Thread HiloMover = new Thread(new ThreadDemo(this.posicion, this.movimientos, this.figura, this.vEti, this.T, this.bDado, this, this.V, this.ventana_anterior));
        HiloMover.start();
    }
    
    public void SetImageJugador() {
        this.vEti[this.T[this.posicion].getRenglon()][this.T[this.posicion].getColumna()].EtiquetasInternas[this.pos_interna].setIcon(new ImageIcon(this.figura.getImage().getScaledInstance(70, 70, 1)));
    }
    
    public void SetImageJugadorBeforeNull() {
        this.vEti[this.T[this.posicion - 1].getRenglon()][this.T[this.posicion - 1].getColumna()].EtiquetasInternas[this.pos_interna].setIcon(null);
    }
    
    public void SetImageJugadorAfterNull() {
        this.vEti[this.T[this.posicion + 1].getRenglon()][this.T[this.posicion + 1].getColumna()].EtiquetasInternas[this.pos_interna].setIcon(null);
    }
}
