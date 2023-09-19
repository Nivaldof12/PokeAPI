package br.com.HighlightServer.domain;

public class DestaqueDTO {
    private String name;
    private String highlight;

    // Construtor que recebe o nome e o highlight
    public DestaqueDTO(String name, String highlight) {
        this.name = name;
        this.highlight = highlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
