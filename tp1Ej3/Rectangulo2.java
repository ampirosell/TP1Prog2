package tp1Ej3;
//estas son soluciones de programa para cualquier rectángulo, no estudiado paralelo a los ejes, sino por elementos, lados vertices, diagonales.
public class Rectangulo2 {
    
    private PuntoGeometrico[] lado1 = new PuntoGeometrico[2];
    private PuntoGeometrico[] lado2 = new PuntoGeometrico[2];   
    private PuntoGeometrico[] lado3 = new PuntoGeometrico[2];   
    private PuntoGeometrico[] lado4 = new PuntoGeometrico[2];   
    
    //de nuevo se necesita subir en orden
    public Rectangulo2 (PuntoGeometrico vertice1, PuntoGeometrico vertice2, PuntoGeometrico vertice3, PuntoGeometrico vertice4){
        //como controlar cual x es menor a las demas y cual y es menor a las demas?
        
        this.lado1[0]=vertice1;
        this.lado1[1]=vertice2;
        this.lado2[0]=vertice2;
        this.lado2[1]=vertice3;
        this.lado3[0]=vertice3;
        this.lado3[1]=vertice4;
        this.lado4[0]=vertice4;
        this.lado4[1]=vertice1;
    }

    public Rectangulo2(){ //por defecto, y es cuadrado
        this.lado1[0]= new PuntoGeometrico(0,0);
        this.lado1[1]= new PuntoGeometrico(2,0);
        this.lado2[0]= new PuntoGeometrico(2,0);
        this.lado2[1]= new PuntoGeometrico(2,2);
        this.lado3[0]= new PuntoGeometrico(2,2);
        this.lado3[1]= new PuntoGeometrico(0,2);
        this.lado4[0]= new PuntoGeometrico(0,2);
        this.lado4[1]= new PuntoGeometrico(0,0);
    }
    
    public String toString(){
        return "lado 1: parte de "+lado1[0].toString()+" al punto "+lado1[1].toString()
                +", lado2: parte de "+lado2[0].toString()+" al punto "+lado2[1].toString()
                +", lado3: parte de "+lado3[0].toString()+" al punto "+lado3[1].toString()
                +", lado4: parte de "+lado4[0].toString()+" al punto "+lado4[1].toString();
    }
    
    public boolean esRectangulo() { //que pasa si los subieron desordenados? aca funciona igual, porque las diagonales deben ser las mismas.
        //FUNCIONA PERO NO DEBERIA FUNCIONAR IGUAL SI ME LOS PONEN DESORDENADOS PORQUE LA LOGICA LA RECORRE MAL
        double mLado1= lado1[0].distanciaEuclidea(lado1[1]);
        double mLado2= lado2[0].distanciaEuclidea(lado2[1]);
        double mLado3= lado3[0].distanciaEuclidea(lado3[1]);
        double mLado4= lado4[0].distanciaEuclidea(lado4[1]);
        
        double diagonal1 = lado1[0].distanciaEuclidea(lado2[1]); //tamb podia ser lado4 sub1 y lado 3 sub 0
        double diagonal2 = lado1[1].distanciaEuclidea(lado4[0]);
        
        return mLado1 == mLado3 && mLado2 == mLado4 && diagonal1 == diagonal2;
    }
    
    public boolean esCuadrado(){ //que pasa si los subieron desordenados? aca no funciona igual...
        double mLado1= lado1[0].distanciaEuclidea(lado1[1]);
        double mLado2= lado2[0].distanciaEuclidea(lado2[1]);
        double mLado3= lado3[0].distanciaEuclidea(lado3[1]);
        double mLado4= lado4[0].distanciaEuclidea(lado4[1]);
        
        double diagonal1 = lado1[0].distanciaEuclidea(lado2[1]); //tamb podia ser lado4 sub1 y lado 3 sub 0
        double diagonal2 = lado1[1].distanciaEuclidea(lado4[0]);
        return mLado1 == mLado3 && mLado2 == mLado4 && mLado1==mLado2 && mLado3 == mLado4 && diagonal1 == diagonal2;
    }
    
    public void desplazamiento(double dX, double dY){
        lado1[0].desplazamiento(dX, dY);
        lado2[0].desplazamiento(dX, dY);
        lado3[0].desplazamiento(dX, dY);
        lado4[0].desplazamiento(dX, dY);
    }
    
    public double area(){ //suponiendo que siguen en orden los vertices
        double mLado1= lado1[0].distanciaEuclidea(lado1[1]);
        double mLado2= lado2[0].distanciaEuclidea(lado2[1]);
        return mLado1*mLado2;
    }
    /* ● Compararlo con otro rectángulo. Devolver 1 si el rectángulo es mayor, 0 si son
    iguales y -1 si es menor. Se dice que un rectángulo es mayor que otro si el área
    del mismo es mayor que la del otro.*/
    public int comparaTamanio(Rectangulo2 rOtro){
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
//● Determinar el largo del lado superior. ACA LA CAGUE LO HICE CON OTRA LOGICA, CAMBIAR TODO A LADOS?




/*● Determinar si está acostado o parado (si el alto es más que el ancho).  */ //idem.
    /*public boolean esHorizontal(){
        for (PuntoGeometrico[] vertices : lado1[0]) {
a            
            
        }
    }*/

    public PuntoGeometrico[] getLado1() {
        return lado1;
    }

    public void setLado1(PuntoGeometrico[] lado1) {
        this.lado1 = lado1;
    }

    public void setLado1(PuntoGeometrico v1, PuntoGeometrico v2){
        this.lado1[0]=v1;
        this.lado1[1]=v2;
    }

    public PuntoGeometrico[] getLado2() {
        return lado2;
    }

    public void setLado2(PuntoGeometrico[] lado2) {
        this.lado2 = lado2;
    }
    
    public void setLado2(PuntoGeometrico v2, PuntoGeometrico v3){
        this.lado2[0]=v2;
        this.lado2[1]=v3;
    }

    public PuntoGeometrico[] getLado3() {
        return lado3;
    }

    public void setLado3(PuntoGeometrico[] lado3) {
        this.lado3 = lado3;
    }

    public void setLado3(PuntoGeometrico v3, PuntoGeometrico v4){
        this.lado3[0]=v3;
        this.lado3[1]=v4;
    }

    public PuntoGeometrico[] getLado4() {
        return lado4;
    }

    public void setLado4(PuntoGeometrico[] lado4) {
        this.lado4 = lado4;
    }
    
    public void setLado4(PuntoGeometrico v4, PuntoGeometrico v1){
        this.lado4[0]=v4;
        this.lado4[1]=v1;
    }

    public static void main (String [] args){
        PuntoGeometrico v1 = new PuntoGeometrico(-1,-2);
        PuntoGeometrico v2 = new PuntoGeometrico(1,-2);
        PuntoGeometrico v3 = new PuntoGeometrico(1,4);
        PuntoGeometrico v4 = new PuntoGeometrico(-1,4);

        Rectangulo2 rec = new Rectangulo2(v2, v1, v3, v4); 
        if(rec.esRectangulo()){
            System.out.println(rec.toString());
            System.out.println("Rectángulo de área: "+rec.area()+", es cuadrado? "+rec.esCuadrado());
            System.out.println("----corrimiento----");
            rec.desplazamiento(5, 6);
            System.out.println(rec.toString());
            System.out.println("Rectángulo de área: "+rec.area()+", es cuadrado? "+rec.esCuadrado());
        }

        Rectangulo2 rec2 = new Rectangulo2();
        if(rec2.esRectangulo()){
            System.out.println(rec2.toString());
            System.out.println("Rectángulo de área: "+rec2.area()+", es cuadrado? "+rec2.esCuadrado());
        }

        if(rec.esRectangulo()&&rec.esRectangulo()){
            int comp=rec.comparaTamanio(rec2);
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