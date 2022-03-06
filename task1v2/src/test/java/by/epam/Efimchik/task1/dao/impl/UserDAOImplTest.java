package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.User;
import junit.framework.TestCase;

import org.junit.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAOImplTest extends TestCase {
    private UserDAOImpl userDAO;
    private User user;

    @Before
    public void setUp() {
        user = new User(123, "testEmail1@email.com", "testUsername1", "testPassword1", false);

        try {
            userDAO = new UserDAOImpl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        userDAO = null;
    }

    @Test
    public void testAdd() {
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<User> userList = userDAO.allUsers();
        Assert.assertEquals(user.getUsername(), userList.get(5).getUsername());
    }

    @Test
    public void testUpdate() throws DAOException {
        try {
            userDAO.update(user, new String[]{String.valueOf(777), "qwerty@qwerty.com", "Qwerty", "Qwerty1234", String.valueOf(true)});
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("qwerty@qwerty.com", user.getEmail());
    }

    @Test
    public void testAllUsers() {
        List<User> userList = userDAO.allUsers().stream().distinct().collect(Collectors.toList());

        Assert.assertEquals(6, userList.size());
    }

    @Test
    public void testUserById() {
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        User testUser = userDAO.userById(123);

        Assert.assertEquals(user.getUserId(), testUser.getUserId());
        Assert.assertEquals(user.getEmail(), testUser.getEmail());
        Assert.assertEquals(user.getUsername(), testUser.getUsername());
        Assert.assertEquals(user.getPassword(), testUser.getPassword());
    }

    @Test
    public void testSearchUser() throws DAOException {
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        User searchUser = userDAO.searchUser(user.getUsername(), user.getPassword());
        Assert.assertEquals(user.getUserId(), searchUser.getUserId());
        Assert.assertEquals(user.getEmail(), searchUser.getEmail());
        Assert.assertEquals(user.getUsername(), searchUser.getUsername());
        Assert.assertEquals(user.getPassword(), searchUser.getPassword());
    }

    @Test
    public void testRemove() {
        User user1 = new User(777, "qwerty@qwerty.com", "qwerty123", "Qwerty1234", false);

        try {
            userDAO.add(user1);
            userDAO.remove(777);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<User> userList = userDAO.allUsers().stream().distinct().collect(Collectors.toList());

        Assert.assertEquals(6, userList.size());
    }

    @Test
    public void testIsUsernameExist() throws DAOException {
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(!userDAO.isUsernameExist(user.getUsername()));
    }

    @Test
    public void testIsEmailExist() throws DAOException {
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(!userDAO.isEmailExist(user.getEmail()));
    }

    @Test
    public void testIsPasswordExist() throws DAOException {

        try {
            userDAO.add(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(!userDAO.isPasswordExist(user.getUsername(), user.getPassword()));
    }
}