package tp1Ej2;

public class Electrodomestico {
    String nombre;
    double precioBase;
    String color;
    double consumoEnergetico;
    double peso;
    public Electrodomestico(String nombre, double precioBase,String color,
                            double consumoEnergetico,double peso){
        this.nombre=nombre;
        this.precioBase=precioBase;
        this.color=color;
        this.consumoEnergetico=consumoEnergetico;
        this.peso=peso;
    }
    public String toString() {
        return "Nombre: "+nombre+", Precio base: " + precioBase+ ", Color: " + color +", Consumo energetico: "+consumoEnergetico+" Kw, Peso: "+peso+" Kg";
    }
    public Electrodomestico(String nn){
        this(nn,100,"Gris plata",10,2);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }
    public void setConsumoEnergetico(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String bajoConsumo(){ //podria ser un boolean para reutilizar codigo, pero ahora me conviene esto
        String es;
        int consumoMax=45;
        if(consumoEnergetico>consumoMax){
            es="El consumo energetico es mayor a "+consumoMax+" Kw, no es bajo consumo.";
        } else if(consumoMax==consumoEnergetico){
            es="El consumo energetico es igual a "+consumoMax+" Kw, esta en el limite del bajo consumo.";
        } else {
            es="Su electrodomestico es de bajo consumo, ya que no supera los "+consumoMax+" Kw.";
        }
        return es;
    }
    public double balance(){
        return precioBase/peso;
    }
    public String gama(){
        if(balance()>3){
            return "alta";
        }
        else {
            return "baja";
        }
    }
    /*● Comprobar si el electrodoméstico es de bajo consumo (menor que 45 Kw)   
● Calcular el balance, el mismo es el resultado de dividir el costo por el peso
● Indicar si un producto es de alta gama, el balance es mayor que 3 */    
    public static void main (String [] args){
        Electrodomestico elec = new Electrodomestico("lavarropas", 20, "azul", 15, 10);
        System.out.println(elec.toString());
        System.out.println(elec.bajoConsumo());
        System.out.println("Balance: "+elec.balance());
        System.out.println("Su producto es de gama "+elec.gama());

        System.out.println("------------");

        
        Electrodomestico elec2 = new Electrodomestico("microondas", 500, "negro", 60, 3.5);
        System.out.println(elec2.toString());        
        System.out.println(elec2.bajoConsumo());
        System.out.println("Balance: "+elec2.balance());
        System.out.println("Su producto es de gama "+elec2.gama());

    }

}