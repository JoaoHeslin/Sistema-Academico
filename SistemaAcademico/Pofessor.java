package SistemaAcademico;

public class Pofessor {
    private String slape, nome;
    public Pofessor(String slape, String nome){
        if (slape == null) throw new IllegalArgumentException("O siape não pode ser null");
        if (slape.trim().isEmpty()) throw new IllegalArgumentException("O siape não pode ser vazio");
        if (!slape.matches("\\d+")) throw new IllegalArgumentException("O siape deve ser um número");
        this.slape = slape;
        this.nome = nome;
    }
    public String getSlape() {
        return slape;
    }

    public void setSlape(String slape) {
        this.slape = slape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) throw new IllegalArgumentException("O nome não pode ser null");
        if (nome.trim().isEmpty()) throw new IllegalArgumentException("O nome não pode ser vazio");
        this.nome = nome;
    }
}