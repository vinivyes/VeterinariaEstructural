/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaestructural;

/**
 *
 * @author Administrator
 */
public class Prescripcion {
    private ListaDobleCircular medicacionesSolicitadas = new ListaDobleCircular();
    private Animal animal;
    
    public Prescripcion(Animal _animal){
        animal = _animal;
    }
    
    public ListaDobleCircular getMedicacionesSolicitadas() {
        return medicacionesSolicitadas;
    }

    public void setMedicacionesSolicitadas(ListaDobleCircular medicacionesSolicitadas) {
        this.medicacionesSolicitadas = medicacionesSolicitadas;
    }

    public Animal getAnimal() {
        return animal;
    }
    
}
