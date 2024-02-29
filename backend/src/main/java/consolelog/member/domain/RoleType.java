package consolelog.member.domain;

// 수정 필요
// Getter 사용할 수 있는 것은 Getter 사용할 것
public enum RoleType {
    USER("USER"), ADMIN("ADMIN");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNot(String roleType) {
        return !this.name.equals(roleType);
    }

}
