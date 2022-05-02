public class Professor {
    
    //Atributos de Instância ou do Objeto

    /*
		Os atributos são as características dos objetos e geralmente são representados por substantivos/adjetivos (Ex.: nome, idade etc..)
		Os atributos são responsáveis por "armazenar" informações do objeto e podem ser manipulados diretamente ou pelos métodos
		Os atributos devem estar associados a um tipo (primitivo ou não) Ex.: int, boolean, String ou outras classes
	*/

    int matricula;
    String nome;
    String sobrenome;
    int idade;
    char sexo;
    String cpf;
    String endereco;

    //Gets e Sets

    /*
		Os Gets e Sets são métodos usados para manipular os atributos da classe ou do objeto
		São importantes para alcançar o conceito de encapsulamento
		Cada atributo geralmente possui o seu respectivo get e set, onde o get é usado para recuperar o valor armazenado no atributo e o set usado para armazernar um valor no atributo
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

    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    //Construtores

    /*
		Os construtores são métodos especiais que possuem o mesmo nome da classe
		É possível construir um objeto do mesmo tipo de formas diferentes, com construtores diferentes, esse fenômeno está associado ao conceito de sobrecarga de métodos (Polimorfismo estático)
		O Polimorfismo Estático se dá quando temos a mesma operação (métodos) implementada várias vezes na mesma classe. A escolha de qual operação será chamada depende da assinatura (identificador do método, parâmetros) dos métodos sobrecarregados
	*/

    public Professor() {
    }

    public Professor(int matricula, String nome,String sobrenome, int idade, char sexo, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    //Métodos

    /*
		Os métodos são os comportamentos, as ações das classes, geralmente são representados com verbos
	*/ 

    @Override
    //O métodos toString() é uma forma de polimorfismo dinâmico, que chamamos de sopreposição, já que esse método é definido na classe object
	//O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original.
    public String toString() {
        String detalhes = "";
        detalhes += "Matrícula: " + this.matricula + " \n";
        detalhes += "Nome: " + this.nome + " \n";
        detalhes += "SobreNome: " + this.getSobrenome() + " \n";
		detalhes += "NomeCompleto: " + this.getNomeCompleto() + " \n";
        detalhes += "Idade: " + this.idade + " \n";
        detalhes += "Sexo: " + this.sexo + " \n";
        detalhes += "CPF: " + this.cpf + " \n";
        detalhes += "Endereço: " + this.endereco + " \n";
        return detalhes;
    }
    
    //O métodos equals() é uma forma de polimorfismo dinâmico, que chamamos de sopreposição, já que esse método é definido na classe object
    //O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original.
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Professor){
            Professor professor = (Professor) obj;
            return this.matricula == professor.getMatricula();
        }
        return false;
    }

}
