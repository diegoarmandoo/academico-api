package br.com.academico.disciplina;

import java.io.Serializable;

public class Disciplina implements Serializable {

    // Atributos de Instância ou do Objeto

    private String nome;
    private int cargaHoraria;

    //Gets e Sets

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Construtores 

    public Disciplina() {
    }

    //Métodos

    @Override
    public String toString() {
        String detalhes = "";
        detalhes += "Nome: " + this.getNome() + " \n";
        detalhes += "Carga Horária " + this.getCargaHoraria() + " \n";
        return detalhes;
    } 
    

}
