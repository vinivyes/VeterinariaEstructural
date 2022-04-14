/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

/**
 *
 * @author Christian
 */

 public class Pila 
{    
 
    private Nodo top;

    public Nodo getTop() {
        return top;
    }
    
    
    public void push(Nodo elementoNuevo){
        elementoNuevo.setAbajo(top);
        top = elementoNuevo;
    }
    
    public Nodo pop(){
        Nodo aux = top;
        if(PilaVacia()){
            System.out.println("No hay datos en la pila");
        }else{
            top = top.getAbajo();
            aux.setAbajo(null);
        }
        return aux;
    }
    
    public boolean PilaVacia(){
        if(top == null){
            return true;
        }else{
            return false;
        }
    }   
}
   

