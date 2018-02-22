/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import datos.conexionDatos;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ggarciaalvarez
 */
public class Libreria {
public static ArrayList<Libro> libros = new ArrayList<>();
    
    public static void engadir() throws IOException{
        
        String nome = JOptionPane.showInputDialog("Escribe el Nombre");
        String autor = JOptionPane.showInputDialog("Escribe el Autor");
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Escribe el Precio"));
        int unidades = Integer.parseInt(JOptionPane.showInputDialog("Escribe el Unidades"));
        Libro libro = new Libro(nome, autor, precio, unidades);
        
        libros.add(libro);
        conexionDatos.guardarDatos();
    }
    
    public static void consultaPrecio(){
        
        boolean check = false;
        String titulo = JOptionPane.showInputDialog("Introduce el titulo a buscar");
        
        for (Libro libro: libros){
            
            if(libro.getNome().equals(titulo)){
                
                System.out.format("\nEl precio del libro (%s) es: %.2f", libro.getNome(), libro.getPrecio());
                check = true; break;
            }
            
            if(check == true){
                
                System.out.format("\nEl libro (%s) no existe en nuestra colección.", titulo);
            }
        }
    }
    
    public static void visualizar(){
        
        libros.forEach((libro) -> {
            System.out.format("\nTitulo: %s, Autor: %s, Precio: %.2f, Unidades: %d", 
                    libro.getNome(), libro.getAutor(), libro.getPrecio(), libro.getUnidades());
    });
    }
    
    public static void borrar() throws IOException{
        
        for (Libro libro: libros){
            
            if(libro.getUnidades() < 1){
                
                libros.remove(libro); 
                conexionDatos.guardarDatos(); break;
            }
        }
    }
    
    public static void modificar() throws IOException{
        
        boolean check = false;
        String titulo = JOptionPane.showInputDialog("Introduce el titulo a buscar");
        
        for (Libro libro: libros){
            
            if(libro.getNome().equals(titulo)){
                
                float precio = Float.parseFloat(JOptionPane.showInputDialog("Introduce el nuevo precio"));
                libro.setPrecio(precio);
                conexionDatos.guardarDatos();
            }
            
            if(check == true){
                
                System.out.format("\nEl libro (%s) no existe en nuestra colección.", titulo);
            }
        }
}
}
