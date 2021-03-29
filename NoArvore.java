public class NoArvore {
    int info;
    NoArvore direita = null;
    NoArvore esquerda = null;

    public NoArvore(){
    }

    public void preOrder(NoArvore arvore) {
        if (arvore != null) {
            System.out.println(arvore.info);
            preOrder(arvore.esquerda);
            preOrder(arvore.direita);
        }
    }


    public void emOrdem(NoArvore arvore){
        if (arvore != null){
            //percorrer arvore esquerda
            emOrdem(arvore.esquerda);
            System.out.println(arvore.info);
            //percorrer arvore direita
            emOrdem(arvore.direita);
        }
    }


    public void posOrder(NoArvore arvore) {
        if (arvore != null) {
            posOrder(arvore.esquerda);
            posOrder(arvore.direita);
            System.out.println(arvore.info);
        }
    }


    NoArvore procurar(NoArvore arvore, int valor){
        if (arvore==null){
            return null;
        }else if(arvore.info > valor){
            return procurar(arvore.esquerda, valor);
        }else if(arvore.info < valor){
            return procurar(arvore.direita, valor);
        }else{
            return arvore;
        }
    }



    NoArvore inserirRaiz(NoArvore arvore, int valor){
        arvore.info = valor;
        arvore.esquerda = null;
        arvore.direita = null;
        return arvore;
    }

    NoArvore insere(NoArvore arvore, int valor){
        if (arvore == null){
            arvore = new NoArvore();
            arvore.info = valor;
            arvore.esquerda = null;
            arvore.direita = null;
            //menor que raiz
        }else if(valor < arvore.info){
            arvore.esquerda = insere(arvore.esquerda, valor);
        }else{
            arvore.direita = insere(arvore.direita, valor);
        }
        return arvore;
    }



    NoArvore Retira(NoArvore arvore, int valor){
        if (arvore == null){
            System.out.println("elemento nao encontrado! Valor: " + valor);
            return null;
        }else if(arvore.info > valor){
            arvore.esquerda = Retira(arvore.esquerda, valor);
        }else if (arvore.info < valor){
            arvore.direita = Retira(arvore.direita, valor);
        }else{

            // no sem filhos
            if (arvore.esquerda == null && arvore.direita == null){
                arvore = null;
            }

            //no so tem filhos a esquerda
            else if (arvore.esquerda == null){
                NoArvore novaArvore = arvore;
                arvore = arvore.direita;
            }

            //no so tem filhos a direita
            else if (arvore.direita == null){
                NoArvore novaArvore = arvore;
                arvore = arvore.esquerda;
            }

            //no tem dois filhos
            else{
                NoArvore novaArvore = arvore.esquerda;
                while(arvore.direita!= null){
                    novaArvore = novaArvore.direita;
                }

                arvore.info = novaArvore.info;
                novaArvore.info = valor;
                arvore.esquerda = Retira(arvore.esquerda, valor);
            }
        }
        return arvore;
    }





















}
