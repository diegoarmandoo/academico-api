package br.com.academico.turma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.academico.aluno.Aluno;
import br.com.academico.disciplina.Disciplina;
import br.com.academico.professor.Professor;
import br.com.academico.sala.Sala;

public class Turma implements Serializable {

    // Atributos de Instância ou do Objeto

    private String nome;
    private String periodo;
    private double mediaTurma;
    private Professor professor; // Associação Estrutural - Agregação - A partir de atributo
    private Disciplina disciplina; // Associação Estrutural - Agregação - A partir de atributo
    private List<Aluno> alunos = new ArrayList<Aluno>(); // Associação Estrutural - Agregação - A partir de atributo
    private List<Sala> salas = new ArrayList<Sala>(); // Associação Estrutural - Agragação - A partir de atributo

    // Gets e Sets

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getMediaTurma() {
        return mediaTurma;
    }

    public void setMediaTurma(double mediaTurma) {
        this.mediaTurma = mediaTurma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    //Construtor

    public Turma() {
    }

    //Metódos

    @Override
    public String toString() {
        String detalhes = "";
        detalhes += super.toString();
        detalhes += "Nome: " + this.getNome() + " \n";
        detalhes += "Periodo: " + this.getPeriodo() + " \n";
        detalhes += "Média da Turma: " + this.getMediaTurma() + " \n";
        detalhes += "Professor -------------------------------------------------------------------\n";
        detalhes += this.getProfessor() + " \n";
        detalhes += "Disciplina ------------------------------------------------------------------\n";
        detalhes += this.getDisciplina() + " \n";
        detalhes += "Alunos ----------------------------------------------------------------------\n";
        detalhes += this.getAlunos() + " \n";
        detalhes += "Salas -----------------------------------------------------------------------\n";
        detalhes += this.getSalas() + " \n";
        return detalhes;
    } 

    public void calcularMediaTurma(){
        double somatorio = 0;
        for (Aluno aluno: this.getAlunos()){
            somatorio += aluno.getMedia();
        }
        this.setMediaTurma(somatorio / this.getAlunos().size());
    }
    

}
