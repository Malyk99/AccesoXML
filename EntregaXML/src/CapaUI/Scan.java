package CapaUI;

import java.util.Scanner;

public class Scan {
    public static int pedirInt(){
        int pedido=0;
        try {
            Scanner scn=new Scanner(System.in);
            pedido = scn.nextInt();
            scn.nextLine();
            return pedido;

        }   catch (Exception e){
            System.out.println("El escaner de numeros falla");
        }
        return pedido;
    }
    public static String pedirString(){
        String pedido="";
        try {
            Scanner scn=new Scanner(System.in);
            pedido=scn.next();
            scn.nextLine();
            return pedido;
        }catch (Exception e){
            System.out.println("El escaner de strings falla");
        }
        return pedido;
    }

    public static double pedirDouble(){
        Scanner scn=new Scanner(System.in);
        double pedido= scn.nextDouble();
        return pedido;
    }

    public static boolean pedirBoolean(){
        Scanner scn=new Scanner(System.in);
        boolean pedido= scn.nextBoolean();
        return pedido;
    }
}
