package org.yeremy.sudoku.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.yeremy.sudoku.domain.SudokuService;
import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.InputBoard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/")
@Api(value = "/")
public class SudokuController extends WebMvcConfigurerAdapter
{
    @Inject
    private SudokuService sudokuService;

    @SuppressWarnings("serial")
    @RequestMapping(value = "solve", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inputBoard", value = "Sudoku Board", required = true, dataType = "InputBoard")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Board.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure") })
    @ResponseBody
    public Board solveSudoku(@RequestBody @ApiParam InputBoard inputBoard)
    {
        final List<String> characters = new ArrayList<String>()
        {
            {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
                add("7");
                add("8");
                add("9");
            }
        };
        return sudokuService.solve(inputBoard, characters);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}