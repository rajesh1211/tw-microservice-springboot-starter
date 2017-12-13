package csmart.api.users;

import csmart.api.db.UserRepo;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sethur on 1/10/2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createUser(@RequestBody User user){
        userRepo.createUser(user);
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


}
