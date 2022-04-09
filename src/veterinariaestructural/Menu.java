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
    
    private void MostrarMenuAtendimiento(){
        
        String[] opciones = { "Nueva Ficha", "Muestra Fila", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Atendimiento",
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
    
    private void MostrarMenuConsultas(){
        
        String[] opciones = { "Atiende Fila", "Mostrar Fila", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Consultas",
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
    
    //Mostrar un menu personalizado para cada animal que inicie consulta
    private void MostrarMenuConsultaActiva() {

        String[] opciones = { "Crear Prescripción", "Solicitar Vacunación", "Terminar Consulta" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Consultas",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

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
}
