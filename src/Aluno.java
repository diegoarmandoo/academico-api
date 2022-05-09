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
    }

    public Aluno(int matricula, String nome, String sobrenome, int idade, String naturalidade, char sexo, String cpf,
    String endereco, String curso, boolean estaMatriculado) {
        super(matricula, nome, sobrenome, idade, naturalidade, sexo, cpf, endereco);
        this.curso = curso;
        this.estaMatriculado = estaMatriculado;
        this.incrementaQuantidadeAlunos();
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
        detalhes += super.toString() + " \n";
        detalhes += "Curso: " + this.getCurso() + " \n";
        detalhes += "Esta Matriculado? " + this.isEstaMatriculado() + " \n";
        detalhes += "Nome da Instituição " + Aluno.getNomeInstituicao() + " \n";
        return detalhes;
    }

    // Método que incrementa o atributo estático quantidadeAlunos
    private void incrementaQuantidadeAlunos() {
        ++Aluno.quantidadeAlunos;
    }

}
