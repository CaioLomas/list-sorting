public class Lista {

    private No prim;
    private No ult;
    private static int qtd;

    public Lista(){prim=ult=null;qtd=0;}

    public No getPrim(){return prim;}
    public No getUlt(){return ult;}
    public int getQtd(){return qtd;}

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

        addValor(50);
        addValor(69);
        addValor(71);
        addValor(25);
        addValor(33);
        addValor(18);
        addValor(84);
        addValor(5);
        addValor(66);
        addValor(11);
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
}