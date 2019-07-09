
package latiendita;

import javax.swing.JOptionPane;

public class Principal {

   public static int Menu()
   {
       int op;
       op=Integer.parseInt(JOptionPane.showInputDialog("Digite opcion"
               + "\n 1. Comprar"
               + "\n 2. Vender"
               + "\n 3. Buscar"
               + "\n 4. Incrementar"
               + "\n 5. Listar escasos"
               + "\n 6. Eliminar"
               + "\n 7. Mostrar"
               + "\n 8. Salir"));
       return op;
   }
    public static void main(String[] args) {
       Lista productos = new Lista();
       Lista esc=null;
       Producto p = null;
       int codigo, cantidad, op;
       double precio;
       String seccion;
      
           
       
       do{
           op=Menu();
           switch(op)
           {
               case 1:
                   codigo=Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
                   precio=Double.parseDouble(JOptionPane.showInputDialog("Digite precio"));
                   seccion = JOptionPane.showInputDialog("Digite seccion: Granos, Enlatados, Frutas, Verduras, Refrigerados");
                   cantidad=Integer.parseInt(JOptionPane.showInputDialog("Digite cantidad"));
                   productos.Comprar(new Producto(codigo, precio, seccion, cantidad));
                   JOptionPane.showMessageDialog(null, productos.toString());
                   break;
                   
               case 2:
                   codigo=Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
                   cantidad=Integer.parseInt(JOptionPane.showInputDialog("Digite cantidad"));
                   int resp= productos.Vender(codigo, cantidad);
                   if(resp==1)
                       JOptionPane.showMessageDialog(null, "El producto no existe");
                   else
                   {
                       if(resp==2)
                           JOptionPane.showMessageDialog(null, "Cantidad insuficiente");
                       else
                           JOptionPane.showMessageDialog(null, "Venta exitosa");
                   }
               break;
               case 3:
                   codigo=Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
                   p=productos.Buscar(codigo);
                   if(p!=null)
                       JOptionPane.showMessageDialog(null, p.toString());
                   else
                       JOptionPane.showMessageDialog(null, "Producto no existe");
                   break;
                   
               case 4:
                   seccion = JOptionPane.showInputDialog("Digite seccion: Granos, Enlatados, Frutas, Verduras, Refrigerados");
                   productos.Incrementar(seccion);
                   JOptionPane.showMessageDialog(null, "Se hizo el incremento");
                   break;
                   
               case 5:
                   
                   JOptionPane.showMessageDialog(null, "Los productos escasos son: " + productos.Escasos());
                   break;
                   
               case 6:
                   codigo=Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
                   p=productos.Eliminar(codigo);
                   if(p!=null)
                       JOptionPane.showMessageDialog(null, p.toString());
                   else
                       JOptionPane.showMessageDialog(null, "Producto no existe");
                   break;
                   
               case 7:                   
                   JOptionPane.showMessageDialog(null, "La lista es: \n" + productos.toString() );
                   break;
                   
               case 8:
                   JOptionPane.showMessageDialog(null, "Finalizando....");
                   break;
                   
               default:
                   
                   JOptionPane.showMessageDialog(null, "Opcion invalida");
                   break;
                   
           }
           
       }while(op!=8);
               
    }
    
}
