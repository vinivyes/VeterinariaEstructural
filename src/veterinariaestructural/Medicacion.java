/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Medicacion {
    private int id;
    private String nombre; //Nombre del medicamento (Acetomenofen...)
    private String tipo; //Medicacion o Vacuna
    private String lote; 
    private int cantidad;
    
    public Medicacion(int _id) {
        id = _id;
        
        //Ingresar nombre
        nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre de la medicacion:"
        );
             
        //Lista de opciones para ingresar a la propriedad sexo
        String[] opcionTipo = { "Medicamento", "Vacuna" };

        //El resultado del JOptionPane es un entero (0 o 1) y eso se utiliza para leer la opcion seleccionada desde de el arreglo de opcionTipo (linea 29)
        do{
            try{
                tipo = opcionTipo[
                    JOptionPane.showOptionDialog(null,
                        "Qual es el tipo de medicamento:",
                        null,
                    0, JOptionPane.INFORMATION_MESSAGE, null, opcionTipo, opcionTipo[0])
                ];
            }
            catch(Exception ex){ tipo = ""; }
        }
        while(tipo.equals(""));
        
        //Ingresar lote
        lote = JOptionPane.showInputDialog(null,
                "Ingrese el lote de la medicacion:"
        );
        
        //Ingresar un numero entero para la cantidad, repetir hasta que se ingrese un numero valido
        do{
            try{
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de existencias del medicamento:"));
            }
            catch(Exception ex){ cantidad = -1; }
        }
        while(cantidad == -1);
        
        JOptionPane.showMessageDialog(null, 
                "Se registró la medicación con #"+id+":\n\n" +
                "Nombre: "+nombre+"\n" +
                "Tipo: "+tipo+"\n" +
                "Lote: "+lote+"\n" +
                "Cantidad: "+cantidad+"\n");
    }
    
    public Medicacion(int _id, String _nombre,String _tipo, String _lote, int _cantidad) {
        id = _id;
        nombre = _nombre;
        tipo = _tipo;
        lote = _lote;
        cantidad = _cantidad;
    }
    
    //Hace una copia de la medicacion con la cantidad a entregar
    public Medicacion entregarMedicacion(int entregarCantidad){
        if(entregarCantidad > cantidad){
            JOptionPane.showMessageDialog(null, "No hay existencias suficientes de " + nombre + " en el inventario de la veterinaria.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Se entregan " + entregarCantidad + " - " + nombre);
        }
        
        Medicacion m = new Medicacion(id,nombre,tipo,lote,entregarCantidad);
        
        cantidad -= entregarCantidad;
        
        
        return m;
    }
    
        //Hace una copia de la medicacion con la cantidad a entregar
    public Medicacion aplicarVacuna(int entregarCantidad){
        if(entregarCantidad > cantidad){
            JOptionPane.showMessageDialog(null, "No hay existencias suficientes de la vacuna " + nombre + " en el inventario de la veterinaria.");
            return null;
        }
        else{
            JOptionPane.showMessageDialog(null, "Se aplica la vacuna " + nombre);
        }
        
        Medicacion m = new Medicacion(id,nombre,tipo,lote,entregarCantidad);
        
        cantidad -= entregarCantidad;
        
        
        return m;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLote() {
        return lote;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return "[#"+ getId() + "] " + getNombre() + " (" + getTipo() + ") - Existencias: " + getCantidad();         
    }
    
    public String toStringSolicitud(){
        return "[#"+ getId() + "] " + getNombre() + " - Cantidad Solicitada: " + getCantidad();         
    }

}
