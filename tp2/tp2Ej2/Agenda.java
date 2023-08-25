package TP1Prog2.tp2.tp2Ej2;
import java.time.LocalDate;
import java.time.LocalTime;

/*Una agenda personal permite registrar reuniones en las que el usuario va a participar. En
tal agenda debe registrarse dónde ocurrirá la reunión, quienes van a participar de ella, el
tema que van a tratar y la duración de la misma. Asimismo, deben registrarse lo
contactos telefónicos y mail de los asistentes */

public class Agenda{

    public void toString(Contacto c){
        System.out.println( "Nombre completo: "+c.getNombre()+
        ", celular: "+c.getCelular()+", mail: "+c.getMail());
    }
    public void toString(Reunion r){
        String nomIntegrantes="";
        Contacto[] integrantes=r.getIntegrantes();
        LocalDate diaInicio=r.getDiaInicio();
        LocalDate diaFin=r.getDiaFin();
        String lugar = r.getLugar();
        String temario = r.getTemario();
        LocalTime horaInicio =r.getHoraInicio();
        LocalTime horaFin= r.getHoraFin();
        String duracion=r.getDuracion();
        for(int i=0;i<integrantes.length;i++){
            nomIntegrantes= nomIntegrantes +", "+integrantes[i].getNombre();
        }
        if (diaInicio.equals(diaFin)){
            System.out.println( "Lugar a realizar: "+lugar+"; Integrantes: "+nomIntegrantes+
            "; Temas: "+temario+
            "; Dia reunion: "+diaInicio+", hora de inicio: "+horaInicio+
            ", hora finalizacion: "+horaFin+", "+duracion); 
        }
        else {
            System.out.println( "Lugar a realizar: "+lugar+"; Integrantes: "+nomIntegrantes+
            "; Temas: "+temario+
            "; Dia de inicio: "+diaInicio+", hora de inicio: "+horaInicio+"; Dia finalizacion: "+
            diaFin+", hora finalizacion: "+horaFin+", "+duracion); 
        }
    }


    public static void main (String [ ] args){
        Agenda agenda = new Agenda();
        Contacto asistente1= new Contacto("pepe", "argento", 10,"pepe@argmail.com");
        Contacto asistente2= new Contacto("dnjkef", "yankee", 11,"pepe@argmail.com");
        Contacto[] integrantes =new Contacto[2];
        integrantes[0]=asistente1;
        integrantes[1]=asistente2;
        Reunion reunion = new Reunion("Oficina av2", integrantes, "muchos muchos temas...", LocalDate.now(), LocalDate.now(), LocalTime.of(11,0,0), LocalTime.of(13,0,0));
        Reunion reunion2= new Reunion("Necochea", integrantes, "kjdfehjrbfebow", LocalDate.of(2023,8,25),LocalDate.of(2023,8,25),LocalTime.of(12,0,0),LocalTime.of(13,30,0));
        agenda.toString(reunion2);

        agenda.toString(reunion);
        //System.out.println(reunion.sePisanReuniones(reunion2));
    }

}