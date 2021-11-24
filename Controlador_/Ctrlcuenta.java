
package Controlador_;

import Vista_.Ventana3;
import Vista_.Ventana2;
import Vista_.Ventana1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Ctrlcuenta implements ActionListener{
    
    private Ventana3 frm3;
    private Ventana2 frm2;
    private Ventana1 frm1;
    private Ctrlcharlie crtlcc;
    
    public Ctrlcuenta( Ventana3 frm3, Ventana2 frm2, Ventana1 frm1, Ctrlcharlie ctrlcc){
        
        this.frm3=frm3;
        this.frm2=frm2;
        this.frm1=frm1;
        this.frm3.btnRegresarv3.addActionListener(this);
        this.frm3.btnOKv3.addActionListener(this);
        this.crtlcc=crtlcc;
        
    }
    
    public void iniciarv3(){
        frm3.setTitle("Charlie merca por ti");
        frm3.setLocationRelativeTo(null); // para centrar 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==frm3.btnRegresarv3){
            frm2.setVisible(true);   
        }
        
        if(e.getSource()==frm3.btnOKv3){
            JOptionPane.showMessageDialog(null, "Gracias por su compra");
            limpiarv3();
            limpiarv2();
            limpiarv1();
            frm2.dispose();
            frm3.dispose();
            crtlcc.cuenta=0;
            frm1.setVisible(true);
        }
    }
    
    public void limpiarv3(){
        frm3.txtDetallesv3.setText(null);     
    }
    
    public void limpiarv1(){
        frm1.txtNombrev1.setText(null);
        frm1.txtCelularv1.setText(null);
        frm1.txtDireccionv1.setText(null);
    }
    
    public void limpiarv2(){
        frm2.txtIdv2.setText(null);
        frm2.txtCodigov2.setText(null);
        frm2.txtNombrev2.setText(null);
        frm2.txtPreciov2.setText(null);
        frm2.txtCantidadv2.setText(null);
        
    }
}
