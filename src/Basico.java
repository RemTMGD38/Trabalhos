import java.text.DecimalFormat;
import java.util.Scanner;

public class Basico {

    public Basico() {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        /* */

        entrada.close();
    }

    public static void main(String[] args) {
        new Basico();
    }

}
