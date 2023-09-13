package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.popov_am.task4.DAO.UserDaoImpl;
import ru.aston.popov_am.task4.Model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static javax.swing.text.html.parser.DTDConstants.ID;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class UserDaoImplTest {
    UserDaoImpl userDao = Mockito.mock(UserDaoImpl.class);
    User user;
    User userSave;
    User userUpdate;
    Optional<User> userOptional;
    List<User> userList;
    @BeforeEach
    void setUp(){
        user = User.builder().id(1).firstname("A").lastname("B").email("mail").phone("+02").build();
        userSave = User.builder().firstname("A").lastname("B").email("mail").phone("+02").build();
        userUpdate = User.builder().id(1).firstname("TestUpdate").lastname("TestUpdate").email("mail").phone("+02").build();
        userOptional = Optional.of(User.builder().id(55).firstname("Test").lastname("Test").email("mail").phone("+03").build());
        userList = new ArrayList<>();
        userList.add(user);
    }

    @Test
    public void findAll(){
        when(userDao.findAll()).thenReturn(userList);
        List<User> userList1 = new ArrayList<>();
        userList1.add(user);
        Assertions.assertEquals(userDao.findAll(),userList1);
    }
    @Test
    public void findEntityById(){
        when(userDao.findEntityById(anyInt())).thenReturn(userOptional);
        Assertions.assertEquals(userDao.findEntityById(ID),userOptional);
    }
    @Test
    public void deleteUserById(){
    when(userDao.delete(anyInt())).thenReturn(true);
    Assertions.assertTrue(userDao.delete(ID));
    }
    @Test
    public void create(){
     when(userDao.create(userSave)).thenReturn(user);
        Assertions.assertEquals(userDao.create(userSave),user);
    }
    @Test
    public void update(){
        when(userDao.update(user)).thenReturn(true);
        Assertions.assertTrue(userDao.update(user));
    }
}
