package tp3ej4;
import java.time.LocalDate;

public class Contacto{
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String numeroCel, direccion, mail;
    
    public Contacto(String nombre, String apellido, LocalDate fechaNac, String numeroCel, String direccion,
            String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.numeroCel = numeroCel;
        this.direccion = direccion;
        this.mail = mail;
    }

    public Contacto(){
        this("Agustin","Rodriguez", LocalDate.of(1998,9,18),"2262549139", "av2 y 67", "mail@ejemplo.com");
    }

    public String toString(){
        return "Nombre "+ this.getNombre() + this.getApellido() + " edad: "+ this.getEdad()+
                ", Celular: "+ this.getNumeroCel();
    }

    public String toStringCompleto(){
        return "Nombre "+ this.getNombre() + this.getApellido() + " edad: "+ this.getEdad()+
                ", Celular: "+ this.getNumeroCel()+ ", Direccion: "+ this.getDireccion()
                + ", Mail: "+this.getMail();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEdad() {
        if(pasoCumple()){
            return LocalDate.now().getYear()-fechaNac.getYear();
        } else {
            return (LocalDate.now().getYear()-fechaNac.getYear())-1;
        }
    }

    public boolean pasoCumple(){
        if(LocalDate.now().getMonthValue()<fechaNac.getMonthValue()){
            return false;
        }else if(LocalDate.now().getMonthValue()==fechaNac.getMonthValue()){
            if(LocalDate.now().getDayOfMonth()<fechaNac.getMonthValue()){
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static void main(String[] args ){
        //System.out.println("hola");
    } 


}