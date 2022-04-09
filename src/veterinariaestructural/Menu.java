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
public class Menu {
    
    //Opcion seleccionada del menu
    private int opcion;
    
    private Cola colaDeAtencion = new Cola();
    
    private int id = 1;
    
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Susy","Maltes",8,"Hembra","Beige",10.2)));
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Bruno","French Poodle",10,"Macho","Negra",5.4)));
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Scooby","Chiuaua",4,"Macho","Negro",7.5)));
    }
    
    public Menu(){
        CrearPruebas();
    }
    
    //Incrementa el ID actual, y regresa un ID
    private int proximoId(){
        int _id = id;
        id++;
        return _id;
    }
    
    public void MostrarMenuPrincipal(){
            
        String[] opciones = { "Atención", "Consultas", "Medicaciones", "Inventario", "Salir" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Menu Principal",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                MostrarMenuAtencion();
                break;
            case 1:
                MostrarMenuConsultas();
                break;
            case 2:
                MostrarMenuMedicaciones();
                break;
            case 3:
                MostrarMenuInventario();
                break;
        }
    }
    
    private void MostrarMenuAtencion(){
        
        String[] opciones = { "Nueva Ficha", "Muestra Fila", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Atención",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                colaDeAtencion.encola(new Nodo(new Animal(proximoId())));
                MostrarMenuAtencion();
                break;
            case 1:
                MostrarFilaDeAnimales();
                MostrarMenuAtencion();
                break;
            case 2:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    private void MostrarMenuConsultas(){
        
        String[] opciones = { "Atiende Fila", "Mostrar Fila", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Consultas",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                Nodo siguiente = colaDeAtencion.atiende();
                
                if(siguiente == null) {
                    JOptionPane.showMessageDialog(null, "No hay animales esperando atención");
                    MostrarMenuConsultas();
                }
                else{
                    MostrarMenuConsultaActiva(
                        (Animal)siguiente.getElemento() //Extrae el siguiente nodo de la cola, y lo convierte en clase Animal.
                    );
                }
                
                break;
            case 1:
                MostrarFilaDeAnimales();
                MostrarMenuConsultas();
                break;
            case 2:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    //Mostrar un menu personalizado para cada animal que inicie consulta
    private void MostrarMenuConsultaActiva(Animal a) {

        String[] opciones = { "Crear Prescripción", "Solicitar Vacunación", "Terminar Consulta" };

        opcion = JOptionPane.showOptionDialog(null,
                "Estás atendiendo a:\n" +
                a.getNombre() + " (" + a.getRaza() + ") - " + a.getEdad() + " año(s)\n\n" +
                "Seleccione una opción:",
                "Consultas",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch(opcion){
            case 0:
                MostrarMenuConsultas();
                break;
            case 1:
                MostrarMenuConsultas();
                break;
            case 2:
                MostrarMenuConsultas();
                break;
        }
    }
    
    private void MostrarMenuMedicaciones(){

        String[] opciones = { "Entregar Medicación", "Vacunar Animal", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Medicaciones",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                break;
            case 1:
                break;
            case 2:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    private void MostrarMenuInventario(){

        String[] opciones = { "Inventario Medicación", "Desechar Vacunas", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Medicaciones",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                MostrarMenuInventarioDeMedicación();
                break;
            case 1:
                break;
            case 2:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    private void MostrarMenuInventarioDeMedicación(){

        String[] opciones = { "Añadir Medicación", "Modificar Medicación", "Mostrar Inventario", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Medicaciones",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                MostrarMenuInventario();
                break;
        }
    }
    
    private void MostrarFilaDeAnimales(){
        Cola colaTemporal = new Cola();
        
        String salida = "Fila Actual:\n\n";
        
        salida += LeerFilaDeAnimales(colaDeAtencion, colaTemporal, "");
        
        JOptionPane.showMessageDialog(null, salida);
    }
    
    //Leer fila de animales y retornar texto con información de los animales recursivamente
    private String LeerFilaDeAnimales(Cola c, Cola temp, String salida){
        Nodo siguiente = c.atiende();
        
        if(siguiente == null) { 
            Nodo nodoTemp = null;
            
            //Regresa a la cola los nodos guardados en la cola temporal
            do{
               nodoTemp = temp.atiende();
               
               c.encola(nodoTemp);
            }
            while(nodoTemp != null);
            
            return salida; 
        }
        
        temp.encola(siguiente);
        
        Animal a = (Animal)siguiente.getElemento();
        
        salida += "[#"+ a.getId() + "] " + a.getNombre() + " (" + a.getRaza() + ") - " + a.getEdad() + " año(s)\n";
        
        return LeerFilaDeAnimales(c, temp, salida);
    }
}
