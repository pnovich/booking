package com.example.springdata2.Service;

import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Repository.UserTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTableServiceTest {
    @Autowired
    private UserTableService userTableService;

    @MockBean
    private UserTableRepository userTableRepository;

    @Test
    public void testCreateBock(){
        UserTable userTable = new UserTable();
        userTable.setUserName("ivas");

        Mockito.when(userTableRepository.save(userTable)).thenReturn(userTable);
        assertThat(userTableService.createUser(userTable)).isEqualTo(userTable);
    }

    @Test
    public void getByIdTest(){
        UserTable userTable = new UserTable();
        userTable.setUserName("ivas");
        Mockito.when(userTableRepository.findOne((long)1)).thenReturn(userTable);
        assertThat(userTableService.findUserTable((long)1).getUserName()).isEqualTo(userTable.getUserName());
    }


}
