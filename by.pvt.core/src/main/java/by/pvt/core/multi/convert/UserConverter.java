package by.pvt.core.multi.convert;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.domain.User;

public class UserConverter
    {
//из объекта в сущность
    public User userToEntity(UserRequest req)
    {
        User user = new User();
        user.setLogin(req.getLogin());
        user.setPassword(req.getPassword());
        user.setFirstName(req.getFirstName());
        user.setSurName(req.getSurName());
        user.setEmail(req.getEmail());
        user.setPhoneNumber(req.getPhone());

        return user;
    }
    //Из сущности в объект
    public UserResponse userToDTO(User user){
        UserResponse ur = new UserResponse();
        ur.setId(user.getId());
        ur.setLogin(user.getLogin());
        ur.setEmail(user.getEmail());
        ur.setFirstName(user.getFirstName());
        ur.setSurName(user.getSurName());
        ur.setFull_name(user.getFullName());
        ur.setPhone(user.getPhoneNumber());
        ur.setRole(user.getRole());
        return ur;
    }


}
