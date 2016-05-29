package org.yeremy.sudoku.controller;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yeremy.sudoku.domain.SudokuService;
import org.yeremy.sudoku.dto.Board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@ComponentScan("org.yeremy.sudoku")
@RequestMapping("/")
@Api(value = "/")
public class SudokuController
{
    @Inject
    SudokuService sudokuService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String home()
    {
        return "Hello World!";
    }

    @RequestMapping(value = "solve", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "board", value = "Sudoku Board", required = true, dataType = "Board")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Board.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure") })
    @ResponseBody
    public Board solveSudoku(@RequestBody Board board)
    {
        return sudokuService.solve(board);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SudokuController.class, args);
    }
}