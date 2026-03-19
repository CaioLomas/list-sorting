public class Main{

    public static void main(String[] args){

        Lista L;
        Ordenacao ord = new Ordenacao();

        for(int i=1;i<17;i++){
            L = new Lista();
            L.preencheLista();
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Lista inicial: \n");
            L.exibeLista();
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Lista pós ordenação: ");
            switch(i){
                case 1: ord.insercaoDireta(L);
                    System.out.print("Método em execução => Inserção Direta\n");
                    break;
                case 2: ord.insercaoBinaria(L);
                    System.out.print("Método em execução => Inserção Binária\n");
                    break;
                case 3: ord.selecaoDireta(L);
                    System.out.print("Método em execução => Seleção Direta\n");
                    break;
                case 4: ord.bolha(L);
                    System.out.print("Método em execução => Bolha\n");
                    break;
                case 5: ord.shake(L);
                    System.out.print("Método em execução => Shake\n");
                    break;
                case 6: ord.shell(L);
                    System.out.print("Método em execução => Shell\n");
                    break;
                case 7: ord.heap(L);
                    System.out.print("Método em execução => Heap\n");
                    break;
                case 8: ord.quickSemPivo(L);
                    System.out.print("Método em execução => Quick Sem Pivô\n");
                    break;
                case 9: ord.quickComPivo(L);
                    System.out.print("Método em execução => Quick Com Pivô\n");
                    break;
                case 10: ord.merge(L);
                    System.out.print("Método em execução => Merge\n");
                    break;
                case 11: ord.mergeRecursivo(L);
                    System.out.print("Método em execução => Merge Recursivo\n");
                    break;
                case 12: ord.counting(L);
                    System.out.print("Método em execução => Counting\n");
                    break;
                case 13: ord.bucket(L);
                    System.out.print("Método em execução => Bucket\n");
                    break;
                case 14: ord.radix(L);
                    System.out.print("Método em execução => Radix\n");
                    break;
                case 15: ord.comb(L);
                    System.out.print("Método em execução => Comb\n");
                    break;
                case 16: ord.gnome(L);
                    System.out.print("Método em execução => Gnome\n");
                    break;
                case 17: ord.tim(L);
                    System.out.print("Método em execução => Tim\n");
                    break;
            }
            L.checaOrdenacao();
            L.exibeLista();
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
            System.out.print("\n\n");
            L.limpaLista();
        }
    }
}