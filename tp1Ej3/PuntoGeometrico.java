package tp1Ej3;

public class PuntoGeometrico {
    double coordenadaX;
    double coordenadaY;

    public PuntoGeometrico(double x, double y){
        coordenadaX=x;
        coordenadaY=y;
    }
    public PuntoGeometrico(){
        this(0,0);
    }
    public String toString(){
        return "( "+coordenadaX+" ; "+coordenadaY+" )";
    }
    public double getCoordenadaX() {
        return coordenadaX;
    }
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    public double getCoordenadaY() {
        return coordenadaY;
    }
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public void desplazamiento(double increX, double increY){
        coordenadaX += increX;
        coordenadaY += increY;

    }

    public double distanciaEuclidea(PuntoGeometrico pOtro){
        return( Math.sqrt(Math.pow(this.coordenadaX-pOtro.coordenadaX,2)+Math.pow(this.coordenadaY-pOtro.coordenadaY,2)) );
    }
    
    public static void main (String [] args){
        PuntoGeometrico p1= new PuntoGeometrico();
        p1.desplazamiento(4, -3);
        System.out.println("Punto1: "+p1.toString());

        PuntoGeometrico p2 = new PuntoGeometrico(-6.3,0.25);
        System.out.println("Punto2: "+p2.toString());
        System.out.println("----------------");
        double distancia=p1.distanciaEuclidea(p2);
        System.out.println("distancia euclidea entre ambos puntos: "+distancia);

    }
}