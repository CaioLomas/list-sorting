public class Main{

    public static void main(String[] args){

        Lista L;
        Ordenacao ord = new Ordenacao();

        for(int i=0;i<Ordenacao.qtd_algoritmos;i++){
            L = new Lista();
            L.preencheLista();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print("Lista inicial: \n");
            L.exibeLista();
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.print("Lista ordenada: ");
            switch(i){
                case 0: ord.insercaoDireta(L);
                    break;
                case 1: ord.insercaoBinaria(L);
                    break;
                case 2: ord.selecaoDireta(L);
                    break;
                case 3: ord.bolha(L);
                    break;
//                case 4: Ordenacao.insercaoDireta(L);
//                    break;
//                case 5: Ordenacao.insercaoDireta(L);
//                    break;
//                case 6: Ordenacao.insercaoDireta(L);
//                    break;
//                case 7: Ordenacao.insercaoDireta(L);
//                    break;
//                case 8: Ordenacao.insercaoDireta(L);
//                    break;
//                case 9: Ordenacao.insercaoDireta(L);
//                    break;
//                case 10: Ordenacao.insercaoDireta(L);
//                    break;
//                case 11: Ordenacao.insercaoDireta(L);
//                    break;
//                case 12: Ordenacao.insercaoDireta(L);
//                    break;
//                case 13: Ordenacao.insercaoDireta(L);
//                    break;
//                case 14: Ordenacao.insercaoDireta(L);
//                    break;
//                case 15: Ordenacao.insercaoDireta(L);
//                    break;
//                case 16: Ordenacao.insercaoDireta(L);
//                    break;
            }
            L.exibeLista();
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.print("\n\n");
        }
    }
}