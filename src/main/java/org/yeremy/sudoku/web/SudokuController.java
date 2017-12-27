package org.yeremy.sudoku.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.yeremy.sudoku.domain.SudokuService;
import org.yeremy.sudoku.dto.Board;
import org.yeremy.sudoku.dto.InputBoard;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.inject.Inject;

@EnableSwagger2
@RestController
@RequestMapping("/solve")
@Api(value = "/")
public class SudokuController extends WebMvcConfigurerAdapter
{
    @Inject
    private SudokuService sudokuService;

    @SuppressWarnings("serial")
    @RequestMapping(value = "nineByNine", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inputBoard", value = "Sudoku Board", required = true, dataType = "InputBoard")
    })
    @ResponseBody
    public Board solveNineByNine(@RequestBody @ApiParam InputBoard inputBoard)
    {
        return sudokuService.solveNineByNine(inputBoard);
    }

    @SuppressWarnings("serial")
    @RequestMapping(value = "sixteenBySixteen", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inputBoard", value = "Sudoku Board", required = true, dataType = "InputBoard")
    })
    @ResponseBody
    public Board solveSixteenBySixteen(@RequestBody @ApiParam InputBoard inputBoard)
    {
        return sudokuService.solveSixteenBySixteen(inputBoard);
    }
}