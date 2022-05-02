public class Professor {
    
    //Atributos de Instância ou do Objeto

    /*
		Os atributos são as características dos objetos e geralmente são representados por substantivos/adjetivos (Ex.: nome, idade etc..)
		Os atributos são responsáveis por "armazenar" informações do objeto e podem ser manipulados diretamente ou pelos métodos
		Os atributos devem estar associados a um tipo (primitivo ou não) Ex.: int, boolean, String ou outras classes
	*/

    int matricula;
    String nome;
    int idade;
    char sexo;
    String cpf;
    String endereco;

    //Construtores

    /*
		Os construtores são métodos especiais que possuem o mesmo nome da classe
		É possível construir um objeto do mesmo tipo de formas diferentes, com construtores diferentes, esse fenômeno está associado ao conceito de sobrecarga de métodos (Polimorfismo estático)
		O Polimorfismo Estático se dá quando temos a mesma operação (métodos) implementada várias vezes na mesma classe. A escolha de qual operação será chamada depende da assinatura (identificador do método, parâmetros) dos métodos sobrecarregados
	*/

    public Professor() {
    }

    public Professor(int matricula, String nome, int idade, char sexo, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
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
    public String toString() {
        String detalhes = "";
        detalhes += "Matrícula: " + this.matricula + " \n";
        detalhes += "Nome: " + this.nome + " \n";
        detalhes += "Idade: " + this.idade + " \n";
        detalhes += "Sexo: " + this.sexo + " \n";
        detalhes += "CPF: " + this.cpf + " \n";
        detalhes += "Endereço: " + this.endereco + " \n";
        return detalhes;
    }
    
}
