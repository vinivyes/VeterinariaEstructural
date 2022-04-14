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
    private String color; 
    private double peso; 
    
    //Constructor para crear un nuevo animal, recibe un ID y inicia una sequencia de entradas con JOptionPane para llenar todas las propriedades del Animal
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
        
        //Ingresar un numero entero para la edad, el loop lo hace repetir hasta que se ingrese un numero valido
        do{
            try{
                edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del animal:"));
            }
            catch(Exception ex){ edad = -1; }
        }
        while(edad < 0);
                
        //Lista de opciones para ingresar a la propriedad sexo
        String[] opcionSexo = { "Macho", "Hembra" };

        //El resultado del JOptionPane es un entero (0 o 1) y eso se utiliza para leer la opcion seleccionada desde de el arreglo de opcionSexo (linea 46)
        //El loop lo hace repetir la solicitud hasta recibir una entrada valida.
        do{
            try{
                sexo = opcionSexo[
                    JOptionPane.showOptionDialog(null,
                        "Cual es el sexo del animal:",
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
        
        //Ingresar un numero con decimales para el peso, el loop lo hace repetir hasta que se ingrese un numero valido
        do{
            try{
                peso = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el peso del animal en KG:"));
            }
            catch(Exception ex){ peso = -1; }
        }
        while(peso < 0);
        
        //Un mensaje detallando los datos ingresados
        JOptionPane.showMessageDialog(null, 
                "Se registró el animal #"+id+":\n\n" +
                "Nombre: "+nombre+"\n" +
                "Raza: "+raza+"\n" +
                "Edad: "+edad+"\n" +
                "Sexo: "+sexo+"\n" +
                "Color: "+color+"\n" +
                "Peso: "+peso+"kg");
    }
    
    //Crea un Animal que recibe todas las propriedades, puede ser utilizado para pruebas.
    public Animal (int _id, String _nombre, String _raza, int _edad, String _sexo, String _color, double _peso){
        id = _id;
        nombre = _nombre;
        raza = _raza;
        edad = _edad;
        sexo = _sexo;
        color = _color;
        peso = _peso;
    }

    //Getters
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

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
