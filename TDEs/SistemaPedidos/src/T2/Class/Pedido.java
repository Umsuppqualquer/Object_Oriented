package T2.Class;

import java.util.Date;

public class Pedido extends Cliente {
    private int numero;
    private static int cont = 0;
    private Date dataPedido;
    private Date dataEntrega;
    private String situação;
    private ItemPedido p1;

    public Pedido(){
        this.numero = cont;
        cont++;
        dataPedido = new Date(); //quando criado ele ja armazena a data no qual foi criado
        System.out.println("Data : " + dataPedido.toString());
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setSituação(String situação) {
        this.situação = situação;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public String getSituação() {
        return situação;
    }



    
}
