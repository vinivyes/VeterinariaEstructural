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
    private ListaDobleCircular inventarioMedicacion = new ListaDobleCircular();
    private Cola colaDeEntregaDeMedicacion = new Cola();
    private Cola colaDeVacunacion = new Cola();
    private Pila pilaDeVacunasAplicadas = new Pila();
    
    private int id = 1;
    
    private void CrearPruebas(){
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Lulu","Poodle",10,"Hembra","Blanca",8.1)));
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Susy","Maltes",8,"Hembra","Beige",10.2)));
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Bruno","French Poodle",10,"Macho","Negra",5.4)));
        colaDeAtencion.encola(new Nodo(new Animal(proximoId(),"Scooby","Chiuaua",4,"Macho","Negro",7.5)));
        inventarioMedicacion.insertar(new Medicacion(proximoId(),"Acetominofen","Medicamento","SD-32123",10));
        inventarioMedicacion.insertar(new Medicacion(proximoId(),"Rabia","Vacuna","RB12443A",8));
        inventarioMedicacion.insertar(new Medicacion(proximoId(),"Iboprofeno","Medicamento","AS123124",5));
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
                MostrarMenuCrearPrescripcion(a);
                break;
            case 1:
                MostrarMenuSolicitaVacunacion(a);
                break;
            case 2:
                MostrarMenuConsultas();
                break;
        }
    }
    
    private void MostrarMenuCrearPrescripcion(Animal a){
        Medicacion[] medicaciones = inventarioMedicacion.leerInventarioDeMedicaciones();
        if(medicaciones.length == 0){ 
            JOptionPane.showMessageDialog(null, "No hay registros de medicamentos en el inventario, no es posible crear prescripcion");
            return;
        }
        Medicacion seleccion = null;
        Prescripcion prescripcion = new Prescripcion(a);
        do{
            seleccion = (Medicacion) JOptionPane.showInputDialog(null, "Prescripción actual:\n"+prescripcion.getMedicacionesSolicitadas().leerSolicitudes("No se ha prescrito ningun medicamento.")+"\n\nCual medicamento desea prescribir:",
               "Prescripcion Actual", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                               // default
                                                                               // icon
               medicaciones, // Array of choices
               medicaciones[0]); // Initial choice

            if(seleccion == null) { break; }
            
            int cantidadPrescrita = -1;

            //Ingresar un numero entero para la cantidad de medicamentos a prescribir, el loop lo hace repetir hasta que se ingrese un numero valido
            do{
               try{
                   cantidadPrescrita = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de "+seleccion.getNombre()+" a prescribir:"));
               }
               catch(Exception ex){ cantidadPrescrita = -1; }
            }
            while(cantidadPrescrita < 0);

            Medicacion medPrescrita = new Medicacion(seleccion.getId(), seleccion.getNombre(),  seleccion.getTipo(), seleccion.getLote(), cantidadPrescrita);
            
            prescripcion.getMedicacionesSolicitadas().insertar(medPrescrita);
        }
        while(seleccion != null);

        colaDeEntregaDeMedicacion.encola(new Nodo(prescripcion));
        MostrarMenuConsultaActiva(a);
      
    }
    
    private void MostrarMenuSolicitaVacunacion(Animal a){
        Medicacion[] vacunas = inventarioMedicacion.leerInventarioDeVacunas();
        if(vacunas.length == 0){ 
            JOptionPane.showMessageDialog(null, "No hay registros de vacunas en el inventario, no es posible solicitar vacunacion");
            return;
        }
        Medicacion seleccion = null;
        Vacuna solicitudDeVacunas = new Vacuna(a);
        do{
            seleccion = (Medicacion) JOptionPane.showInputDialog(null, "Solicitud de Vacunación actual:\n"+solicitudDeVacunas.getVacunasSolicitadas().leerSolicitudes("No se ha solicitado ninguna vacuna")+"\n\nCual vacuna desea solicitar:",
               "Solicitud de Vacunación", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                               // default
                                                                               // icon
               vacunas, // Array of choices
               vacunas[0]); // Initial choice

            if(seleccion == null) { break; }
            
            Medicacion vacunaSolicitada = new Medicacion(seleccion.getId(), seleccion.getNombre(), seleccion.getTipo(),seleccion.getLote(),  1);
            
            solicitudDeVacunas.getVacunasSolicitadas().insertar(vacunaSolicitada);
        }
        while(seleccion != null);

        colaDeVacunacion.encola(new Nodo(solicitudDeVacunas));
        MostrarMenuConsultaActiva(a);
      
    }
    
    private void MostrarMenuMedicaciones(){

        String[] opciones = { "Entregar Medicación", "Vacunar Animal", "Volver" };

        opcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Medicaciones",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch(opcion){
            case 0:
                Nodo siguiente = colaDeEntregaDeMedicacion.atiende();
                
                if(siguiente == null) {
                    JOptionPane.showMessageDialog(null, "No hay prescripciones esperando entrega");
                    MostrarMenuMedicaciones();
                }
                else{
                    Prescripcion p = (Prescripcion)siguiente.getElemento();
                
                
                    JOptionPane.showMessageDialog(null, "Entregando Prescripcion a " + p.getAnimal().getNombre() + ":\n" + p.getMedicacionesSolicitadas().leerSolicitudes("No se prescribió ninguna medicación."));

                    Medicacion[] medicacionAEntregar = p.getMedicacionesSolicitadas().leerInventarioDeMedicaciones();

                    for(int i = 0; i < medicacionAEntregar.length; i++){
                        Medicacion mp = medicacionAEntregar[i];
                        Medicacion mi = inventarioMedicacion.extrae(mp.getId());
                        mi.entregarMedicacion(mp.getCantidad());
                        inventarioMedicacion.insertar(mi);
                        
                    }
                    MostrarMenuMedicaciones();
                }                
                break;
            case 1:
                Nodo siguienteVac = colaDeVacunacion.atiende();
                
                if(siguienteVac == null) {
                    JOptionPane.showMessageDialog(null, "No hay animales esperando vacunacion");
                    MostrarMenuMedicaciones();
                }
                else{
                    Vacuna v = (Vacuna)siguienteVac.getElemento();
                
                
                    JOptionPane.showMessageDialog(null, "Vacunando a " + v.getAnimal().getNombre() + ":\n" + v.getVacunasSolicitadas().leerSolicitudes("No se solicitó ninguna vacuna."));

                    Medicacion[] vacunasAplicar = v.getVacunasSolicitadas().leerInventarioDeVacunas();

                    for(int i = 0; i < vacunasAplicar.length; i++){
                        Medicacion mp = vacunasAplicar[i];
                        Medicacion mi = inventarioMedicacion.extrae(mp.getId());
                        Medicacion vacunaAplicada = mi.aplicarVacuna(mp.getCantidad());
                        if(vacunaAplicada != null){
                            pilaDeVacunasAplicadas.push(new Nodo(vacunaAplicada));
                        }
                        inventarioMedicacion.insertar(mi);
                    }
                    MostrarMenuMedicaciones();
                }
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
                Nodo siguiente = pilaDeVacunasAplicadas.pop();
                
                if(siguiente == null) {
                    JOptionPane.showMessageDialog(null, "No hay vacunas a desechar");
                    MostrarMenuInventario();
                }
                else{
                    do{
                        Medicacion v = (Medicacion)siguiente.getElemento();
           
                        JOptionPane.showMessageDialog(null, "Desechando a vacuna ya aplicada:\nNombre:" + v.getNombre() + "\nLote:" + v.getLote());
                        siguiente = pilaDeVacunasAplicadas.pop();
                    }
                    while(siguiente != null);
                    MostrarMenuInventario();
                }
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
                inventarioMedicacion.insertar(new Medicacion(proximoId()));
                MostrarMenuInventarioDeMedicación();
                break;
            case 1:
                ModificarInventarioDeMedicaciones();
                MostrarMenuInventarioDeMedicación();
                break;
            case 2:
                MostrarInventarioDeMedicaciones();
                MostrarMenuInventarioDeMedicación();
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
    
    
    private void MostrarInventarioDeMedicaciones(){
        String salida = "Inventario Actual:\n\n" + inventarioMedicacion.toString();
                
        JOptionPane.showMessageDialog(null, salida);
    }
    
    private void ModificarInventarioDeMedicaciones(){
        int idDelMedicamento = -1;
        
        //Ingresar un numero entero para la cantidad, repetir hasta que se ingrese un numero valido
        do{
            try{
                String entrada = JOptionPane.showInputDialog(null,
                        "Inventario Actual:\n\n" + 
                        inventarioMedicacion.toString() + "\n\n" +
                        "Ingrese la el ID del medicamento a modificar:");
                if(entrada == null){ return; }
                idDelMedicamento = Integer.parseInt(entrada);
            }
            catch(Exception ex){ 
                idDelMedicamento = -1; 
            }
            
            if(!inventarioMedicacion.existe(idDelMedicamento)){
                 JOptionPane.showMessageDialog(null, "Medicamento no encontrado, verifique el ID ingresado.");
                 idDelMedicamento = -1;
            }
        }
        while(idDelMedicamento == -1);
        
        Medicacion m = inventarioMedicacion.extrae(idDelMedicamento);
        
        int nuevaCantidad = -1;
        //Ingresar un numero entero para la cantidad, repetir hasta que se ingrese un numero valido
        do{
            try{
                String entrada = JOptionPane.showInputDialog(null,"Ingrese la nueva cantidad de existencias del medicamento:");
                
                if(entrada == null){ 
                    inventarioMedicacion.insertar(m);
                    return; 
                }
                nuevaCantidad = Integer.parseInt(entrada);
            }
            catch(Exception ex){ nuevaCantidad = -1; }
        }
        while(nuevaCantidad == -1);
        
        m.setCantidad(nuevaCantidad);
        
        inventarioMedicacion.insertar(m);
    }
}
