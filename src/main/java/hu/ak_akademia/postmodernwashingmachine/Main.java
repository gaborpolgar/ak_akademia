package hu.ak_akademia.postmodernwashingmachine;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    PostModernWashingMachine machine = new PostModernWashingMachine();
    Clothes ing = new Shirt("Etherna ing", Color.COLORFUL, 20);
        System.out.println(ing);
    Clothes levis = new Trouser("farmernadrág", Color.COLORFUL, 10);
        System.out.println(levis);
    Clothes boxer = new Underwear("boxeralsó", Color.COLORFUL, 30);
        System.out.println(boxer);
    machine.switchOn();
    machine.openDoor();
    machine.load(levis, boxer, ing);
    machine.close();
    machine.startWash();
    machine.dry();
    machine.iron();
    machine.openDoor();
    List<Clothes> doneClothes = machine.unload();
    machine.switchOff();
    doneClothes.toString();
    }
}
