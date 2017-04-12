package org.yeremy.sudoku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.yeremy.sudoku")
public class SudokuApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SudokuApplication.class, args);
    }

}
