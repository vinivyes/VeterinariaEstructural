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
public class Animal {
    private int id;
    private String nombre;
    private String raza;
    private int edad = -1;
    private String sexo = "";
    //private String nacimiento;
    private String color; 
    private double peso; 
    //private String sensibilidades; 
    
    public Animal (int _id){
        id = _id;
        
        //Ingresar nombre
        nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre del animal:"
        );
        
        //Ingresar raza
        raza = JOptionPane.showInputDialog(null,
                "Ingrese la raza del animal:"
        );
        
        //Ingresar un numero entero para la edad, repetir hasta que se ingrese un numero valido
        do{
            try{
                edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del animal:"));
            }
            catch(Exception ex){ edad = -1; }
        }
        while(edad == -1);
                
        //Lista de opciones para ingresar a la propriedad sexo
        String[] opcionSexo = { "Macho", "Hembra" };

        //El resultado del JOptionPane es un entero (0 o 1) y eso se utiliza para leer la opcion seleccionada desde de el arreglo de opcionSexo (linea 47)
        do{
            try{
                sexo = opcionSexo[
                    JOptionPane.showOptionDialog(null,
                        "Qual es el sexo del animal:",
                        null,
                    0, JOptionPane.INFORMATION_MESSAGE, null, opcionSexo, opcionSexo[0])
                ];
            }
            catch(Exception ex){ sexo = ""; }
        }
        while(sexo.equals(""));
        
        //Ingresar color
        color = JOptionPane.showInputDialog(null,
                "Ingrese el color del animal:"
        );
        
        do{
            try{
                peso = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el peso del animal:"));
            }
            catch(Exception ex){ peso = -1; }
        }
        while(peso == -1);
        
        JOptionPane.showMessageDialog(null, 
                "Se registró el animal #"+id+":\n\n" +
                "Nombre: "+nombre+"\n" +
                "Raza: "+raza+"\n" +
                "Edad: "+edad+"\n" +
                "Sexo: "+sexo+"\n" +
                "Color: "+color+"\n" +
                "Peso: "+peso+"kg");
    }
    
    public Animal (int _id, String _nombre, String _raza, int _edad, String _sexo, String _color, double _peso){
        id = _id;
        nombre = _nombre;
        raza = _raza;
        edad = _edad;
        sexo = _sexo;
        color = _color;
        peso = _peso;
    }

    public int getId() {
        return id;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getColor() {
        return color;
    }

    public double getPeso() {
        return peso;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
