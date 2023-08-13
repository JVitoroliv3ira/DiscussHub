package api.dtos.responses.auth;

import api.models.User;
import lombok.Data;

@Data
public class AuthenticatedUserResponseDTO {
    private final User user;
    private final String token;
}
