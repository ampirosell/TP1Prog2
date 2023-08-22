import java.time.LocalDate;

public class Persona {
    private String nombre; //no me deja inicializar desde aca
    private String apellido;
    private LocalDate fechaNac= LocalDate.of(2000,1,1);
    private int dni;
    private char sexo;
    private int peso;
    private double altura;
    
    public Persona(int nDni){
        this(nDni, "N", "N", LocalDate.of(2000,1,1),'F', 1, 1);
    }
    
    public Persona(int nDni, String nNombre, String nApellido, LocalDate nFechaNac, char nSexo,
    int nPeso, double nAltura){
        this.dni=nDni;
        nombre=nNombre;
        apellido=nApellido;
        fechaNac=nFechaNac;
        sexo=nSexo;
        peso=nPeso;        
        altura=nAltura;
    }
    public String toString() {
        return "DNI: "+dni+", Nombre: " + nombre+ " " +apellido+ ", Edad: " + getEdad()+", Fecha de nacimiento: "+fechaNac+
                ", Sexo: "+sexo+", Peso: "+peso+", Altura: "+altura;
    }
    public Persona(int nDni, String nNombre, String nApellido){
        this(nDni,nNombre,nApellido, LocalDate.of(2000,1,1),'F', 1, 1);
    }

    public Persona(int nDni, String nNombre, String nApellido, LocalDate nFechaNac){
        this(nDni,nNombre,nApellido,nFechaNac,'F', 1, 1);

    }
    public Persona(int nDni, String nNombre, String nApellido, LocalDate nFechaNac, char nSexo){
        this(nDni,nNombre,nApellido, nFechaNac, nSexo, 1, 1);
    }

    
    public Persona(int nDni, String nNombre, String nApellido, LocalDate nFechaNac, char nSexo, int nPeso){
        this(nDni,nNombre,nApellido, nFechaNac, nSexo, nPeso, 1);
    }
    
    public Persona(int nDni, String nNombre, String nApellido, LocalDate nFechaNac, char nSexo, double nAltura){
        this(nDni,nNombre,nApellido, nFechaNac, nSexo, 1,nAltura);
    }

    public int getDni(){
        return this.dni;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nN){
        this.nombre=nN;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac(){
        return this.fechaNac;
    }
    
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public void setFechaNac(String nN){
        this.nombre=nN;
    }
    
    public int getEdad(){
        int edad=0;
        boolean pasoCumple=pasoCumple();
        if(pasoCumple){
            edad=LocalDate.now().getYear()-this.fechaNac.getYear();
        } else {
            edad= LocalDate.now().getYear()-this.fechaNac.getYear()-1;
        }
        return edad;
    }
    
    private boolean pasoCumple(){
        //boolean paso=false;
        LocalDate hoy= LocalDate.now();
        if (fechaNac.getMonthValue() >hoy.getMonthValue()){
            //paso=false;
            return false;
        } else if(hoy.getMonthValue() > fechaNac.getMonthValue()){
                return true;
        }
        else{
            if(fechaNac.getDayOfMonth() > hoy.getDayOfMonth()){
                return false;
            }
            else {   
                return true;
            }
        }
    }
    
    /*  ● Saber si está cumpliendo años.*/
    public String esCumple(){
        String es;
        int hoyMes=LocalDate.now().getMonthValue();
        int hoyDia=LocalDate.now().getDayOfMonth();
        if(hoyMes==fechaNac.getMonthValue()&&hoyDia==fechaNac.getDayOfMonth()){
            es="FELIZ CUMPLEAÑOS!";
        }
        else{
            es="Feliz feliz no cumpleaños";
        }
        return es;
    }
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    /*   Cálculo del índice de masa Corporal. Una persona sabe calcular cuál es su índice
        de masa corporal el cual es peso / altura2*/
    public double IMC(){
        double imc=0;
        if(peso>0&&altura>0){
            imc=peso/(altura*altura);
        }
        return imc;
    }   
    /*  ● Saber si está en forma. Está en forma si el índice de masa corporal se encuentra
        entre 18,5 y 25 (esto es solo un ejemplo para probar la funcionalidad).*/
    public String estaEnForma(){
        String estado;
        double imc=IMC();
        if(imc<18.5){
            estado="Esta debajo del nivel saludable";
        }else{
            if(imc>25){
                estado="Esta por sobre el nivel óptimo saludable";
            }
            else{
                estado="Usted es saludable";
            }
        }
        return estado;
    }

    /*  ● Saber si es mayor de edad. Una persona es mayor de edad si es mayor de 18
        años*/
    public boolean esMayor(int minimo){
        int edad=getEdad();
        boolean es;
        if(edad>=minimo){
            es=true;
        }
        else
            es=false;
        return es;
    }
    
    public static void main (String[]args){
        
    Persona per1 =new Persona(36256666, "Maria Elena", "Fuseneco", LocalDate.of(1990,8,20), 'F', 55, 1.65);        
    System.out.println("Indice de masa corporal: "+per1.IMC());
    System.out.println(per1.estaEnForma());
    System.out.println(per1.esCumple());
    System.out.println("es mayor de 18? "+per1.esMayor(18));
    System.out.println("puede votar? "+per1.esMayor(16));
    System.out.println(per1.toString());    

    System.out.println("--------------");
    
    Persona per2 = new Persona (5626654, "Maria Juana", "Lopez", LocalDate.of(1998,4,8), 'M', 68, 1.75);
    System.out.println("Indice de masa corporal: "+per2.IMC());
    System.out.println(per2.estaEnForma());
    System.out.println(per2.esCumple());
    System.out.println("es mayor de 18? "+per2.esMayor(18));
    System.out.println("puede votar? "+per2.esMayor(16));
    System.out.println(per2.toString());
    }
}
/*● Saber si es coherente. Que la fecha de nacimiento coincida con la edad.      COMO? no es redundante???*/
   





/*● Mostrar toda la información del objeto. Es decir devolver un String con la
información del mismo.
● Métodos set de cada parámetro, excepto de DNI.
● Saber si puede votar. Es necesario ser mayor de 16 años.*/