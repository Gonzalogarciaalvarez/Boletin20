/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import datos.conexionDatos;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
        
/**
 *
 * @author ggarciaalvarez
 */
public class Boletin20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException  {
      
        conexionDatos.leerDatos();
        
        boolean exit = false;
        String[] possibilities = {"Añadir Libro", "Consultar Libro", 
            "Visualizar Libros", "Eliminar sin Stock", "Modificar Libro"};
        
        do {
            
            String opcion = (String)JOptionPane.showInputDialog(null, "", "Panel de Control",
                    JOptionPane.PLAIN_MESSAGE, null, possibilities, null );
            if (opcion == null){
                opcion = "";
            }

            switch(opcion){
                case "Añadir Libro": Libreria.engadir(); break; 
                case "Consultar Libro": Libreria.consultaPrecio(); break;
                case "Visualizar Libros": Libreria.visualizar(); break;
                case "Eliminar sin Stock": Libreria.borrar(); break;
                case "Modificar Libro": Libreria.modificar(); break;
                default: exit = true; break;
            }
            
        } while(exit == false);
}
    }