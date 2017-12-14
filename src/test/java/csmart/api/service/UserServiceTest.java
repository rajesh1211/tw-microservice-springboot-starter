package csmart.api.service;

import csmart.AbstractTest;
import csmart.api.dao.UserRepo;
import csmart.api.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

public class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService service;

    @MockBean
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
    public void shouldGetTheUserFromService(){
        when(userRepo.getUserById(1)).thenReturn(user);
        Assert.assertEquals(service.getUserById(1).getId(), user.getId());
    }
}
