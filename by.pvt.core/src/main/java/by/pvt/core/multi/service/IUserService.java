package by.pvt.core.multi.service;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;

public interface IUserService
    {
    public void register(UserRequest u);
    public UserResponse auth(String l, String p);

    }
