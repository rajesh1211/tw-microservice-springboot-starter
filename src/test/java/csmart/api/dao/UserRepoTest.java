package csmart.api.dao;

import csmart.AbstractTest;
import csmart.api.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Rajesh Raikwar on 2/10/2016.
 */

public class UserRepoTest extends AbstractTest{
    @Autowired
    private UserRepo userRepo;

    private User user;

    @Before
    public void createUser() {
        user = new User();
        user.setId(1);
        user.setEmail("email");
        user.setPassword("password");
        user.setName("Rajesh Raikwar");
    }

    @Test
    public void shouldInsertUserInDb(){
        userRepo.createUser(user);
        User returnedUsed = userRepo.getUserById(1);
        Assert.assertEquals(returnedUsed.getPassword(), user.getPassword());
    }
}