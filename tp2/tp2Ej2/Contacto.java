package TP1Prog2.tp2.tp2Ej1;

public class Contacto {
    private String nombre;
    private String apellido;
    private int celular; //aunque deberia ser un big int pero mejor tomemos precaucion con la memoria
    private String mail;

    public Contacto(String nNombre, String nApellido, int nCelular, String nMail){
        this.setNombre(nNombre);
        this.setApellido(nApellido);
        this.setCelular(nCelular);
        this.setMail(nMail);
    }
    public Contacto(String nNombre, String nApellido, int nCelular){
        this(nNombre,nApellido,nCelular,"example@example.com");
    }
    public Contacto(String nNombre, String nApellido, String nMail){
        this(nNombre,nApellido,001,nMail);
    }
    public Contacto(String nNombre, int nCelular){
        this(nNombre," ",nCelular,"example@example.com");
    }
    public Contacto(String nNombre, String nMail){
        this(nNombre," ",001,nMail);
    }
    public Contacto(String nNombre){
        this(nNombre," ",001,"example@example.com");
    }
    public Contacto(){
        this("nNombre"," ",001,"example@example.com");
    }
    public String toString(){
        return "Nombre completo: "+nombre+apellido+
        ", celular: "+celular+", mail: "+mail;
    }
    public String getNombre() {
        return nombre+" "+apellido;
    }

    public int getCelular() {
        return celular;
    }

    public String getMail() {
        return mail;
    }

    public void setNombre(String nNombre) {
        this.nombre = nNombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
