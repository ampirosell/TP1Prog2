package TP1Prog2.tp2.tp2Ej2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reunion {
    private String lugar;
    private Contacto[] integrantes= new Contacto[4];
    private String temario;
    private LocalDate diaInicio;    
    private LocalDate diaFin;
    private LocalTime horaInicio ;
    private LocalTime horaFin;

    public Reunion (String lugar, Contacto[] integrantes, String temario, LocalDate diaI, LocalDate diaF, LocalTime horaInicio, LocalTime horaFin){
        //controlo aca si se pisan?
        this.lugar=lugar;
        this.integrantes=integrantes;
        this.temario=temario;
        if (diaI.isAfter(diaF)){
        this.diaInicio=diaI;
        this.diaFin=diaI;
        }else{
            this.diaInicio=diaI;
            this.diaFin=diaF;
        }
        this.horaInicio=horaInicio;
        this.horaFin=horaFin; 
    }
    public Reunion (String lugar, Contacto[] integrantes, String temario, LocalDate diaI, LocalDate diaF, LocalTime horaInicio){
        this(lugar, integrantes, temario, diaI, diaF, horaInicio, (horaInicio.plusMinutes(30)));
    }
    public Reunion (String lugar, Contacto[] integrantes, String temario, LocalDate diaI, LocalDate diaF){
        this(lugar, integrantes, temario, diaI, diaF, LocalTime.of(8,0,0,0), LocalTime.of(8,30,0,0));
    }
    public Reunion (String lugar, Contacto[] integrantes, String temario, LocalDate diaI){
        this(lugar, integrantes, temario, diaI, diaI, LocalTime.of(8,0,0,0), LocalTime.of(8,30,0,0));
    }
    public Reunion (String lugar, Contacto[] integrantes, LocalDate diaI){
        this(lugar, integrantes, "Reunion importante", diaI, diaI, LocalTime.of(8,0,0,0), LocalTime.of(8,30,0,0));
    }
    public Reunion ( Contacto[] integrantes, LocalDate diaI){
        this("Oficina", integrantes,"Reunion importante", diaI, diaI, LocalTime.of(8,0,0,0), LocalTime.of(8,30,0,0));
    }
    public String toString(){
        String nomIntegrantes="";
        for(int i=0;i<integrantes.length;i++){
            nomIntegrantes= nomIntegrantes +", "+integrantes[i].getNombre();
        }
        if (diaInicio.equals(diaFin)){
            return "Lugar a realizar: "+lugar+"; Integrantes: "+nomIntegrantes+
            "; Temas: "+temario+
            "; Dia reunion: "+diaInicio+", hora de inicio: "+horaInicio+
            ", hora finalizacion: "+horaFin; 
        }
        else {
            return "Lugar a realizar: "+lugar+"; Integrantes: "+nomIntegrantes+
            "; Temas: "+temario+
            "; Dia de inicio: "+diaInicio+", hora de inicio: "+horaInicio+"; Dia finalizacion: "+
            diaFin+", hora finalizacion: "+horaFin; 
        }
    }
    public boolean sePisanReuniones(Reunion rOtra){ //como calculo? como recorro las demas?
        boolean mismoDia=this.diaInicio.equals(rOtra.diaInicio);
        if (mismoDia){
            if(horaInicio.isAfter(rOtra.horaInicio)){
                if(horaInicio.isAfter(rOtra.horaFin)){
                    return false;
                } else{
                    return true;
                }
            } else if(horaFin. isAfter(rOtra.horaInicio)){
                return true;
            } else if(horaFin.isBefore(rOtra.horaInicio)){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
        //todavia en proceso... creo

    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Contacto[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Contacto[] integrantes) {
        this.integrantes = integrantes;
    }

    public String getTemario() {
        return temario;
    }

    public void setTemario(String temario) {
        this.temario = temario;
    }

    public LocalDate getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(LocalDate diaInicio) {
        this.diaInicio = diaInicio;
    }

    public LocalDate getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(LocalDate diaFin) {
        this.diaFin = diaFin;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime inicio) {
        this.horaInicio = inicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime fin) {
        this.horaFin = fin;
    }

    public String getDuracion(){
        Duration duracionIntervalo = Duration.between(horaInicio,horaFin);
        long horas = duracionIntervalo.toHours();
        long minutos = duracionIntervalo.toMinutesPart();    
        return("Duración de la reunion: " + horas + " horas y " + minutos + " minutos.");
    }
    


}
