/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aula;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    /*public static String formata(String mascara, String valor){
        MaskFormatter mask = null;
        String resultado = "";
        try {
            mask = new MaskFormatter(mascara); // dispara uma exceção verificada
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter('_');
            resultado = mask.valueToString(valor);
        } catch (ParseException e) {
            System.err.println("Erro ao formatar a String");
        }
        return resultado;
    }*/

    // encaminhando a exceção para o método que o invocou
    /*public static String formata(String m, String v) throws ParseException {
        String resultado = "";
        MaskFormatter mask = new MaskFormatter(m); // dispara uma exceção verificada
        mask.setValueContainsLiteralCharacters(false);
        mask.setPlaceholderCharacter('_');
        resultado = mask.valueToString(v);
        return resultado;
    }*/

    /* static String formata(String m, String v) throws ParseException {
        if (m == null || v == null) {
            throw new IllegalArgumentException("Máscara e valor não podem ser nulos");
        }
        String resultado = "";
        MaskFormatter mask = new MaskFormatter(m);
        mask.setValueContainsLiteralCharacters(false);
        mask.setPlaceholderCharacter('_');
        resultado = mask.valueToString(v);
        return resultado;
    }*/

    public static void main(String[] args) {
        /*Scanner ler = new Scanner(System.in);
        int a,b;

        try{
            System.out.println("Entre com um numero");
            a = ler.nextInt();
            System.out.println("Entre com um numero");
            b = ler.nextInt();

            double res = (double)a/b;

            System.out.println(a+ " dividido por " + b + " = " + res);
        } catch (InputMismatchException e) {
            System.err.println("Só é permitido numeros inteiros");
            ler.nextLine(); //limpa o buffer do teclado
        }
        catch (ArithmeticException err) {
            System.err.println("Não é permitido dividir por zero");
            ler.nextLine(); //limpa o buffer do teclado
            err.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Comportamento inesperado");
        }
        System.out.println("fim do programa");
    */
        //System.out.println(formata("(##) #####−####", "48998765432"));

        /*try {
            System.out.println(formata("(##) #####−####", "asdflkasdopgjkafgafdg"));
        } catch (ParseException e) {
            System.err.println("Erro ao formatar a String");
        }*/

        /*try {
            System.out.println(formata(null, "48998765432"));
        } catch (ParseException e) {
            System.err.println("Erro ao formatar a String");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }*/

        Bola bola1 = new Bola("campo", "branca", 15, 5);
        Bola bola2 = new Bola("bas", "amarela", 10, 4);
        Bola bola3 = bola2;

        String ifsc = "IFSC";
        String n = "POO";

        if(bola1 == bola2){
            System.out.println("iguais");
        } else{
            System.out.println("nao sao");
        }
    }
}