public class Endereco {

    // Atributos de Instância ou do Objeto

    int CEP;
    String rua;
    String bairro;
    String cidade;
    String estado;

    // Gets e Sets

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int cEP) {
        CEP = cEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Construtores

    public Endereco() {
    }

    public Endereco(int CEP, String rua, String bairro, String cidade, String estado) {
        this.CEP = CEP;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Métodos

    @Override
    public String toString() {
        String detalhes = "";
		detalhes += "CEP: " + this.getCEP() + " \n";
		detalhes += "Rua: " + this.getRua() + " \n";
		detalhes += "Bairro: " + this.getBairro() + " \n";
		detalhes += "Cidade: " + this.getCidade() + " \n";
		detalhes += "Estado: " + this.getEstado() + " \n";
		return detalhes;
    }

    


}