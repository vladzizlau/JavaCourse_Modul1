package by.pvt.core.multi.service.Interface;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.domain.User;

public interface IUserService
    {
    public void register(UserRequest u);
    public UserResponse auth(String l, String p);

        User searchUser(Long id);
        boolean searchLoginUser(String login);
        User getUser(String login);
        void deleteUser(User user);
    }
