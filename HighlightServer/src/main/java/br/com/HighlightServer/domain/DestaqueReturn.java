package br.com.HighlightServer.domain;

import java.util.List;

public class DestaqueReturn {
    private List<DestaqueDTO> result;

    // Construtor que recebe a lista de DestaqueDTO
    public DestaqueReturn(List<DestaqueDTO> result) {
        this.result = result;
    }

    public List<DestaqueDTO> getResult() {
        return result;
    }

    public void setResult(List<DestaqueDTO> result) {
        this.result = result;
    }
}
