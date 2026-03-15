public class Lista {

    private No prim;
    private No ult;
    private int qtd;

    public Lista(){prim=ult=null;qtd=0;}

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
    }

    public void exibeLista(){
        No aux=prim;

        for(int i=0;i<qtd;i++)
        {
            if(i+1==qtd)
                System.out.printf(" [%d]",aux.getValor());
            else
                System.out.printf(" [%d] -",aux.getValor());
            aux=aux.getProx();
        }
    }

    public void limpaLista() {
        prim=ult=null;
        qtd=0;
    }
}