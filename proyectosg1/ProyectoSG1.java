
package proyectosg1;

import Controlador_.Ctrlcharlie;
import Controlador_.Ctrlcharliereg;
import Controlador_.Ctrlcuenta;
import Modelo_.Consultascharlie;
import Modelo_.ProductoC;
import Vista_.Ventana1;
import Vista_.Ventana2;
import Vista_.Ventana3;
import Modelo_.Cliente;

public class ProyectoSG1 {

    public static void main(String[] args) {
        
        ProductoC mod = new ProductoC();
        Cliente cl = new Cliente();
        Consultascharlie modC = new Consultascharlie();
        Ventana1 frm = new Ventana1();
        Ventana2 frm2 = new Ventana2();
        Ventana3 frm3 = new Ventana3();
        
        Ctrlcharliereg ctrlc = new Ctrlcharliereg(cl,modC,frm,frm2);
        Ctrlcharlie ctrl = new Ctrlcharlie(mod, modC, frm2, frm3);
        Ctrlcuenta ctrlcc= new Ctrlcuenta(frm3, frm2, frm,ctrl);
        
        ctrlc.iniciarv1();
        ctrl.iniciarv2();
        ctrlcc.iniciarv3();
        
        frm.setVisible(true);
        
    }
    
}
