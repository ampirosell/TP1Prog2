package TP1Prog2.tp2.tp2Ej1;

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
        this.lugar=lugar;
        this.integrantes=integrantes;
        this.temario=temario;
        this.diaInicio=diaI;
        this.diaFin=diaF;
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
    public String reunionToString(){
        String[] nomIntegrantes = new String[integrantes.length];
        for(int i=0;i<integrantes.length;i++){
            nomIntegrantes[i]=integrantes[i].getNombre();
        }
        return "Lugar a realizar: "+lugar+", Integrantes: "+nomIntegrantes+
        ", Temas: "+temario+
        ", Dia de inicio: "+diaInicio+", Hora de inicio: "+horaInicio+", Dia finalizacion: "+
        diaFin+", Hora finalizacion: "+horaFin; 
    }
    public void sePisanReuniones(){ //como calculo?
        //todavia en proceso...

    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /*public Contacto[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Contacto[] integrantes) {
        this.integrantes = integrantes;
    }*/

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
    


}
