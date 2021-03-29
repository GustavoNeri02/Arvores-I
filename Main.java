public class Main {
    public static void main(String[] args) {
        NoArvore arvore= new NoArvore();
        int[] numeros = new int[1000];
        int numeroGerado = 1;

        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = numeroGerado;

            while(!VerificarPrimo(numeros[i])){
                numeroGerado++;
                numeros[i] = numeroGerado;
            }
            numeroGerado++;
            arvore.insere(arvore, numeros[i]);

        }


        System.out.println("********** Em Ordem **********");
        arvore.emOrdem(arvore);

        System.out.println("\n\n\n\n\n********** Pré-Ordem **********");
        arvore.preOrder(arvore);

        System.out.println("\n\n\n\n\n********** Pós-Ordem **********");
        arvore.posOrder(arvore);



        for (int i = 0; i <= numeros[999]; i+=100) {
            arvore.Retira(arvore, buscarPrimoIntervalo(i, i+99));
        }


        System.out.println("********** Em Ordem **********");
        arvore.emOrdem(arvore);

        System.out.println("\n\n\n\n\n********** Pré-Ordem **********");
        arvore.preOrder(arvore);

        System.out.println("\n\n\n\n\n********** Pós-Ordem **********");
        arvore.posOrder(arvore);

    }

    private static boolean VerificarPrimo(int numero){
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }



    private static int buscarPrimoIntervalo(int min, int max){
        for (int i = min; i <= max; i++){
            if (VerificarPrimo(i)){
                return i;
            }
        }
        return 0;
    }

}
