public class Ordenacao {

    static final int qtd_algoritmos=4;

    public Ordenacao(){}

    public void insercaoDireta(Lista L){
        System.out.print("Método em execução => Inserção Direta\n");
        No pi = L.getPrim().getProx(), ppos;
        int aux;

        while(pi!=null){
            aux=pi.getValor();
            ppos=pi;
            while(ppos!=L.getPrim() && aux<ppos.getAnt().getValor())
            {
                ppos.setValor(ppos.getAnt().getValor());
                ppos=ppos.getAnt();
            }

            ppos.setValor(aux);
            pi=pi.getProx();
        }
    }

    //Código feeeeeeeeeeio feio feio, seco seco seco, n pensei em algo melhor infelizmente
    public No calc_meio(No ini,No fim){
        int cont=0;
        No meio=fim;

        while(meio!=ini)
        {
            meio=meio.getAnt();
            cont++;
        }
        cont++;

        for(int i=0;i<(int)cont/2;i++)
            meio=meio.getProx();

        return meio;
    }

    public No busca_binaria(int aux,No pi,Lista L){
        No ini,meio,fim;
        ini=L.getPrim();
        fim=pi.getAnt();
        meio=calc_meio(ini,fim);

        while(ini!=fim){
            //que coisa horrível esse tanto de if else mds do céu
            if(aux<meio.getValor())
                if(meio==ini)
                    ini=fim;
                else
                    fim=meio.getAnt();
            else
                if(meio==fim)
                    ini=fim;
                else
                    ini=meio.getProx();

            meio=calc_meio(ini,fim);
        }

        if(aux>meio.getValor())
            return meio.getProx();
        return meio;
    }

    public void insercaoBinaria(Lista L){
        System.out.print("Método em execução => Inserção Binária\n");
        No pi = L.getPrim().getProx(), ppos,paux;
        int aux;

        while(pi!=null) {
            aux=pi.getValor();
            ppos=busca_binaria(aux,pi,L);
            paux=pi;

            while(paux!=ppos){
                paux.setValor(paux.getAnt().getValor());
                paux=paux.getAnt();
            }

            ppos.setValor(aux);
            pi = pi.getProx();
        }
    }

    public void selecaoDireta(Lista L){
        System.out.print("Método em execução => Seleção Direta\n");
        No pi,pj,pmenor;
        int menor;
        pi=pmenor=L.getPrim();
        pj=pi.getProx();
        menor=pmenor.getValor();

        while(pi.getProx()!=null){
            while(pj!=null){
                if(menor>pj.getValor()){
                    menor=pj.getValor();
                    pmenor=pj;
                }
                pj=pj.getProx();
            }

            pmenor.setValor(pi.getValor());
            pi.setValor(menor);
            pi=pi.getProx();
            pj=pi.getProx();
            pmenor=pi;
            menor=pmenor.getValor();
        }
    }

    public void bolha(Lista L){
        System.out.print("Método em execução => Bolha\n");
        boolean flag=true;
        No pant,pprox,pult;
        int aux;

        pprox=pult=L.getUlt();
        pant=pprox.getAnt();

        while(flag){
            flag=false;
            while(pant!=null){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    aux=pprox.getValor();
                    pprox.setValor(pant.getValor());
                    pant.setValor(aux);
                }

                pprox=pant;
                pant=pant.getAnt();
            }

            pult=pult.getAnt();
            pprox=pult;
            pant=pprox.getAnt();
        }
    }

    public void shake(Lista L){

    }

    public void shell(Lista L){

    }

    public void heap(Lista L){

    }

    public void quick(Lista L){

    }

    public void quickPivo(Lista L){

    }

    public void mergeTopDown(Lista L){

    }

    public void mergeBottomUp(Lista L){

    }

    public void counting(Lista L){

    }

    public void bucket(Lista L){

    }

    public void radix(Lista L){

    }

    public void comb(Lista L){

    }

    public void gnome(Lista L){

    }


    public void tim(Lista L){

    }
}
