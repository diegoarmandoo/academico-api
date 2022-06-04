public class Sala {

    // Atributos de Instância ou do Objeto

    int numero;
    int capacidade;
    boolean arCondicionado;
    boolean quadroBranco;
    boolean laboratorio;

    //Gets e Sets

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isQuadroBranco() {
        return quadroBranco;
    }

    public void setQuadroBranco(boolean quadroBranco) {
        this.quadroBranco = quadroBranco;
    }

    public boolean isLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(boolean laboratorio) {
        this.laboratorio = laboratorio;
    }

    // Construtor

    public Sala() {
    }

    //Métodos

    @Override
    public String toString() {
        String detalhes = "";
        detalhes += "Número: " + this.getNumero() + " \n";
        detalhes += "Capacidade de Alunos: " + this.getCapacidade() + " \n";
        detalhes += "Tem Ar Condicionado? " + this.isArCondicionado() + " \n";
        detalhes += "Tem Quadro Branco? " + this.isQuadroBranco() + " \n";
        detalhes += "É um laboratório? " + this.isLaboratorio() + " \n";
        return detalhes;
    } 

    

}
