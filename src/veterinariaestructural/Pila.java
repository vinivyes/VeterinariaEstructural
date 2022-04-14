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
 
    private NodoA top;

    public NodoA getTop() {
        return top;
    }
    
    
    public void push(NodoA elementoNuevo){
        elementoNuevo.setAbajo(top);
        top = elementoNuevo;
    }
    
    public NodoA pop(){
        NodoA aux = top;
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
   

