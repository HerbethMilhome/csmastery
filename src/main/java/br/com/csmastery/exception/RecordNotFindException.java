package br.com.csmastery.exception;

public class RecordNotFindException extends RuntimeException {

    public RecordNotFindException(String id) {
        super("Registro não encontrado com id: " + id);
    }

}
