public class Ordenacao {

    public Ordenacao(){}

    private No calc_meioMergeR(No ini,No fim){
        int cont=0;
        No meio=fim;

        while(meio!=ini)
        {
            meio=meio.getAnt();
            cont++;
        }
        cont++;

        for(int i=0;i<(cont-1)/2;i++)
            meio=meio.getProx();

        return meio;
    }

    public No calc_meioMerge(Lista l){
        int metade=l.getQtd()/2;
        No meio=l.getPrim();

        for(int i=1;i<metade;i++)
            meio=meio.getProx();

        return meio;
    }

    private No calc_meio(No ini,No fim){
        int cont=0;
        No meio=fim;

        while(meio!=ini)
        {
            meio=meio.getAnt();
            cont++;
        }
        cont++;

        for(int i=0;i<cont/2;i++)
            meio=meio.getProx();

        return meio;
    }

    public void troca(No a,No b){
        int aux;

        aux=a.getValor();
        a.setValor(b.getValor());
        b.setValor(aux);
    }

    //esse aqui é só pro tim
    public void insercaoDireta(No ini,No fim){
        if(ini!=null && fim!=null && ini!=fim){
            No pi=ini.getProx(), ppos;
            int aux;

            while(pi!=fim.getProx()){
                aux=pi.getValor();
                ppos=pi;
                while(ppos!=ini && aux<ppos.getAnt().getValor())
                {
                    ppos.setValor(ppos.getAnt().getValor());
                    ppos=ppos.getAnt();
                }

                ppos.setValor(aux);
                pi=pi.getProx();
            }
        }
    }

    public void insercaoDireta(Lista L){
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
        boolean flag=true;
        No pant,pprox,pult;

        pult=L.getUlt();
        pant=L.getPrim();
        pprox=pant.getProx();

        while(flag){
            flag=false;
            while(pant!=pult){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    troca(pprox,pant);
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
        No pini,pfim,pant,pprox;
        boolean flag=true;
        pini=L.getPrim();
        pfim=L.getUlt();
        pant=pini;
        pprox=pant.getProx();

        while(flag==true){
            flag=false;

            while(pant!=pfim){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    troca(pant,pprox);
                }
                pant=pprox;
                pprox=pprox.getProx();
            }

            pfim=pfim.getAnt();
            if(pfim==pini) flag=false;
            pprox=pfim;
            pant=pprox.getAnt();

            while(pprox!=pini){
                if(pant.getValor()>pprox.getValor()){
                    flag=true;
                    troca(pant,pprox);
                }
                pprox=pant;
                pant=pant.getAnt();
            }

            pini=pini.getProx();
            if(pini==pfim) flag=false;
            pant=pini;
            pprox=pant.getProx();
        }
    }

    public void shell(Lista L){ //Gigante e feio, tá ordenando mas não sei se tá certo, só consegui com muitos loops
        int aux,dist;
        No noA,noB,noAuxA,noAuxB;

        dist=1;
        while(dist<L.getQtd())
            dist=3*dist+1;
        dist/=3;

        while(dist>0){

            noA=noB=L.getPrim();
            for(int j=0;j<dist;j++)
                noB=noB.getProx();

            while(noB!=null){

                if(noB.getValor()<noA.getValor()){

                    noAuxA=noA;
                    noAuxB=noB;

                    aux=noAuxB.getValor();
                    noAuxB.setValor(noAuxA.getValor());
                    noAuxA.setValor(aux);

                    noAuxB=noAuxA;
                    for(int k=0;noAuxA!=null && k<dist;k++)
                        noAuxA=noAuxA.getAnt();

                    while(noAuxA!=null && noAuxB.getValor()<noAuxA.getValor()){

                        noAuxB.setValor(noAuxA.getValor());
                        noAuxA.setValor(aux);

                        noAuxB=noAuxA;
                        for(int k=0;noAuxA!=null && k<dist;k++)
                            noAuxA=noAuxA.getAnt();
                    }
                }

                noA=noA.getProx();
                noB=noB.getProx();
            }
            dist/=3;
        }
    }

    public No fe(int pospai,No pai){

        for(int i=0;i<pospai+1 && pai!=null;i++)
            pai=pai.getProx();

        return pai;
    }

    public void heap(Lista L){
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

    private void quickSP(No ini,No fim){
        No pa,pb;
        pa=ini;
        pb=fim;

        while(pa!=pb)
        {
            while(pa!=pb && pa.getValor()<=pb.getValor())
                pa=pa.getProx();
            troca(pa,pb);

            while(pa!=pb && pa.getValor()<=pb.getValor())
                pb=pb.getAnt();
            troca(pa,pb);
        }

        if(pa!=ini)
            quickSP(ini,pa.getAnt());
        if(pb!=fim)
            quickSP(pb.getProx(),fim);
    }

    public void quickSemPivo(Lista L){
        quickSP(L.getPrim(),L.getUlt());
    }

    private void quickCP(No ini,No fim){
        No pa,pb,no_pivo=calc_meio(ini,fim);
        int pivo=no_pivo.getValor();
        pa=ini;
        pb=fim;

        while(pa!=pb && pa.getAnt()!=pb)
        {
            while(pa.getValor()<pivo)
                pa=pa.getProx();
            while(pivo<pb.getValor())
                pb=pb.getAnt();

            if(pa!=pb && pa.getAnt()!=pb)
            {
                troca(pa,pb);
                if(pa.getValor()==pb.getValor())
                    pa=pa.getProx();
            }
        }

        if(pa==pb)
            if(pa.getValor()<=pivo && pa!=fim)
                pa=pa.getProx();
            else if(pb!=ini)
                pb=pb.getAnt();


        if(pa!=ini)
            quickCP(ini,pa.getAnt());
        if(pb!=fim)
            quickCP(pb.getProx(),fim);
    }

    public void quickComPivo(Lista L){
        quickCP(L.getPrim(),L.getUlt());
    }

    private void fusao(Lista L,Lista l1,Lista l2,int seq){
        No p1=l1.getPrim(),p2=l2.getPrim(),pl=L.getPrim();
        while(p1!=null && p2!=null){
            int i=0,j=0;

            while(i<seq && j<seq){
                if(p1.getValor()<=p2.getValor()){
                    pl.setValor(p1.getValor());
                    p1=p1.getProx();
                    i++;
                }else{
                    pl.setValor(p2.getValor());
                    p2=p2.getProx();
                    j++;
                }
                pl=pl.getProx();
            }

            while(i<seq && p1!=null){
                pl.setValor(p1.getValor());
                p1=p1.getProx();
                i++;
                pl=pl.getProx();
            }

            while(j<seq && p2!=null){
                pl.setValor(p2.getValor());
                p2=p2.getProx();
                j++;
                pl=pl.getProx();
            }
        }
    }

    private void particao(Lista l,Lista l1,Lista l2){
        No p=l.getPrim(),meio=calc_meioMerge(l),pl1=l1.getPrim(),pl2=l2.getPrim();

        while(p!=meio.getProx())
        {
            pl1.setValor(p.getValor());
            pl1=pl1.getProx();
            p=p.getProx();
        }
        while(p!=null)
        {
            pl2.setValor(p.getValor());
            pl2=pl2.getProx();
            p=p.getProx();
        }
    }

    //Só pra nao ficar remontando as listas toda hora
    private void montaLista(int tam,Lista l1,Lista l2){
        for(int i=0;i<tam;i++)
        {
            l1.addValor(0);
            l2.addValor(0);
        }
    }

    //Considerar tamanhos múltiplos de 2
    public void merge(Lista L){
        int seq=1;
        Lista l1,l2;
        l1 = new Lista();
        l2 = new Lista();
        montaLista(L.getQtd()/2,l1,l2);

        while(seq<L.getQtd()){
            particao(L,l1,l2);
            fusao(L,l1,l2,seq);
            seq*=2;
        }
    }

    private void fusaoR(No esq1,No dir1,No esq2,No dir2){
        Lista aux=new Lista();

        No p1=esq1;
        No p2=esq2;

        while(p1!=dir1.getProx()&&p2!=dir2.getProx()) {
            if(p1.getValor()<=p2.getValor()){
                aux.addValor(p1.getValor());
                p1=p1.getProx();
            }
            else
            {
                aux.addValor(p2.getValor());
                p2=p2.getProx();
            }
        }

        while(p1!=dir1.getProx()){
            aux.addValor(p1.getValor());
            p1=p1.getProx();
        }

        while(p2!=dir2.getProx()){
            aux.addValor(p2.getValor());
            p2=p2.getProx();
        }

        No pl=esq1;
        No pa=aux.getPrim();

        while(pa!=null){
            pl.setValor(pa.getValor());
            pl=pl.getProx();
            pa=pa.getProx();
        }
    }

    private void mergeR(No esq,No dir){
        No meio;

        if(esq!=null && dir!=null && esq!=dir){
            meio=calc_meioMergeR(esq, dir);
            mergeR(esq,meio);
            mergeR(meio.getProx(),dir);
            fusaoR(esq,meio,meio.getProx(),dir);
        }
    }

    public void mergeRecursivo(Lista L){
        mergeR(L.getPrim(),L.getUlt());
    }

    public No buscaNumCounting(int i,No busca){

        while(busca!=null && busca.getValor()!=i)
            busca=busca.getProx();

        return busca;
    }

    public void counting(Lista L){
        int vet[],i;
        No pa;
        Lista nova=new Lista();
        vet=new int[L.getMaior()+1];

        for(pa=L.getPrim();pa!=null;pa=pa.getProx()){
            i=pa.getValor();
            vet[i]++;
        }

        for(i=0;i<vet.length;i++){
            if(vet[i]>0)
            {
                pa=L.getPrim();
                pa=buscaNumCounting(i,pa);
                while(vet[i]>0)
                {
                    nova.addValor(pa.getValor());
                    vet[i]--;
                }
            }
        }

        L.setPrim(nova.getPrim());
        L.setUlt(nova.getUlt());
    }

    public void bucket(Lista L){
        Ordenacao ord = new Ordenacao();
        Lista baldes[] = new Lista[L.getQtd()];
        No pa=L.getPrim();
        int i,maior=L.getMaior();
        double formula;
        boolean primeiro=true;

        for(i=0;i<baldes.length;i++)
            baldes[i] = new Lista();

        while(pa!=null){
            formula=(double)baldes.length*pa.getValor()/(maior+1);
            baldes[(int)formula].addValor(pa.getValor());
            pa=pa.getProx();
        }

        for(i=0;i<baldes.length;i++){
            if(baldes[i].getQtd()>0)
            {
                ord.insercaoDireta(baldes[i]);
                if(primeiro==true)
                {
                    L.setPrim(baldes[i].getPrim());
                    L.setUlt(baldes[i].getUlt());
                    primeiro=false;
                }
                else
                {
                    L.getUlt().setProx(baldes[i].getPrim());
                    L.getUlt().getProx().setAnt(L.getUlt());
                    L.setUlt(baldes[i].getUlt());
                }
            }
        }
    }

    public void radix(Lista L){
        int i,j,base_mod=10,base_div=1,digito_menos_significativo;
        Lista laux = new Lista(),vetores[] = new Lista[base_mod];
        No aux,pa=L.getPrim();

        for(i=0;i<vetores.length;i++)
            vetores[i] = new Lista();

        for(i=L.getMaxAlgarismos();i>0;i--){

            while(pa!=null){
                digito_menos_significativo=(pa.getValor()%base_mod)/base_div;
                vetores[digito_menos_significativo].addValor(pa.getValor());
                pa=pa.getProx();
            }

            for(j=0;j<vetores.length;j++)
                if(vetores[j].getQtd()>0)
                {
                    aux=vetores[j].getPrim();
                    while(aux!=null)
                    {
                        laux.addValor(aux.getValor());
                        aux=aux.getProx();
                    }
                    vetores[j].limpaLista();
                }

            L.setPrim(laux.getPrim());
            L.setUlt(laux.getUlt());
            pa=L.getPrim();
            base_div=base_mod;
            base_mod*=10;
            laux.limpaLista();
        }
    }

    public void comb(Lista L){
        int dist,aux,i;
        No pa,pb;

        dist=(int)(L.getQtd()/1.3);

        while(dist>0){

            pa=pb=L.getPrim();
            for(i=0;i<dist;i++)
                pb=pb.getProx();

            while(pb!=null){
                if(pa.getValor()>=pb.getValor()){
                    aux=pa.getValor();
                    pa.setValor(pb.getValor());
                    pb.setValor(aux);
                }
                pa=pa.getProx();
                pb=pb.getProx();
            }

            dist/=1.3;
        }
    }

    public void gnome(Lista L){
        int aux;
        No pa=L.getPrim().getProx();

        while(pa!=null){
            aux=pa.getValor();
            if(pa.getAnt()==null || aux>=pa.getAnt().getValor())
                pa=pa.getProx();
            else
            {
                pa.setValor(pa.getAnt().getValor());
                pa.getAnt().setValor(aux);
                pa=pa.getAnt();
            }
        }
    }

    private void mesclarInPlace(Lista L,No esq,No meio,No dir){
        if(esq!=null && meio!=null && dir!=null){
            No p1=esq;
            No p2=meio.getProx();
            No limite=dir.getProx();
            No proxP2;

            while(p1!=p2 && p2!=limite){
                if(p1.getValor()<=p2.getValor()){
                    p1=p1.getProx();
                }
                else
                {
                    proxP2=p2.getProx();

                    p2.getAnt().setProx(p2.getProx());
                    if(p2.getProx()!=null){
                        p2.getProx().setAnt(p2.getAnt());
                    }
                    else
                    {
                        L.setUlt(p2.getAnt());
                    }

                    p2.setAnt(p1.getAnt());
                    p2.setProx(p1);
                    if(p1.getAnt()!=null){
                        p1.getAnt().setProx(p2);
                    }
                    else
                    {
                        L.setPrim(p2);
                    }
                    p1.setAnt(p2);

                    p2=proxP2;
                }
            }
        }
    }

    public void tim(Lista L){
        int n=L.getQtd();
        if(n>1){
            int tamBloco=32;
            No pa=L.getPrim();
            No fimBloco;
            int cont;

            while(pa!=null){
                fimBloco=pa;
                cont=1;
                while(cont<tamBloco && fimBloco.getProx()!=null){
                    fimBloco=fimBloco.getProx();
                    cont++;
                }
                insercaoDireta(pa,fimBloco);
                pa=fimBloco.getProx();
            }

            int tamMerge=32;
            No esq,meio,dir,limiteEsq;

            while(tamMerge<n){
                esq=L.getPrim();
                while(esq!=null){
                    meio=esq;
                    cont=1;
                    while(cont<tamMerge && meio.getProx()!=null){
                        meio=meio.getProx();
                        cont++;
                    }

                    if(meio.getProx()!=null){
                        dir=meio.getProx();
                        cont=1;
                        while(cont<tamMerge && dir.getProx()!=null){
                            dir=dir.getProx();
                            cont++;
                        }

                        limiteEsq=dir.getProx();
                        mesclarInPlace(L,esq,meio,dir);
                        esq=limiteEsq;
                    }
                    else
                    {
                        esq=null;
                    }
                }
                tamMerge=tamMerge*2;
            }
        }
    }
}
