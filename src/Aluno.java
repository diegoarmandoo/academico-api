import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Aluno extends Pessoa {

    // Atributos de Instância ou do Objeto

    /*
     * Os atributos são as características dos objetos e geralmente são
     * representados por substantivos/adjetivos (Ex.: nome, idade etc..)
     * Os atributos são responsáveis por "armazenar" informações do objeto e podem
     * ser manipulados diretamente ou pelos métodos
     * Os atributos devem estar associados a um tipo (primitivo ou não) Ex.: int,
     * boolean, String ou outras classes
     */

    String curso;
    boolean estaMatriculado;
    double media;
    double mediaPonderada;
    boolean aprovado;
    String situacao;

    //Associação entre classes através de atributos
	//O atributo notas é uma arraylist (coleção) do tipo/classe Nota
	//Associação Estrutural - Composição - A partir de atributo
    List<Nota> notas = new ArrayList<Nota>();

    // Atributo estático ou atributo da classe
    static int quantidadeAlunos = 0;
    static String nomeInstituicao = "IFS";

    // Gets e Sets

    /*
     * Os Gets e Sets são métodos usados para manipular os atributos da classe ou do
     * objeto
     * São importantes para alcançar o conceito de encapsulamento
     * Cada atributo geralmente possui o seu respectivo get e set, onde o get é
     * usado para recuperar o valor armazenado no atributo e o set usado para
     * armazernar um valor no atributo
     */

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isEstaMatriculado() {
        return estaMatriculado;
    }

    public void setEstaMatriculado(boolean estaMatriculado) {
        this.estaMatriculado = estaMatriculado;
    }

    public static int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public static void setQuantidadeAlunos(int quantidadeAlunos) {
        Aluno.quantidadeAlunos = quantidadeAlunos;
    }

    public static String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public static void setNomeInstituicao(String nomeInstituicao) {
        Aluno.nomeInstituicao = nomeInstituicao;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediaPonderada() {
        return mediaPonderada;
    }

    public void setMediaPonderada(double mediaPonderada) {
        this.mediaPonderada = mediaPonderada;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    // Construtores

    /*
     * Os construtores são métodos especiais que possuem o mesmo nome da classe
     * É possível construir um objeto do mesmo tipo de formas diferentes, com
     * construtores diferentes, esse fenômeno está associado ao conceito de
     * sobrecarga de métodos (Polimorfismo estático)
     * O Polimorfismo Estático se dá quando temos a mesma operação (métodos)
     * implementada várias vezes na mesma classe. A escolha de qual operação será
     * chamada depende da assinatura (identificador do método, parâmetros) dos
     * métodos sobrecarregados
     */

    public Aluno() {
        super();
        this.incrementaQuantidadeAlunos();
        this.setMatricula(this.gerarMatricula());
    }

    public Aluno(int matricula, String nome, String sobrenome, int idade, String naturalidade, char sexo, String cpf,
    Endereco endereco, String curso, boolean estaMatriculado) {
        super(matricula, nome, sobrenome, idade, naturalidade, sexo, cpf, endereco);
        this.curso = curso;
        this.estaMatriculado = estaMatriculado;
        this.incrementaQuantidadeAlunos();
        this.setMatricula(this.gerarMatricula());
    }

    // Métodos

    /*
     * Os métodos são os comportamentos, as ações das classes, geralmente são
     * representados com verbos
     */

    // O métodos toString() é uma forma de polimorfismo dinâmico, que chamamos de
    // sopreposição, já que esse método é definido na classe object
    // O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o
    // método original.
    @Override
    public String toString() {
        String detalhes = "";
        detalhes += super.toString();
        detalhes += "Curso: " + this.getCurso() + " \n";
        detalhes += "Esta Matriculado? " + this.isEstaMatriculado() + " \n";
        detalhes += "Notas " + this.getNotas() + " \n";
        detalhes += "Média Aritimética: " + this.getMedia() + " \n";
        detalhes += "Média Ponderada " + this.getMediaPonderada() + " \n";
        detalhes += "Situação: " + this.getSituacao() + " \n";
        detalhes += "Aprovado: " + this.isAprovado() + " \n";
        detalhes += "Nome da Instituição " + Aluno.getNomeInstituicao() + " \n";
        return detalhes;
    }

    // Método que incrementa o atributo estático quantidadeAlunos
    private void incrementaQuantidadeAlunos() {
        ++Aluno.quantidadeAlunos;
    }

    // O método gerarMatricula é uma sobrescrita
	// A implementação do método gerarMatricula na classe Aluno sobrescreve o método abstrato definido na classe Pessoa
	// Associaçaõ Comportamental - Dependência da Classe Aluno com as classes Random e Calendar através de imports.
	@Override
	public int gerarMatricula() {
        Random gerador = new Random(); //Instancia a classe Random
        Calendar calendario = Calendar.getInstance(); //Recupera uma instancia da classe Calendar
        int ano = calendario.get(Calendar.YEAR);  //Recupera o ano atual
        int min = 1000;  //Define o valor mínimo para do valor aletório
	    int max = 9999; //Define o valor máximo para do valor aletório
        String matricula = String.valueOf(ano) + String.valueOf(gerador.nextInt(max - min + 1) + min);
        return Integer.parseInt(matricula);  
    }

    private void verificarSituacao(){
        if (this.getMedia() >= 7){
            this.setSituacao("Aprovado");
            this.setAprovado(true);
        }
        else if (this.getMedia() >= 5 && this.getMedia() < 7){
            this.setSituacao("Recuperção");
            this.setAprovado(false);
        }
        else {
            this.setSituacao("Reprovado");
            this.setAprovado(false);
        }
    }

    public void calcularMediaAritimetica(){
        double somatorio = 0;
        for (Nota nota: this.getNotas()){
            somatorio += nota.getValor();
        }
        this.setMedia(somatorio / this.getNotas().size());
        this.verificarSituacao();
    }

    public void calcularMediaPonderada(){
        double somatorio = 0;
        double somatorioPesos = 0;
        for (Nota nota: this.getNotas()){
            somatorio += nota.getValor();
            somatorioPesos += nota.getPeso();
        }
        this.setMediaPonderada(somatorio / somatorioPesos);
    }

}
