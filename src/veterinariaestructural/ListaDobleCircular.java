/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ListaDobleCircular {
    
    private int count;

    public int getCount() {
        return count;
    }
    
    private Nodo cabeza;
    private Nodo ultimo;
    
    public void insertar(Medicacion p){
        
        if(existe(p.getId())) {
            Medicacion existente = extrae(p.getId());
            if(existente.getTipo().equals("Vacuna")){
                JOptionPane.showMessageDialog(null, "No es posible solicitar más de una vacuna del mismo tipo");
            }
            else{
                existente.setCantidad(existente.getCantidad() + p.getCantidad());
            }
            insertar(existente);
            return;
        }
        
        count++;
        
        Nodo n = new Nodo(p);
        
        //Primer en la lista/Lista Vacia
        if(cabeza == null) {
            cabeza = n;
            ultimo = cabeza;
            n.setNext(cabeza);
            n.setPrevious(ultimo);
            return;
        }
        
        
        //Menor que el primer de la lista
        int firstYear = ((Medicacion)cabeza.getElemento()).getId();
        if(p.getId() < firstYear){
            n.setNext(ultimo);
            n.setPrevious(cabeza);
            cabeza.setNext(n);
            cabeza=n;
            ultimo.setPrevious(cabeza);
            return;
        }
        
            
        //Mayor que el ultimo de la lista
        int lastYear = ((Medicacion)ultimo.getElemento()).getId();
        if(p.getId() > lastYear){
            n.setNext(ultimo);
            n.setPrevious(cabeza);
            ultimo.setPrevious(n); //Ultimo actual hace referencia al nuevo nodo que es mayor
            ultimo=n;           //Ultimo ahora es el nuevo nodo
            cabeza.setNext(ultimo);
            return;
        }
        
        //Dentro de la lista
        Nodo aux = cabeza;
        while(aux.getPrevious() != cabeza &&
              ((Medicacion)aux.getPrevious().getElemento()).getId()<=p.getId()){
                        
            aux = aux.getPrevious();
        }
        
        n.setNext(aux);
        n.setPrevious(aux.getPrevious());
        
        aux.getPrevious().setNext(n);
        aux.setPrevious(n);
    }
          
    public boolean existe(int id){
        boolean resultado = _existe(id);
        System.out.printf("ID%d existe ? - Respuesta: %s\n\n", id, (resultado ? "Si" : "No"));
        return resultado;
    }
    
    private boolean _existe(int id){
        if(cabeza == null) { return false; }
        
        Nodo aux = cabeza;
        
        do{
            if(((Medicacion)aux.getElemento()).getId() == id) { return true; }
            aux = aux.getPrevious();
        }
        while(aux != cabeza);
        
        return false;
    }
         
    
    public void modifica(Medicacion p){
        System.out.printf("Modificando ID%d\n\n", p.getId());
        
        if(cabeza == null) { return; }
        
        Nodo aux = cabeza;
        do{ 
            if(((Medicacion)aux.getElemento()).getId() == p.getId()) { aux.setElemento(p); return; }
            aux = aux.getPrevious();
        }
        while(aux != cabeza);
    }
     
    public void elimina(int id) {
        extrae(id);
        System.out.printf("ID%d eliminado\n\n", id);
    }
    
    
    //Extrae la medicion
    public Medicacion extrae(int id) {
        
        if(existe(id)){ count--; }
        
        Medicacion p = null;
        if(cabeza == null) { return p; }
        
        if(((Medicacion)cabeza.getElemento()).getId() == id) { 
            p = (Medicacion)cabeza.getElemento();
            cabeza = cabeza == cabeza.getPrevious() ? null : cabeza.getPrevious();
            if(cabeza != null) { cabeza.setNext(ultimo); }
            ultimo.setPrevious(cabeza);
            
            
            return p;
        }
        
        Nodo aux = cabeza;
        do{ 
            //Si el siguiente elemento es el que buscamos
            if(((Medicacion)aux.getPrevious().getElemento()).getId() == id) { 
                p = (Medicacion)aux.getPrevious().getElemento();  //Guardamos la informacion del siguiente elemento
                aux.setPrevious(aux.getPrevious().getPrevious()); //El siguiente al elemento actual es el que esta a 2 casas hacia adelante
                aux.getPrevious().getPrevious().setNext(aux); //El elemento anterior al que esta a 2 casas es el actual
                
                return p;
            }
            aux = aux.getPrevious();  //Seguimos moviendo hacia el siguiente elemento
        }
        while(aux != cabeza);
        
        return p;
    } 
    
    @Override
    public String toString(){
         
        Nodo aux = cabeza;
        String output = "Lista:\n";
        
        if(cabeza == null){
            return output + "Vacia";
        }
        
        do{
            output += aux.getElemento() + "\n";
            aux = aux.getPrevious();
        }
        while(aux != cabeza);
                   
        return output;           
    }
    
    public String leerInventario(){
         
        Nodo aux = cabeza;
        String output = "";
        
        if(cabeza == null){
            return output + "Vacia";
        }
        
        do{
            output += aux.getElemento();
            aux = aux.getPrevious();
        }
        while(aux != cabeza);
                   
        return output;           
    }
    
      
    public String leerSolicitudes(String textoVacio){
         
        Nodo aux = cabeza;
        String output = "";
        
        if(cabeza == null){
            return output + textoVacio;
        }
        
        do{
            output += ((Medicacion)aux.getElemento()).toStringSolicitud() + "\n";
            aux = aux.getPrevious();
        }
        while(aux != cabeza);
                   
        return output;           
    }
        
    public Medicacion[] leerInventarioDeVacunas(){
                
        Nodo aux = cabeza;
        Medicacion[] output = {};
        
        if(cabeza == null){
            return output;
        }
        
        do{
            if(((Medicacion)aux.getElemento()).getTipo().equals("Vacuna")){
                Medicacion[] temp_output = new Medicacion[output.length + 1];
                for(int i = 0; i < output.length; i++) { 
                    temp_output[i] = output[i]; 
                }

                temp_output[output.length] = (Medicacion)aux.getElemento();
                output = temp_output;
            }

            aux = aux.getPrevious();
        }
        while(aux != cabeza);
                   
        return output;  
    } 
    
    public Medicacion[] leerInventarioDeMedicaciones(){
                
        Nodo aux = cabeza;
        Medicacion[] output = {};
        
        if(cabeza == null){
            return output;
        }
        
        do{
            if(((Medicacion)aux.getElemento()).getTipo().equals("Medicamento")){
                Medicacion[] temp_output = new Medicacion[output.length + 1];
                for(int i = 0; i < output.length; i++) { 
                    temp_output[i] = output[i]; 
                }

                temp_output[output.length] = (Medicacion)aux.getElemento();
                output = temp_output;
            }

            aux = aux.getPrevious();
        }
        while(aux != cabeza);
                   
        return output;  
    } 
}
