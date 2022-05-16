// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class Ayuda implements ActionListener
{
    JFrame frame;
    JButton btnRegresar;
    JFrame ventana_anterior;
    
    public Ayuda(final JFrame ventana_anterior) {
        this.ventana_anterior = ventana_anterior;
        this.initialize();
    }
    
    private void initialize() {
        (this.frame = new JFrame()).setBounds(100, 100, 509, 334);
        this.frame.setDefaultCloseOperation(0);
        this.frame.getContentPane().setLayout(null);
        this.frame.setLocationRelativeTo(null);
        final JLabel lblAyuda = new JLabel("AYUDA");
        lblAyuda.setFont(new Font("Tahoma", 1, 20));
        lblAyuda.setBounds(107, 11, 71, 29);
        this.frame.getContentPane().add(lblAyuda);
        final JTextArea txtrAyudaASimba = new JTextArea();
        txtrAyudaASimba.setBackground(SystemColor.menu);
        txtrAyudaASimba.setText("Ayuda  a  Simba, a  Pumba o a ambos\na poder  enfrentar a  Scar  para  poder\nliberar el reino, pero ten cuidado con\nencontrarte con las hienas, puede que\nte ahuyenten y te hagan regresar, por\notro lado, procura los bichos viscosos \ny  sabrosos,  te  daran  energia  para\navanzar mas. Tambien ten cuidado con\nCazzu, te dara un rega\u00c3±o y asi perderas\nun turno.");
        txtrAyudaASimba.setBounds(33, 51, 224, 161);
        this.frame.getContentPane().add(txtrAyudaASimba);
        (this.btnRegresar = new JButton("REGRESAR")).setForeground(Color.WHITE);
        this.btnRegresar.setFont(new Font("Tahoma", 1, 12));
        this.btnRegresar.setBackground(new Color(204, 51, 51));
        this.btnRegresar.setBounds(341, 250, 112, 23);
        this.btnRegresar.addActionListener(this);
        this.frame.getContentPane().add(this.btnRegresar);
        final JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Ayuda.class.getResource("Recursos/ayuda.png")));
        lblNewLabel.setBounds(0, 0, 493, 295);
        this.frame.getContentPane().add(lblNewLabel);
        this.frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(final WindowEvent e) {
                Ayuda.this.frame.dispose();
                Ayuda.this.ventana_anterior.setVisible(true);
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
