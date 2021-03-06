
package Controlador_;


import Modelo_.Consultascharlie;
import Modelo_.ProductoC;
import Vista_.Ventana2;
import Vista_.Ventana3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
<<<<<<< HEAD
//import java.lang.*;
=======
>>>>>>> c3db1eac003350036af52402d3231968464ed375

public class Ctrlcharlie implements ActionListener{
    
    private ProductoC mod; //producto venta
    private Consultascharlie modC; //consultas  
    private Ventana2 frm2;
    private Ventana3 frm3;
    public static double cuenta=0;
    public static boolean flag=false;
    
    
    public Ctrlcharlie(ProductoC mod, Consultascharlie modC, Ventana2 frm2, Ventana3 frm3){
        //ventana2
        this.mod=mod;
        this.modC=modC;
        this.frm2=frm2;
        this.frm3=frm3;
        this.frm2.btnRegistrarv2.addActionListener(this);
        this.frm2.btnModificarv2.addActionListener(this);
        this.frm2.btnEliminarv2.addActionListener(this);
        this.frm2.btnLimpiarv2.addActionListener(this);
        this.frm2.btnBuscarv2.addActionListener(this);
        this.frm2.btnPagarv2.addActionListener(this);
        
     
    }
    
   
    public void iniciarv2(){
        frm2.setTitle("Charlie merca por ti");
        frm2.setLocationRelativeTo(null); // para centrar
        frm2.txtIdv2.setVisible(false); //para hacer la caja de texto invisible
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
             
        //con manejo de excepciones
        
        if(e.getSource()==frm2.btnRegistrarv2){
            flag=true;
            try{
                mod.setCodigo(frm2.txtCodigov2.getText());
                mod.setNombre(frm2.txtNombrev2.getText());
                mod.setPrecio(Double.parseDouble(frm2.txtPreciov2.getText()));
                mod.setCantidad(Integer.parseInt(frm2.txtCantidadv2.getText()));
            
                if(modC.registrar(mod)){
                  JOptionPane.showMessageDialog(null, "Registro Guardado");
                  //operacion y envio de info a ventana 3
                  double valor = mod.getPrecio()*mod.getCantidad();
                  //double cuenta; //= valor;
                  cuenta +=valor; //cuenta;
                  frm3.txtDetallesv3.setText("===========" + String.format("%.2f",cuenta));//.append(mod.getNombre() + " " +String.valueOf(mod.getPrecio()) );
                  
                  limpiarv2();
                }else{
                  JOptionPane.showMessageDialog(null, "Error al Guardar");
                  limpiarv2();
                }
                  
            
            }catch(Exception ex){
                try (FileWriter fw = new FileWriter ("C:\\excepciones\\excepciones.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO registro_producto "+ex.getMessage());
                    //System.out.println("Error OJO registro");
                } catch (Exception ex1) {
                    //
                }
                System.out.println("OJO registro");
            }
        }
        
        
        if(e.getSource()==frm2.btnModificarv2){
            try{
                mod.setId(Integer.parseInt(frm2.txtIdv2.getText()));
                mod.setCodigo(frm2.txtCodigov2.getText());
                mod.setNombre(frm2.txtNombrev2.getText());
                mod.setPrecio(Double.parseDouble(frm2.txtPreciov2.getText()));
                mod.setCantidad(Integer.parseInt(frm2.txtCantidadv2.getText()));
            
                if(modC.modificar(mod)){
                  JOptionPane.showMessageDialog(null, "Registro Modificado");
                  limpiarv2();
                }else{
                  JOptionPane.showMessageDialog(null, "Error al Modificar");
                  limpiarv2();
                }
            }catch(Exception ex){
                try (FileWriter fw = new FileWriter ("C:\\excepciones\\excepciones.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO al modificar producto "+ex.getMessage());
                    //System.out.println("Error OJO registro");
                } catch (Exception ex1) {
                    //
                }
                System.out.println("OJO");
            }
        }    
        
        if(e.getSource()==frm2.btnEliminarv2){
            try{
                mod.setId(Integer.parseInt(frm2.txtIdv2.getText()));
                if(modC.eliminar(mod)){
                  double valor = mod.getPrecio()*mod.getCantidad();
                  cuenta -= valor;
                  frm3.txtDetallesv3.setText("===========" + String.format("%.2f",cuenta));
                
                  JOptionPane.showMessageDialog(null, "Registro Eliminado");
                  limpiarv2();
                }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiarv2();
                }
                  
            
            }catch(Exception ex){
                try (FileWriter fw = new FileWriter ("C:\\excepciones\\excepciones.txt", true);){         
                    PrintWriter pw = new PrintWriter (fw);
                    pw.println("Error OJO al eliminar producto "+ex.getMessage());
                } catch (Exception ex1) {
                    //
                }
                System.out.println("OJO");
            }
        }    
        
        // ventana dos
        
        
        
        if(e.getSource()==frm2.btnPagarv2){
            
            if(modC.buscar(mod) && flag==true){
                
                frm2.dispose();
                frm3.setVisible(true);
                flag=false;
                
            }else{
                JOptionPane.showMessageDialog(null, "Registra alg??n producto ");
                limpiarv2();
            }
        }
        
        
        if(e.getSource()==frm2.btnBuscarv2){
            mod.setCodigo(frm2.txtCodigov2.getText());
            
            
            if(modC.buscar(mod)){
                
                frm2.txtIdv2.setText(String.valueOf(mod.getId())); //para pasarlo a string ya que no se puede usar el tostring
                frm2.txtCodigov2.setText(mod.getCodigo());
                frm2.txtNombrev2.setText(mod.getNombre());
                frm2.txtPreciov2.setText(String.valueOf(mod.getPrecio()));
                frm2.txtCantidadv2.setText(String.valueOf(mod.getCantidad()));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontr?? el registro");
                limpiarv2();
            }
        }
        
        
        if(e.getSource()==frm2.btnLimpiarv2){
            limpiarv2();
        }
    }
    
    //metodos para limpiar las ventanas
    public void limpiarv2(){
        frm2.txtIdv2.setText(null);
        frm2.txtCodigov2.setText(null);
        frm2.txtNombrev2.setText(null);
        frm2.txtPreciov2.setText(null);
        frm2.txtCantidadv2.setText(null);
        
    }
    
 
    
}
