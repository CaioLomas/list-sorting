public class Lista {

    private No prim;
    private No ult;
    private int qtd;
    private boolean ordenado;

    public Lista(){prim=ult=null;qtd=0;ordenado=false;}

    public No getPrim(){return prim;}
    public No getUlt(){return ult;}
    public int getQtd(){return qtd;}
    public int getMaior(){
        No pa=prim.getProx();
        int maior=prim.getValor();

        while(pa!=null)
        {
            if(maior<pa.getValor())
                maior=pa.getValor();
            pa=pa.getProx();
        }

        return maior;
    }
    public int getMaxAlgarismos(){
        int i=getMaior(),j=0;
        while(i>0)
        {
            j++;
            i/=10;
        }
        return j;
    }

    public void setPrim(No prim){this.prim=prim;}
    public void setUlt(No ult){this.ult=ult;}


    public void addValor(int valor){

        if(qtd==0)
            prim=ult=new No(valor);
        else
        {
            No novo=new No(valor);
            novo.setAnt(ult);
            ult.setProx(novo);
            ult=novo;
        }

        qtd++;
    }

    public void preencheLista(){
        //Está com 16 elementos para ser múltiplo de 2 (merge), com alguns repetidos para teste do counting/radix/bucket. Se colocar qualquer quantia
        //sem ser potência de 2 vai explodir chicão
        addValor(12);
        addValor(10);
        addValor(5);
        addValor(7);
        addValor(9);
        addValor(4);
        addValor(2);
        addValor(1);
        addValor(11);
        addValor(5);
        addValor(7);
        addValor(10);
        addValor(25);
        addValor(84);
        addValor(4);
        addValor(5);

        addValor(12);
        addValor(10);
        addValor(5);
        addValor(7);
        addValor(9);
        addValor(4);
        addValor(2);
        addValor(1);
        addValor(11);
        addValor(5);
        addValor(7);
        addValor(10);
        addValor(25);
        addValor(84);
        addValor(4);
        addValor(5);

        addValor(12);
        addValor(10);
        addValor(5);
        addValor(7);
        addValor(9);
        addValor(4);
        addValor(2);
        addValor(1);
        addValor(11);
        addValor(5);
        addValor(7);
        addValor(10);
        addValor(25);
        addValor(84);
        addValor(4);
        addValor(5);

        addValor(12);
        addValor(10);
        addValor(5);
        addValor(7);
        addValor(9);
        addValor(4);
        addValor(2);
        addValor(1);
        addValor(11);
        addValor(5);
        addValor(7);
        addValor(10);
        addValor(25);
        addValor(84);
        addValor(4);
        addValor(5);
    }

    public void exibeLista(){
        No aux=prim;
        int tabulacao=16;

        for(int i=0;i<qtd;i++)
        {
            if(i==tabulacao)
            {
                System.out.print("\n");
                tabulacao+=16;
            }
            if(i+1==qtd)
                System.out.printf(" [%d]",aux.getValor());
            else
                System.out.printf(" [%d] -",aux.getValor());
            aux=aux.getProx();
        }

        if(ordenado)
            System.out.print("\nOrdenada         \u2714");
        else
            System.out.print("\nDesordenada      \u2717");
    }

    public void limpaLista() {
        prim=ult=null;
        qtd=0;
    }

    public void checaOrdenacao(){
        if(qtd<2)
            ordenado=true;
        else{
            No pi,pj;
            pi=prim;
            pj=prim.getProx();

            while(pj.getProx()!=null && pi.getValor()<=pj.getValor())
            {
                pi=pj;
                pj=pj.getProx();
            }

            if(pj.getProx()==null && pi.getValor()<=pj.getValor())
                ordenado=true;
        }
    }
}