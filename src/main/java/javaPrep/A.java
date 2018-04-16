package javaPrep;

 public class A{
int x;
     protected int y;
     void test(){

     }
     protected class As{

     }
     private interface  s{

         static  final int x=5;
     }
    public static void tricky(Point arg1, Point arg2) {
        arg1.x = 100;
        arg1.y = 100;
        arg1.name ="sahil";
      //  arg1 =  new Point(9,2,"ss");
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }

    public static void main(String[] args) {
       /* Point pnt1 = new Point(0, 0, "gaurva");
        Point pnt2 = new Point(0, 0, "suarav");
        System.out.println("X: " + pnt1.x + " Y: " + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y);
        System.out.println(" ");
        tricky(pnt1, pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y+"name: "+pnt1.name);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y+"name: "+pnt2.name);*/
    }
}