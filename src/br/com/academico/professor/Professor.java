package br.com.academico.professor;
import java.util.Random;

import br.com.academico.evento.IEvento;
import br.com.academico.pessoa.Pessoa;
import br.com.academico.projeto.IProjeto;

public class Professor extends Pessoa implements IProjeto,IEvento {

    // Atributos de Instância ou do Objeto
		
    private double salario;
    private int cargaHoraria;
    
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

    @Override
    public void submeterProjetoExtensao() {
        System.out.println("1- Professor escolhe a area de atuação da extensão");
		System.out.println("2- Professor escreve o projeto de extensão");
		System.out.println("3- Professor seleciona alunos para o projeto, se necessário");
		System.out.println("4- Projeto é avaliado pela setor de extensão da instituição");
    }

    @Override
    public void submeterProjetoPesquisa() {
        System.out.println("1- Professor escolhe a area de pesquisa");
		System.out.println("2- Professor escreve o projeto de pesquisa");
		System.out.println("3- Professor apresenta documentação para concorrer ao finciamento da pesquisa");
		System.out.println("4- Professor seleciona alunos para o projeto, se necessário");
	    System.out.println("5- Projeto é avaliado pela setor de pesquisa da instituição");
    }

    @Override
    public void inscrever() {
        System.out.println("1 -Inscrição de professor no evento");
		System.out.println("2- Gerar boleto de pagamento para o Professor");
    }

    

}
