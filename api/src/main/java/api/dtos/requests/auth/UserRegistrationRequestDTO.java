package api.dtos.requests.auth;

import api.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequestDTO {
    @NotNull(message = "É necessário informar um nome.")
    @Size(min = 5, max = 50, message = "O nome deve conter entre {min} e {max} caracteres.")
    private final String name;
    @NotNull(message = "É necessário informar um nome de usuário.")
    @Size(min = 5, max = 30, message = "O nome de usuário deve conter entre {min} e {max} caracteres.")
    private final String username;
    @NotNull(message = "É necessário informar um email.")
    @Size(min = 8, max = 80, message = "O email deve conter entre {min} e {max} caracteres.")
    @Email(message = "O email informado é inválido.")
    private final String email;
    @NotNull(message = "É necessário informar uma senha.")
    @Size(min = 8, max = 120, message = "A senha deve conter entre {{min} e {max} caracteres.")
    private final String password;

    public User convert() {
        return User.builder()
                .name(this.getName())
                .username(this.getUsername())
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }
}
