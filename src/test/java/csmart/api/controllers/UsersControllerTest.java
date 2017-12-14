package csmart.api.controllers;

import csmart.AbstractControllerTest;
import csmart.api.model.User;
import csmart.api.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UsersControllerTest extends AbstractControllerTest{

    @MockBean
    private UserService service;

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testGetUsers() throws Exception {
        List<User> users =  new ArrayList<>();
        users.add(new User(1, "a@1.com", "Darth Vader"));
        users.add(new User(2, "a@2.com", "R2D2"));
        users.add(new User(3, "a@3.com", "C3PO"));
        when(service.getUsers()).thenReturn(users);
        String uri = "/users";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);

        User[] userArray = mapFromJson(content, User[].class);
        Assert.assertEquals(userArray[0].getName(), "Darth Vader");
        Assert.assertEquals(userArray[1].getName(), "R2D2");
        Assert.assertEquals(userArray[2].getName(), "C3PO");
    }


}
