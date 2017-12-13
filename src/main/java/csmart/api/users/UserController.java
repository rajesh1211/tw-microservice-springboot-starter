package csmart.api.users;

import csmart.api.db.UserRepo;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sethur on 1/10/2016.
 */
@RestController("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

//    @PostMapping("/create")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createUser(@RequestBody User user){
        userRepo.createUser(user);
    }

    @GetMapping()
    public @ResponseBody User getUser(@RequestParam("emailId") String emailId){
        return userRepo.getUser(emailId);
    }
}
