package SistemaAcademico;


import java.util.Objects;


public class Aluno {
    private String matricula;
    private String nome;

    public Aluno(String matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    public Aluno(){
        this(null,"");
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        if (matricula == null){
            throw new IllegalArgumentException("A matricula não pode ser ser mudada para nulo!");
        }
        if (!matricula.matches("\\d+"))
            throw new IllegalArgumentException("Matricula Invalida! Matricula deve ser numerica! matricula='ddjsd'");
        this.matricula =  matricula;

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Não deve ser possível atribuir o valor `null` ao nome da classe Aluno");
        this.nome = nome;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula.equals(aluno.matricula) && nome.equals(aluno.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome);
    }
}

