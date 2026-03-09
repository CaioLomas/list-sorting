public class Ordenacao {

    static final int qtd_algoritmos=7;

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
            else if(meio==fim)
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

        pult=L.getUlt();
        pant=L.getPrim();
        pprox=pant.getProx();

        while(flag){
            flag=false;
            while(pant!=pult){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    aux=pprox.getValor();
                    pprox.setValor(pant.getValor());
                    pant.setValor(aux);
                }

                pant=pprox;
                pprox=pprox.getProx();
            }

            pult=pult.getAnt();
            pant=L.getPrim();
            pprox=pant.getProx();
        }
    }

    public void shake(Lista L){
        System.out.print("Método em execução => Shake\n");
        No pini,pfim,pant,pprox;
        boolean flag=true;
        int aux;
        pini=L.getPrim();
        pfim=L.getUlt();
        pant=pini;
        pprox=pant.getProx();

        while(flag==true){
            flag=false;

            while(pant!=pfim){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    aux=pprox.getValor();
                    pprox.setValor(pant.getValor());
                    pant.setValor(aux);
                }
                pant=pprox;
                pprox=pprox.getProx();
            }

            pfim=pfim.getAnt();
            pprox=pfim;
            pant=pprox.getAnt();

            while(pprox!=pini){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    aux=pprox.getValor();
                    pprox.setValor(pant.getValor());
                    pant.setValor(aux);
                }
                pprox=pant;
                pant=pant.getAnt();
            }

            pini=pini.getProx();
            pant=pini;
            pprox=pant.getProx();
        }
    }

//    public void shell(Lista L){
//        System.out.print("Método em execução => Shell\n");
//        int gap=L.getQtd()/2;
//        int i,valorPivo;
//        No noCorrente,noAnterior,noTroca;
//
//        while(gap>0){
//            noCorrente=L.getPrim();
//            for(i=0;i<gap;i++)
//                noCorrente=noCorrente.getProx();
//
//            while(noCorrente!=null){
//                valorPivo=noCorrente.getValor();
//                noTroca=noCorrente;
//
//                // Busca inicial do nó anterior à distância gap
//                noAnterior=noTroca;
//                for(i=0;i<gap && noAnterior!=null;i++)
//                    noAnterior=noAnterior.getAnt();
//
//                // Condição estruturada: verifica se o nó existe e se o valor é maior que o pivô
//                while (noAnterior != null && noAnterior.getValor() > valorPivo) {
//                    noTroca.setValor(noAnterior.getValor());
//                    noTroca = noAnterior;
//
//                    // Atualiza o noAnterior voltando gap casas para a próxima verificação
//                    for (i = 0; i < gap && noAnterior != null; i++)
//                        noAnterior = noAnterior.getAnt();
//                }
//
//                noTroca.setValor(valorPivo);
//                noCorrente = noCorrente.getProx();
//            }
//            gap /= 2;
//        }
//    }

    public void shell(Lista L){
        System.out.print("Método em execução => Shell\n");
        int aux,gap;
        No noant,nogap;

        for(gap=L.getQtd()/2;gap>0;gap/=2){

            nogap=noant=L.getPrim();
            for(int i=0;i<gap;i++)
                nogap=nogap.getProx();

            while(nogap!=null){

                aux=nogap.getValor();

                if(aux<noant.getValor())
                    nogap.setValor(noant.getValor());

                noant.setValor(aux);
                nogap=nogap.getProx();
                noant=noant.getProx();
            }
        }
    }

    public No fe(int pospai,No pai){

        for(int i=0;i<pospai+1 && pai!=null;i++)
            pai=pai.getProx();

        return pai;
    }

    public void heap(Lista L){
        System.out.print("Método em execução => Heap\n");
        if(L.getQtd()>1)
        {
            No pai,fesq,fdir,maiorF,auxult=L.getUlt();
            int pospai,aux,TL=L.getQtd();

            while(TL>0)
            {
                pospai=((int)TL/2)-1;
                pai=L.getPrim();
                for(int i=0;i<pospai;i++)
                    pai=pai.getProx();

                while(pai!=null)
                {
                    fesq=fe(pospai,pai);
                    fdir=fesq.getProx();
                    maiorF=fesq;

                    //Tem q ve se o fdir existe e se o fesq não é o único que ainda tá desordenado, pq o irmão dele, fdir, pode já estar ordenado
                    if(fesq!=auxult && fdir!=null && maiorF.getValor()<fdir.getValor())
                        maiorF=fdir;

                    if(maiorF.getValor()>pai.getValor())
                    {
                        aux=pai.getValor();
                        pai.setValor(maiorF.getValor());
                        maiorF.setValor(aux);
                    }

                    pai=pai.getAnt();
                    pospai--;
                }

                aux=L.getPrim().getValor();
                L.getPrim().setValor(auxult.getValor());
                auxult.setValor(aux);
                auxult=auxult.getAnt();
                TL--;
            }
        }
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
