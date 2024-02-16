package br.com.csmastery.enums;

public enum SimNao {
    SIM (1),
    NAO(0);
    
    private Integer value;

    SimNao(Integer valor) {
        this.value = valor;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SimNao{" +
                "value=" + value +
                '}';
    }
}
