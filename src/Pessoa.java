public abstract class Pessoa {

    // Atributos de Instância ou do Objeto

    /*
     * Os atributos são as características dos objetos e geralmente são
     * representados por substantivos/adjetivos (Ex.: nome, idade etc..)
     * Os atributos são responsáveis por "armazenar" informações do objeto e podem
     * ser manipulados diretamente ou pelos métodos
     * Os atributos devem estar associados a um tipo (primitivo ou não) Ex.: int,
     * boolean, String ou outras classes
     */

    int matricula;
    String nome;
    String sobrenome;
    int idade;
    String naturalidade;
    char sexo;
    String cpf;
    String endereco;

    // Gets e Sets

    /*
     * Os Gets e Sets são métodos usados para manipular os atributos da classe ou do
     * objeto
     * São importantes para alcançar o conceito de encapsulamento
     * Cada atributo geralmente possui o seu respectivo get e set, onde o get é
     * usado para recuperar o valor armazenado no atributo e o set usado para
     * armazernar um valor no atributo
     */

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    // Atributo Derivado a Partir de Método
    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Pessoa() {
    }

    public Pessoa(int matricula, String nome, String sobrenome, int idade, String naturalidade, char sexo, String cpf,
            String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = endereco;
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
        detalhes += "Matrícula: " + this.getMatricula() + " \n";
        detalhes += "Nome: " + this.getNome() + " \n";
        detalhes += "Sobrenome: " + this.getSobrenome() + " \n";
        detalhes += "Nome Completo: " + this.getNomeCompleto() + " \n";
        detalhes += "Idade: " + this.getIdade() + " \n";
        detalhes += "Naturalidade: " + this.getNaturalidade() + " \n";
        detalhes += "Sexo: " + this.getSexo() + " \n";
        detalhes += "CPF: " + this.getCpf() + " \n";
        detalhes += "Endereço: " + this.getEndereco() + " \n";
        return detalhes;
    }

    // O métodos equals() é uma forma de polimorfismo dinâmico, que chamamos de
    // sopreposição, já que esse método é definido na classe object
    // O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o
    // método original.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            return this.matricula == pessoa.getMatricula();
        }
        return false;
    }

}