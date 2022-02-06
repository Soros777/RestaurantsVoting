package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity{

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
                    uniqueConstraints = {@UniqueConstraint(name = "user_role_unique_ctx", columnNames = {"user_id", "role"})})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(name = "voret_today", nullable = false, columnDefinition = "boolean default false")
    private boolean votedToday = false;

    public User() {
    }

    public User(Integer id, Set<Role> roles) {
        super(id);
        this.roles = roles;
    }

    public User(Set<Role> roles) {
        this(null, roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isVotedToday() {
        return votedToday;
    }

    public void setVotedToday(boolean votedToday) {
        this.votedToday = votedToday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + roles +
                ", votedToday=" + votedToday +
                '}';
    }
}
