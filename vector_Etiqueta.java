// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import java.net.URL;
import javax.swing.Icon;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

class vector_Etiqueta
{
    JLabel etiqueta;
    JPanel PanelInterno;
    JLabel[] EtiquetasInternas;
    ImageIcon figura;
    
    public vector_Etiqueta() {
        this.etiqueta = new JLabel();
        this.EtiquetasInternas = new JLabel[4];
        (this.PanelInterno = new JPanel()).setLayout(new GridLayout(2, 2));
        this.PanelInterno.setOpaque(false);
        for (int i = 0; i < 4; ++i) {
            (this.EtiquetasInternas[i] = new JLabel()).setOpaque(false);
            this.PanelInterno.add(this.EtiquetasInternas[i]);
        }
    }
    
    public void SetImagePumba() {
        final URL ruta = this.getClass().getResource("Recursos/PumbaD.gif");
        this.EtiquetasInternas[2].setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, 70, 1)));
    }
    
    public void SetImageSimba() {
        final URL ruta = this.getClass().getResource("Recursos/SimbaD.gif");
        this.EtiquetasInternas[0].setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, 70, 1)));
    }
    
    public void SetImagePumbaV() {
        final URL ruta = this.getClass().getResource("Recursos/PumbaI.gif");
        this.EtiquetasInternas[2].setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, 70, 1)));
    }
    
    public void SetImageSimbaV() {
        final URL ruta = this.getClass().getResource("Recursos/SimbaI.gif");
        this.EtiquetasInternas[0].setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, 70, 1)));
    }
    
    public void SetSimbaImageNull() {
    }
    
    public void SetPumbaImageNull() {
    }
}
