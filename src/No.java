public class No {

    private int valor;
    private No ant;
    private No prox;

    public No(int valor){this.valor=valor;ant=prox=null;}

    public int getValor(){return valor;}
    public No getAnt(){return ant;}
    public No getProx(){return prox;}

    public void setAnt(No ant){this.ant=ant;}
    public void setProx(No prox){this.prox=prox;}
}