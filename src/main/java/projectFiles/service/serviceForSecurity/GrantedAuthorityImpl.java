package projectFiles.service.serviceForSecurity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

public class GrantedAuthorityImpl implements GrantedAuthority {
    private String role;

    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantedAuthorityImpl that = (GrantedAuthorityImpl) o;
        return Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}