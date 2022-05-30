import java.util.Random;

public class Professor extends Pessoa {

    // Atributos de Instância ou do Objeto
		
    double salario;
    int cargaHoraria;
    
    // Gets e Sets

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Construtor

    public Professor() {
        super();
        this.setMatricula(this.gerarMatricula());
    }

    // O método gerarMatricula é uma sobrescrita
	// A implementação do método gerarMatricula na classe Aluno sobrescreve o método abstrato definido na classe Pessoa
	// Associaçaõ Comportamental - Dependência da Classe Aluno com as classes Random e Calendar através de imports.
	@Override
	public int gerarMatricula() {
        Random gerador = new Random(); //Instancia a classe Random
        int min = 10000000;  //Define o valor mínimo para do valor aletório
	    int max = 99999999; //Define o valor máximo para do valor aletório
        return gerador.nextInt(max - min + 1) + min;
    }

    // O métodos toString() é uma forma de polimorfismo dinâmico, que chamamos de
    // sopreposição, já que esse método é definido na classe Pessoa
    // O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o
    // método original.
    @Override
    public String toString() {
        String detalhes = "";
        detalhes += super.toString();
        detalhes += "Salário: " + this.getSalario() + " \n";
        detalhes += "Carga Horária " + this.getCargaHoraria() + " \n";
        return detalhes;
    }

}
