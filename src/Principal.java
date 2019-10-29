import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static String[] Palabras = new String[5];
    public static String PalabraJugar = "";
    public static char [] Letras ;
    public static char Letra = 'x';
    public static char [] LetrasCorrectas;
    public static int contador = 0;
    public static char [] PalabraTapada ;
    public static void main(String[] args){
        Palabras[0] = "Sergio";
        Palabras[1] = "Raton";
        Palabras[2] = "Teclado";
        Palabras[3] = "Java";
        Palabras[4] = "Bug";

        PalabraJugar = PalabraRandom();

            if (PalabraJugar != "") {
                //System.out.println(PalabraJugar);
                Letras = PalabraJugar.toCharArray();
                PalabraTapada = new char[Letras.length];
                LetrasCorrectas = new char[Letras.length];
                System.out.println("La palabra tiene " + Letras.length + " letras");

                for (int i = 0; i < Letras.length; i++) {
                    System.out.print("-");
                }
                do{
                System.out.println("");
                System.out.println("Dime una Letra");
                Scanner sc = new Scanner(System.in);
                Letra = sc.next().charAt(0);
                sc.nextLine();
                if (ComprobarChar(Letra, Letras)) {

                    System.out.println("Si contiene");
                   contador++;
                    DestaparChar(Letras,Letra);
                    System.out.println("Quieres resolver la palabra? [S/N]");
                    String resol = sc.nextLine();
                    if(resol.equals("S") || resol.equals("s")){
                        System.out.println("Que palabra es?");
                        String PResolver = sc.nextLine();
                        ResolverPalabra(PResolver);
                    }

                } else {
                    System.out.println("No contiene esa letra");
                   contador++;
                }
                }while (contador < 6);

            }

        System.out.println("Has agotado tus vidas, la palabra era: " + PalabraJugar);
    }
    public static Boolean ComprobarChar(char letra, char[] Palabra){
        for (int i = 0; i <Palabra.length ; i++) {
            if (Palabra[i] == letra){
                return true;
            }
        }
        return false;
    }
    public static void DestaparChar(char[] palabra, char letrascorrectas){


        for (int i = 0; i < palabra.length; i++) {

                if (palabra[i] == letrascorrectas){
                    PalabraTapada[i] = palabra[i];


                }else {
                    PalabraTapada[i] = '-';
                }
            }

        System.out.println(PalabraTapada);


    }

    public static void ResolverPalabra(String palabra){
        if (palabra.equals(PalabraJugar)){
            System.out.println("Has ganado!!!");
            System.exit(1);
        }else{
            System.out.println("No has acertado, has perdido");
            System.exit(1);
        }

    }
    public static String PalabraRandom(){
        int num =(int) (Math.random()*4+0);

        String palarbraRandom = Palabras[num];
        return palarbraRandom;
        }


}
