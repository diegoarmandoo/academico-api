public class Nota {

    // Atributos de Instância ou do Objeto

    private double valor;
    private int peso;

    // Gets e Sets

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    // Construtores

    public Nota() {
    }

    public Nota(double valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }

    // Métodos

    @Override
    public String toString() {
        return "Nota [peso=" + peso + ", valor=" + valor + "]";
    }
    
}
