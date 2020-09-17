package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;

//use the database

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
public class UserServiceImplTest
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Before
    public void setUp() throws Exception
    {
        //mocks -> fake data
        //stubs -> fake methods
        //java-> mocks
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findUserById()
    {
        assertEquals("cinnamon", userService.findUserById(7).getUsername());
    }

    @Test
    public void findByNameContaining()
    {
        assertEquals(2, userService.findByNameContaining("tt").size());
    }

    @Test
    public void findAll()
    {
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void delete()
    {
        userService.delete(13);
        assertEquals(4, userService.findAll().size());
    }

    @Test
    public void findByName()
    {
        assertEquals(14, userService.findByName("misskitty").getUserid());
    }

    @Test
    public void save()
    {
        String username = "happy";
        Role r1 = roleService.findByName("admin");
        Role r2 = roleService.findByName("user");

        User user = new User("happy",
            "password",
            "happy@example.com");
        user.getRoles().add(new UserRoles(user, r1));
        user.getRoles().add(new UserRoles(user, r2));

        User addUser = userService.save(user);
        assertNotNull(addUser);
        assertEquals(username, addUser.getUsername());
    }

    @Test
    public void update()
    {
        String username = "happy";
        Role r2 = roleService.findByName("user");

        User user = new User("happy",
            "password",
            "happy@example.com");
        user.getRoles().add(new UserRoles(user, r2));
        user.setUserid(13);
        User addUser = userService.update(user, 13);

        assertNotNull(addUser);
        assertEquals(username, addUser.getUsername());
    }

    @Test
    public void deleteAll()
    {
        userService.deleteAll();;
        assertEquals(0, userService.findAll().size());
    }
}