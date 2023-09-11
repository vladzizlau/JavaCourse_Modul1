package by.pvt.core.multi.service.Interface;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.domain.User;

public interface IUserService {
    public boolean register(UserRequest u);

    public UserResponse auth(String l, String p);

    User getUser(String login);

    void deleteUser(User user);
}
