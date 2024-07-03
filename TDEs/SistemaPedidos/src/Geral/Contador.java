package Geral;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Contador implements Serializable {
    private static final String ARQUIVO_CONTADOR = "contador.ser";
    private int valor;

    public Contador() {
        try {
            File arquivo = new File(ARQUIVO_CONTADOR);
            if (arquivo.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTADOR));
                this.valor = (int) in.readObject();
                in.close();
            } else {
                this.valor = 0;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void incrementar() {
        this.valor++;
    }


    public int getValor() {
        return valor;
    }

    public void salvarContador() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTADOR));
            out.writeObject(this.valor);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
