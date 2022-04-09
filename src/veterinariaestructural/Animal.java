/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

/**
 *
 * @author Vinicius
 */
public class Animal {
    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private String sexo;
    private String nacimiento;
    private String color; 
    private int pesos; 
    private String sensibilidad; 
    
    
    

    public Animal (String _nombre){
        nombre = _nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
