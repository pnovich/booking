package com.example.springdata2.Service;


import com.example.springdata2.Entities.Category;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Repository.CategoryRepository;
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
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void getByIdTest(){
//        Room room = new Room();
        Category category = new Category(1,"r",5,10);
//        room.setCategory(category);
        Mockito.when(categoryRepository.findOne((long)1)).thenReturn(category);
        assertThat(categoryService.findCategory((long)1).getCategoryName()).isEqualTo(category.getCategoryName());
    }


}
