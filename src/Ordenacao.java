import java.sql.SQLOutput;

public class Ordenacao {

    public Ordenacao(){}

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

    public void quick(No ini,No fim){

    }

    public void quickSemPivo(Lista L){
        quick(L.getPrim(),L.getUlt());
    }

    public void quickP(Lista L){

    }

    public void quickComPivo(Lista L){

    }

    public void mergeTopDown(Lista L){

    }

    public void mergeBottomUp(Lista L){

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

    public void tim(Lista L){

    }
}
