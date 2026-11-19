package br.com.estoque;

public enum Categoria {
    JOGO("Jogo"),
    SERIE("Série"),
    FILME("Filme");

    private final String rotulo;

    Categoria(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }
}
