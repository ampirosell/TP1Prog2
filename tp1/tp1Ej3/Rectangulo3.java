package tp1Ej3;

public class Rectangulo3 { //el definitivo, el antiboludos
    private double coorX1;
    private double coorX2;
    private double coorY1;
    private double coorY2;
    private PuntoGeometrico vertice1;
    private PuntoGeometrico vertice2;
    private PuntoGeometrico vertice3;
    private PuntoGeometrico vertice4;

    public Rectangulo3(double cX1, double cX2, double cY1, double cY2){
        if(cX1<cX2){
            if(cY1<cY2){
                this.vertice1= new PuntoGeometrico(cX1,cY1);
                coorX1=cX1;
                coorY1=cY1;
                coorX2=cX2;
                coorY2=cY2;
            } else{
                this.vertice1= new PuntoGeometrico(cX1,cY2);
                coorX1=cX1;
                coorY1=cY2;
                coorX2=cX2;
                coorY2=cY1;
            }
        } else {
            if(cY1<cY2){
                this.vertice1=new PuntoGeometrico(cX2,cY1);
                coorX1=cX2;
                coorY1=cY1;
                coorX2=cX1;
                coorY2=cY2;
            } else{
                this.vertice1= new PuntoGeometrico(cX2,cY2);                
                coorX1=cX2;
                coorY1=cY2;
                coorX2=cX1;
                coorY2=cY1;
            }
        }
        this.vertice2= new PuntoGeometrico(coorX2, coorY1);
        this.vertice3 = new PuntoGeometrico(coorX2,coorY2);
        this.vertice4 = new PuntoGeometrico(coorX1, coorY2);
    }
    public Rectangulo3(PuntoGeometrico vertice, double ladoBase, double ladoAltura){
        this.vertice1=vertice;
        this.vertice2.coordenadaX=vertice1.coordenadaX+ladoBase;
        this.vertice2.coordenadaY=vertice1.coordenadaY;
        this.vertice3.coordenadaX=vertice1.coordenadaX+ladoBase;
        this.vertice3.coordenadaY=vertice1.coordenadaY+ladoAltura;
        this.vertice4.coordenadaX=vertice1.coordenadaX;
        this.vertice4.coordenadaY=vertice1.coordenadaY+ladoAltura;
    }
    
    public Rectangulo3(){
        this(0, 2, 0,2);
    }

    public String toString(){
        if(esRectangulo()){
            return "v1: "+vertice1.toString()+", v2: "+vertice2.toString()+", v3: "+
            vertice3.toString()+", v4: "+vertice4.toString();
        } else {
            return "no se puede armar el rectangulo con esas componentes, elija otras, en orden x1,x2,y1,y2.";
        }
    }

    public boolean esRectangulo() { 
        double lado1 = vertice1.distanciaEuclidea(vertice2);
        double lado2 = vertice2.distanciaEuclidea(vertice3);
        double lado3 = vertice3.distanciaEuclidea(vertice4);
        double lado4 = vertice4.distanciaEuclidea(vertice1);

        double diagonal1 = vertice1.distanciaEuclidea(vertice3);
        double diagonal2 = vertice2.distanciaEuclidea(vertice4);

        return lado1 == lado3 && lado2 == lado4 && diagonal1 == diagonal2;
    }

    public boolean esCuadrado(){ 
        double lado1 = vertice1.distanciaEuclidea(vertice2);
        double lado2 = vertice2.distanciaEuclidea(vertice3);
        double lado3 = vertice3.distanciaEuclidea(vertice4);
        double lado4 = vertice4.distanciaEuclidea(vertice1);

        double diagonal1 = vertice1.distanciaEuclidea(vertice3);
        double diagonal2 = vertice2.distanciaEuclidea(vertice4);

        return lado1 == lado3 && lado2 == lado4 &&
                lado1==lado2 && lado3==lado4 && diagonal1 == diagonal2;
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

    public double area(){ 
        if(esRectangulo()){
            double base = vertice1.distanciaEuclidea(vertice2);
            double altura = vertice2.distanciaEuclidea(vertice3);
            return base*altura;
        }else{
            return -1;
        }
    }

    /*● Compararlo con otro rectángulo. Devolver 1 si el rectángulo es mayor, 0 si son
    iguales y -1 si es menor. Se dice que un rectángulo es mayor que otro si el área
    del mismo es mayor que la del otro.*/
    public int comparaTamanio(Rectangulo3 recto){
        int comparacion=3;
        double a1=this.area();
        double a2=recto.area();
        if(a1<a2){
            comparacion=-1;
        } else if (a1==a2){
            comparacion=0;
        } else {
            comparacion=1;
        }
        return comparacion;
    }

    /*● Determinar si está acostado o parado (si el alto es más que el ancho).  */ 
    public boolean esHorizontal(){
        double lado1 = vertice1.distanciaEuclidea(vertice2);
        double lado2 = vertice2.distanciaEuclidea(vertice3);
        if (lado1<lado2){
            return false;
        } else {
            return true;
        }
    }

    //● Determinar el largo del lado superior.
    public double ladoSuperior(){
        return vertice3.distanciaEuclidea(vertice4);
    }


    public static void main (String[] args){

        Rectangulo3 recti =new Rectangulo3(-3,15,5,9);
        System.out.println("primer rectangulo: "+recti.toString());
        Rectangulo3 recto = new Rectangulo3();
        System.out.println("Segundo rectangulo: "+recto.toString()+". Ahora lo desplazamos: ");
        recto.desplazamiento(2.5,-3);
        System.out.println(recto.toString());
        System.out.println("Areas: R1:"+recti.area()+", R2: "+recto.area());
        if(recti.esRectangulo()&&recto.esRectangulo()){
            int comp=recti.comparaTamanio(recto);
            if(comp==-1){
                System.out.println("Rectangulo 1 es MENOR a rect.2");
            } else if(comp==0){
                System.out.println("Rectangulo 1 es IGUAL a rect.2");
            } else if(comp==1){
                System.out.println("Rectangulo 1 es MAYOR a rect.2");
            }
        }
    }        
}
