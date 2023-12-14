package SistemaAcademico;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private Curso curso;
    private String codigo;
    private String nome;
    private List<Turma> turmas;

    public Disciplina(Curso curso, String codigo, String nome){
        if (codigo == null)throw new IllegalArgumentException("O codigo da disciplina não pode ser `null`");
        if (curso == null) throw new IllegalArgumentException("O curso da disciplina não pode ser `null`");
        this.curso = curso;
        this.codigo = codigo;
        turmas = new ArrayList<>();
        this.nome = nome;
    }
    public Turma criarTurma(){
        Turma turminha = new Turma(turmas.size()+1, this);
        this.turmas.add(turminha);
        return turminha;
    }
    public Turma getTurma(int numero){
        for (Turma turma: turmas){
            if (turma.getCodigo() == numero) return turma;
        }
        throw new RuntimeException("Turma não encontrada");
    }
    public List<Turma> getTurmas() {
        return this.turmas;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }
    public Curso getCurso(){
        return this.curso;
    }

    public void setNome(String nome) {
        if (nome == null) throw new IllegalArgumentException("O nome da disciplina não pode ser nulo");
        this.nome = nome;
    }
}
