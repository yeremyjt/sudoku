package org.yeremy.sudoku.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.yeremy.sudoku.controller.SudokuController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SudokuController.class)
@WebAppConfiguration
public class SudokuControllerTests
{
    @Test
    public void contextLoads()
    {
    }
}
