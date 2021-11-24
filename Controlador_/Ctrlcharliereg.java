
package Controlador_;

import Modelo_.Consultascharlie;
import Modelo_.Cliente;
import Vista_.Ventana1;
import Vista_.Ventana2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Ctrlcharliereg implements ActionListener{
    
    private Cliente cl; //cliente
    private Consultascharlie modC; //consultas  
    private Ventana1 frm;
    private Ventana2 frm2;
    
    public Ctrlcharliereg(Cliente cl, Consultascharlie modC, Ventana1 frm, Ventana2 frm2 ){
        this.cl=cl;
        this.modC=modC;
        this.frm=frm;
        this.frm2=frm2;
        this.frm.btnRegistrarv1.addActionListener(this);
        this.frm.btnModificarv1.addActionListener(this);
        this.frm.btnEliminarv1.addActionListener(this);
        this.frm.btnLimpiarv1.addActionListener(this);
        this.frm.btnBuscarv1.addActionListener(this);
        this.frm.btnMercarv1.addActionListener(this);
    }
    
    public void iniciarv1(){
        frm.setTitle("Charlie merca por ti");
        frm.setLocationRelativeTo(null); // para centrar
        frm.txtIdv1.setVisible(false); //para hacer la caja de texto invisible 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //FileWriter fw = null;
        //PrintWriter pw=null;
        
        if(e.getSource()==frm.btnRegistrarv1){
            try{
                cl.setNombre(frm.txtNombrev1.getText());
                cl.setCelular(Integer.parseInt(frm.txtCelularv1.getText()));
                cl.setDireccion(frm.txtDireccionv1.getText());

                   
                if(modC.registrarP(cl)){
                  JOptionPane.showMessageDialog(null, "Registro Guardado");
                  limpiarv1();
                }else{
                  JOptionPane.showMessageDialog(null, "Error al Guardar");
                  limpiarv1();
                  
            }
            }catch(Exception ex){
                try (FileWriter fw = new FileWriter ("C:\\Users\\ADMIN\\Desktop\\excepciones\\manejoexcp.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO registro "+ex.getMessage());
                    //System.out.println("Error OJO registro");
                } catch (Exception ex1) {
                    //
                }
                System.out.println("OJO");
            }
        }    
            
           
        if(e.getSource()==frm.btnModificarv1){
            try{
                
                cl.setNombre(frm.txtNombrev1.getText());
                cl.setCelular(Integer.parseInt(frm.txtCelularv1.getText()));
                cl.setDireccion(frm.txtDireccionv1.getText());
           
            
                if(modC.modificarP(cl)){
                  JOptionPane.showMessageDialog(null, "Registro Modificado");
                  limpiarv1();
                }else{
                  JOptionPane.showMessageDialog(null, "Error al Modificar");
                  limpiarv1();
            }
            }catch(Exception ex){
                
                    try (FileWriter fw = new FileWriter ("C:\\Users\\ADMIN\\Desktop\\excepciones\\manejoexcp.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO modificar "+ex.getMessage());
                    //System.out.println("Error OJO registro");
                    }catch (Exception ex1) {
                    //
                    }
                System.out.println("OJO");
                }
        }
           
        
        if(e.getSource()==frm.btnEliminarv1){
            try{
                
                cl.setId(Integer.parseInt(frm.txtIdv1.getText()));           
            
                if(modC.eliminarC(cl)){
                  JOptionPane.showMessageDialog(null, "Registro Eliminado");
                  limpiarv1();
                }else{
                  JOptionPane.showMessageDialog(null, "Error al Eliminar");
                  limpiarv1();
                }
            }catch(Exception ex){
                
                    try (FileWriter fw = new FileWriter ("C:\\Users\\ADMIN\\Desktop\\excepciones\\manejoexcp.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO al eliminar "+ex.getMessage());
                    //System.out.println("Error OJO registro");
                    }catch (Exception ex1) {
                    //
                    }
                System.out.println("OJO");
                }
        }
        
            
        
        /*if(e.getSource()==frm.btnRegistrarv1){
            cl.setNombre(frm.txtNombrev1.getText());
            cl.setCelular(Integer.parseInt(frm.txtCelularv1.getText()));
            cl.setDireccion(frm.txtDireccionv1.getText());

                   
            if(modC.registrarP(cl)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiarv1();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiarv1();
            }
        }*/
        
        /*if(e.getSource()==frm.btnModificarv1){
            cl.setNombre(frm.txtNombrev1.getText());
            cl.setCelular(Integer.parseInt(frm.txtCelularv1.getText()));
            cl.setDireccion(frm.txtDireccionv1.getText());
           
            
            if(modC.modificarP(cl)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiarv1();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiarv1();
            }
        }*/
        
        
        /*if(e.getSource()==frm.btnEliminarv1){
            cl.setId(Integer.parseInt(frm.txtIdv1.getText()));
            
            
            if(modC.eliminarC(cl)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiarv1();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiarv1();
            }
        }
        */
        
        
        if(e.getSource()==frm.btnBuscarv1){
            cl.setCelular(Integer.parseInt(frm.txtCelularv1.getText()));//cl.setNombre(frm.txtNombrev1.getText());
            
            
            if(modC.buscarC(cl)){
                
                frm.txtIdv1.setText(String.valueOf(cl.getId()));
                frm.txtNombrev1.setText(cl.getNombre()); //para pasarlo a string ya que no se puede usar el tostring
                frm.txtCelularv1.setText(String.valueOf(cl.getCelular()));
                frm.txtDireccionv1.setText(cl.getDireccion());
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el registro");
                limpiarv1();
            }
        }
        
        
        if(e.getSource()==frm.btnMercarv1){
            
            
            cl.setNombre(frm.txtNombrev1.getText());
            
            
            if(modC.buscarC(cl)){
                
                frm.txtNombrev1.setText(cl.getNombre()); //para pasarlo a string ya que no se puede usar el tostring
                frm.txtCelularv1.setText(String.valueOf(cl.getCelular()));
                frm.txtDireccionv1.setText(cl.getDireccion());
                //JOptionPane.showMessageDialog(null, "Ya está registrado! ");
                frm.dispose();
                frm2.txtNombreClientev2.setText(cl.getNombre());
                frm2.setVisible(true);
                //limpiarv1();
                
            }else{
                JOptionPane.showMessageDialog(null, "Registrate! ");
                limpiarv1();
            }
        }
        
        
        if(e.getSource()==frm.btnLimpiarv1){
            limpiarv1();
        }
        
    

    }
    
    public void limpiarv1(){
        frm.txtNombrev1.setText(null);
        frm.txtCelularv1.setText(null);
        frm.txtDireccionv1.setText(null);
    }
       
}    
        
    

