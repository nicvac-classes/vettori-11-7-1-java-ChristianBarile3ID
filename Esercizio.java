import java.util.Scanner;
import java.util.Random;

class Esercizio {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int nAnimali, i, j, n, dimensioneAnimali, contAnimali;

        System.out.println("Inserisci il numero di animali nella riserva naturale: ");
        nAnimali = Integer.parseInt(in.nextLine());
        contAnimali = 0;
        int[] animali = new int[nAnimali];

        for (i = 0; i < animali.length; i++) {
            dimensioneAnimali = (3 + random.nextInt(7)) * 10;
            if (contAnimali == 0) {
                animali[0] = dimensioneAnimali;
                contAnimali++;
            } else {
                if (contAnimali == 1) {
                    animali[1] = dimensioneAnimali;
                    contAnimali++;
                } else {
                    if (contAnimali > 1) {
                        contAnimali = inserisciElemento(animali, contAnimali, dimensioneAnimali, i);
                        j = 0;
                        while (j < contAnimali) {
                            if (dimensioneAnimali > animali[j]) {
                                contAnimali = eliminaElemento(animali, contAnimali, j);
                            } else {
                                j++;
                            }
                        }
                    }
                }
            }
            visualizzaAnimali(animali, contAnimali);
        }
        n = eliminaDuplicati(animali, contAnimali);
        visualizzaAnimali(animali, contAnimali);
    }
    
    public static int eliminaDuplicati(int[] animali, int n) {
        int i, j;

        for (i = 0; i < n - 1; i++) {
            j = i + 1;
            while (j < n) {
                if (animali[i] == animali[j]) {
                    n = eliminaElemento(animali, n, j);
                } else {
                    j = j + 1;
                }
            }
        }
        
        return n;
    }
    
    public static int eliminaElemento(int[] animali, int n, int posizione) {
        int i;

        for (i = posizione; i < n - 1; i++) {
            animali[i] = animali[i + 1];
        }
        n = n - 1;
        
        return n;
    }
    
    public static int inserisciElemento(int[] animali, int n, int elemento, int posizione) {
        int i;

        for (i = n; i > posizione; i--) {
            animali[i] = animali[i - 1];
        }
        animali[posizione] = elemento;
        n = n + 1;
        
        return n;
    }
    
    public static void visualizzaAnimali(int[] animali, int n) {
        int i;

        for (i = 0; i < n; i++) {
            System.out.println("Dimensione: " + animali[i]);
        }
        System.out.println("------");
    }
}
