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
    
    public void MostrarMenuPrincipal(){
            
        String[] opciones = { "Atendimiento", "Consultas", "Medicaciones", "Inventario", "Salir" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Menu Principal",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                MostrarMenuAtendimiento();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    
    private void MostrarMenuAtendimiento(){
        try{
            String[] opciones = { "Nueva Ficha", "Muestra Fila", "Salir" };

            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:",
                    "Atendimiento",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        }
        //En caso de fallo o opcion de cancelar
        catch (Exception ex) { opcion = 3; }
        
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
    
    private void MostrarMenuConsultas(){
        try{
            String[] opciones = { "Atiende Fila", "Mostrar Fila", "Salir" };

            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:",
                    "Consultas",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        }
        //En caso de fallo o opcion de cancelar
        catch (Exception ex) { opcion = 3; }
        
        switch(opcion){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    private void MostrarMenuConsultaActiva() {
        
        try{
            String[] opciones = { "Crear Prescripción", "Solicitar Vacunación", "Terminar Consulta" };

            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:",
                    "Consultas",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        }
        //En caso de fallo o opcion de cancelar
        catch (Exception ex) { opcion = 3; }
        
        switch(opcion){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                MostrarMenuPrincipal();
                break;
        }
    }
    
    private void MostrarMenuMedicaciones(){
        try{
            String[] opciones = { "Entregar Medicación", "Vacunar Animal", "Salir" };

            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:",
                    "Medicaciones",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        }
        //En caso de fallo o opcion de cancelar
        catch (Exception ex) { opcion = 3; }
        
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
}
