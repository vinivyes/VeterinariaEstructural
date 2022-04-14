/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

/**
 *
 * @author Vinicius
 */
public class Vacuna {
    private ListaDobleCircular vacunasSolicitadas = new ListaDobleCircular();
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
    
    public Vacuna(Animal _animal){
        animal = _animal;
    }
        
    public ListaDobleCircular getVacunasSolicitadas() {
        return vacunasSolicitadas;
    }

}
