// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class Instrucciones implements ActionListener
{
    JFrame frame;
    JFrame ventana_anterior;
    JButton btnRegresar;
    
    public Instrucciones(final JFrame ventana_anterior) {
        this.ventana_anterior = ventana_anterior;
        this.initialize();
    }
    
    private void initialize() {
        (this.frame = new JFrame()).setBounds(100, 100, 516, 341);
        this.frame.setDefaultCloseOperation(0);
        this.frame.getContentPane().setLayout(null);
        this.frame.setLocationRelativeTo(null);
        (this.btnRegresar = new JButton("REGRESAR")).setForeground(Color.WHITE);
        this.btnRegresar.setFont(new Font("Tahoma", 1, 12));
        this.btnRegresar.setBackground(new Color(204, 51, 51));
        this.btnRegresar.setBounds(358, 147, 105, 23);
        this.btnRegresar.addActionListener(this);
        this.frame.getContentPane().add(this.btnRegresar);
        final JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Instrucciones.class.getResource("Recursos/inst.png")));
        lblNewLabel.setBounds(0, 0, 500, 302);
        this.frame.getContentPane().add(lblNewLabel);
        this.frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(final WindowEvent e) {
                Instrucciones.this.frame.dispose();
                Instrucciones.this.ventana_anterior.setVisible(true);
            }
            
            @Override
            public void windowGainedFocus(final WindowEvent e) {
            }
        });
        this.frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.btnRegresar) {
            this.frame.dispose();
            this.ventana_anterior.setVisible(true);
        }
    }
}
