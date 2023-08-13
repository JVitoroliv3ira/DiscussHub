package api.models;

import api.contracts.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(schema = "discuss_hub", name = "tb_users")
@Entity
public class User implements IEntity<Long> {
    @Id
    @SequenceGenerator(name = "sq_users", schema = "discuss_hub", sequenceName = "sq_users", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_users")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, password);
    }
}
