package tp3ej4;

import java.util.ArrayList;
import java.util.List;

public class Celular{
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    public Celular(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    public Celular(){
        this((ArrayList<Contacto>) List.of(new Contacto() , new Contacto() ));
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    
    
    
}