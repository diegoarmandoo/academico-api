import java.util.Random;

public class Professor extends Pessoa {
    
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

}
