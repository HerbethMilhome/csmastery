package br.com.csmastery.login.usuario.enums;

public enum UsuarioRole {

    ADMIN("admin"),
    ALUNO("aluno"),
    CS("cs");

    private String role;

    UsuarioRole(String admin) {

    }

    void UserRole (String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
