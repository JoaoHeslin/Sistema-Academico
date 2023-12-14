package SistemaAcademico;

import java.util.ArrayList;
import java.util.List;

public class Turma {


    private int codigo;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private Pofessor pofessor;
    private Curso curso;
    
    public Turma(int codigo, Disciplina disciplina){
        if (codigo<0) throw new IllegalArgumentException("O código da turma não pode ser negativo");
        if (disciplina == null) throw new IllegalArgumentException("A disciplina passada para a turma não pode ser null");
        this.disciplina = disciplina;
        alunos = new ArrayList<>();
        this.curso = new Curso();
    }

    public int getCodigo() {
        return this.codigo;
    }
    public void setProfessor(Pofessor professor){
        if (professor == null) throw new IllegalArgumentException("Turma não pode receber um professor null");
        this.pofessor = professor;
    }
    public Pofessor getProfessor(){
        return pofessor;
    }
    public void matricularAluno(Aluno aluno) throws Exception {
        if (!curso.isAlunoCadastrado(aluno.getMatricula())) throw new Exception("Não deve ser possível matricular um aluno em uma turma se este aluno não estiver cadastrado no curso da disciplina");
        this.alunos.add(aluno);
    }
    public List<Aluno> getAlunos(){
        return this.alunos;
    }
    public Aluno getAlunos(String matricula){
        for (Aluno aluno: this.alunos){
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) return aluno;
        }
        return null;
    }
    public Disciplina getDisciplina(){
        return this.disciplina;
    }
}
