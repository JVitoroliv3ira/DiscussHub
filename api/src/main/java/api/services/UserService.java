package api.services;

import api.contracts.ICrudService;
import api.models.User;
import api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements ICrudService<User, Long, UserRepository> {
    private final UserRepository repository;

    @Override
    public UserRepository getRepository() {
        return this.repository;
    }

    @Override
    public String getEntityNotFoundErrorMessage() {
        return "Usuário não encontrado na base de dados.";
    }
}
