package SistemaAcademico;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunosMatriculados;
    
    public Curso(){
        this("");
    }
    public Curso(String nome){
        this.nome = nome;
        disciplinas = new ArrayList<>();
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) throw new IllegalArgumentException("O nome do curso não pode ser null");
        this.nome = nome;
    }
    public Disciplina criarDisciplina(String codigo, String nome) throws Exception {
        if (codigo.trim().isEmpty()) throw new Exception("O código da disciplina não pode ser vazio");
        for (Disciplina disciplina: disciplinas){
            if (disciplina.getCodigo().equalsIgnoreCase(codigo)) throw new Exception("Não podem existir duas disciplinas com o mesmo código");
        }
        Disciplina disciplininha = new Disciplina(this,codigo,nome);
        this.disciplinas.add(disciplininha);
        return disciplininha;
    }
    public Disciplina getDisciplina(String codigo){
        for (Disciplina discipla: this.disciplinas){
            if (discipla.getCodigo().equals(codigo)) return discipla;
        }
        return null;
    }
    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }
    public void cadastrarAlunos(Aluno aluno) throws Exception {
        if (alunosMatriculados.contains(aluno)) throw new Exception("Não é possível cadastrar o mesmo aluno mais de uma vez no Curso");
        for (Aluno aluno1: alunosMatriculados){
            if (aluno1.getMatricula() == aluno.getMatricula()) throw new Exception("Não é possível cadastrar dois alunos com a mesma matrícula");
        } alunosMatriculados.add(aluno);
    }
    public List<Aluno> getAlunos(){
        return this.alunosMatriculados;
    }
    public Aluno getAluno(String matricula){
        for (Aluno aluno: this.alunosMatriculados){
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) return aluno;
        }
        return null;
    }
    public boolean isAlunoCadastrado(String matricula){
        for (Aluno aluno: this.alunosMatriculados){
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) return true;
        }
        return false;
    }
}
