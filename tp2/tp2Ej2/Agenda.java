package TP1Prog2.tp2.tp2Ej2;
import java.time.LocalDate;
import java.time.LocalTime;

/*Una agenda personal permite registrar reuniones en las que el usuario va a participar. En
tal agenda debe registrarse dónde ocurrirá la reunión, quienes van a participar de ella, el
tema que van a tratar y la duración de la misma. Asimismo, deben registrarse lo
contactos telefónicos y mail de los asistentes */

public class Agenda{
    /*private Reunion reunion;
    private Contacto asistente;
    */
    //no entiendo esta logica, debe tener un constructor o solo main?


    public static void main (String [ ] args){
        Contacto asistente1= new Contacto("pepe", "argento", 10,"pepe@argmail.com");
        Contacto asistente2= new Contacto("dnjkef", "yankee", 11,"pepe@argmail.com");
        Contacto[] integrantes =new Contacto[2];
        integrantes[0]=asistente1;
        integrantes[1]=asistente2;
        Reunion reunion = new Reunion("Oficina av2", integrantes, "muchos muchos temas...", LocalDate.now(), LocalDate.now(), LocalTime.of(11,0,0), LocalTime.of(13,0,0));
        System.out.println(reunion.toString());
        Reunion reunion2= new Reunion("Necochea", integrantes, "kjdfehjrbfebow", LocalDate.of(2023,8,25),LocalDate.of(2023,8,25),LocalTime.of(12,0,0),LocalTime.of(13,30,0));
        System.out.println(reunion.sePisanReuniones(reunion2));
    }

}