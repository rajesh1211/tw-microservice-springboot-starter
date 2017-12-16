package csmart.api.service;

import csmart.api.dao.UserRepo;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


/* This class is not being used for the task , it was the part of starter kit*/
@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        return userRepo.createUser(user);
    }

    public User getUserById(int id){
        return userRepo.getUserById(id);
    }

    public List<User> getUsers(){
        try {
            return userRepo.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User updateUserById(User user){
        return userRepo.updateUserById(user);
    }
}
