package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
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
    }

    @Test
    public void delete()
    {
    }

    @Test
    public void findByName()
    {
    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}