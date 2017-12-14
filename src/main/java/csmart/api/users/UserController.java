package csmart.api.users;

import csmart.api.db.UserRepo;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rajesh Raikwar on 14/12/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public User createUser(@RequestBody User user){
        return userRepo.createUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUserById(@PathVariable("id") int id){
        return userRepo.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers(){
        try {
            return userRepo.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUserById(@RequestBody User user){
        return userRepo.updateUserById(user);
    }

}
