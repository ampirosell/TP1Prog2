package tp1Ej3;
public class Rectangulo {
    private PuntoGeometrico vertice1;
    private PuntoGeometrico vertice2;
    private PuntoGeometrico vertice3;
    private PuntoGeometrico vertice4;
    
    
    // por favor poner en orden los vertices!
    public Rectangulo(PuntoGeometrico vertice1, PuntoGeometrico vertice2, PuntoGeometrico vertice3, PuntoGeometrico vertice4) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        this.vertice4 = vertice4;
    }

    public boolean esRectangulo() { //que pasa si los subieron desordenados? aca funciona igual, porque las diagonales deben ser las mismas
        double lado1 = vertice1.distanciaEuclidea(vertice2);
        double lado2 = vertice2.distanciaEuclidea(vertice3);
        double lado3 = vertice3.distanciaEuclidea(vertice4);
        double lado4 = vertice4.distanciaEuclidea(vertice1);

        double diagonal1 = vertice1.distanciaEuclidea(vertice3);
        double diagonal2 = vertice2.distanciaEuclidea(vertice4);

        return lado1 == lado3 && lado2 == lado4 && diagonal1 == diagonal2;
    }
    public boolean esCuadrado(){ //que pasa si los subieron desordenados? aca no funciona igual...
        double lado1 = vertice1.distanciaEuclidea(vertice2);
        double lado2 = vertice2.distanciaEuclidea(vertice3);
        double lado3 = vertice3.distanciaEuclidea(vertice4);
        double lado4 = vertice4.distanciaEuclidea(vertice1);

        double diagonal1 = vertice1.distanciaEuclidea(vertice3);
        double diagonal2 = vertice2.distanciaEuclidea(vertice4);

        return lado1 == lado3 && lado2 == lado4 &&
                lado1==lado2 && lado3==lado4 && diagonal1 == diagonal2;
    }
    
    public String toString(){
        return "v1: "+vertice1.toString()+", v2: "+vertice2.toString()+", v3: "+
                vertice3.toString()+", v4: "+vertice4.toString();
    }

    public PuntoGeometrico getVertice1() {
        return vertice1;
    }

    public void setVertice1(PuntoGeometrico vertice1) {
        this.vertice1 = vertice1;
    }

    public PuntoGeometrico getVertice2() {
        return vertice2;
    }

    public void setVertice2(PuntoGeometrico vertice2) {
        this.vertice2 = vertice2;
    }

    public PuntoGeometrico getVertice3() {
        return vertice3;
    }

    public void setVertice3(PuntoGeometrico vertice3) {
        this.vertice3 = vertice3;
    }

    public PuntoGeometrico getVertice4() {
        return vertice4;
    }

    public void setVertice4(PuntoGeometrico vertice4) {
        this.vertice4 = vertice4;
    }

    public void desplazamiento(double dX, double dY){
        this.vertice1.coordenadaX+=dX;
        this.vertice2.coordenadaX+=dX;            
        this.vertice3.coordenadaX+=dX;            
        this.vertice4.coordenadaX+=dX;            

        this.vertice1.coordenadaY+=dY;
        this.vertice2.coordenadaY+=dY;                        
        this.vertice3.coordenadaY+=dY;                        
        this.vertice4.coordenadaY+=dY;                        
    }

    public double area(){ //suponiendo que siguen en orden los vertices
        double base = vertice1.distanciaEuclidea(vertice2);
        double altura = vertice2.distanciaEuclidea(vertice3);
        return base*altura;
    }
    /*● Compararlo con otro rectángulo. Devolver 1 si el rectángulo es mayor, 0 si son
    iguales y -1 si es menor. Se dice que un rectángulo es mayor que otro si el área
    del mismo es mayor que la del otro.*/
    public int comparaTamanio(Rectangulo rOtro){
        int comparacion=3;
        double a1=this.area();
        double a2=rOtro.area();
        if(a1<a2){
            comparacion=-1;
        } else if (a1==a2){
            comparacion=0;
        } else {
            comparacion=1;
        }
        return comparacion;
    }


    public static void main (String [] args){
        PuntoGeometrico v1 = new PuntoGeometrico(-1,-2);
        PuntoGeometrico v2 = new PuntoGeometrico(1,-2);
        PuntoGeometrico v3 = new PuntoGeometrico(1,4);
        PuntoGeometrico v4 = new PuntoGeometrico(-1,4);

        Rectangulo rec = new Rectangulo(v1, v2, v3, v4);

        PuntoGeometrico v5 = new PuntoGeometrico(-1,-1);
        PuntoGeometrico v6 = new PuntoGeometrico(1,-1);
        PuntoGeometrico v7 = new PuntoGeometrico(1,1);
        PuntoGeometrico v8 = new PuntoGeometrico(-1,1);

        Rectangulo rec2 = new Rectangulo(v5, v6, v7, v8);

        System.out.println("se puede armar el primer rectangulo? "+rec.esRectangulo());
        if(rec.esRectangulo()){
            System.out.println("area del rectangulo 1: "+rec.area());
            System.out.println("es cuadrado? "+rec.esCuadrado());

        }
        System.out.println("se puede armar el segundo rectangulo? "+rec2.esRectangulo());
        if(rec2.esRectangulo()){
            System.out.println("area del rectangulo 2: "+rec2.area());
            System.out.println("es cuadrado? "+rec2.esCuadrado());

        }
        if (rec.esRectangulo()&&rec2.esRectangulo()){
            int comp=rec.comparaTamanio(rec2);
            if(comp==-1){
                System.out.println("el rectangulo de vertices "+rec.toString()+" es MENOR que el segundo rectangulo, de vertices "+rec2.toString());
            } else if(comp==0){
                System.out.println("el rectangulo de vertices "+rec.toString()+" es IGUAL que el segundo rectangulo, de vertices "+rec2.toString());
            }else if(comp==1){
                System.out.println("el rectangulo de vertices "+rec.toString()+" es MAYOR que el segundo rectangulo, de vertices "+rec2.toString());
            }
        }
        rec.desplazamiento(1, 2);
        System.out.println("rectangulo 1 desplazado: "+rec.toString());
        System.out.println("se puede armar el primer rectangulo? "+rec.esRectangulo());
        if(rec.esRectangulo()){
            System.out.println("area del rectangulo 1: "+rec.area());
            System.out.println("es cuadrado? "+rec.esCuadrado());


        }

    }
}
//● Determinar el largo del lado superior. ACA LA CAGUE LO HICE CON OTRA LOGICA, CAMBIAR TODO A LADOS?




/*● Determinar si está acostado o parado (si el alto es más que el ancho).  */ //idem.




/* 
● Determinar si el rectángulo es un cuadrado, es decir, decidir si se cumplen las
propiedades para que sea un cuadrado.*/