package api.igreja_on.usuario.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    MODERATOR("moderator");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
