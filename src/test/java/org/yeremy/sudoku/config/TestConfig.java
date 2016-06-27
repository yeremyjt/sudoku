package org.yeremy.sudoku.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.yeremy.sudoku.strategies", "org.yeremy.sudoku.search" })
public class TestConfig
{
}
