import { Component } from 'angular2/core';
import { InputBoard } from '../model/input-board';
// import { SudokuService } from './sudoku.service';
// import { HTTP_PROVIDERS} from 'angular2/http';

@Component({
    selector: 'nine-by-nine',
    templateUrl: 'app/nine-by-nine/nine-by-nine.html',
    styleUrls: [
        'app/nine-by-nine/nine-by-nine.css'
    ],
    // providers: [SudokuService, HTTP_PROVIDERS]
})

export class NineByNineComponent {
  // sudokuService: SudokuService;
  inputBoard: InputBoard;
  url: string = 'http://localhost:8080';
  clickMessage = '';
  cell0: string;
  cell1: string;
  cell2: string;
  cell3: string;
  cell4: string;
  cell5: string;
  cell6: string;
  cell7: string;
  cell8: string;
  cell9: string;
  cell10: string;
  cell11: string;
  cell12: string;
  cell13: string;
  cell14: string;
  cell15: string;
  cell16: string;
  cell17: string;
  cell18: string;
  cell19: string;
  cell20: string;
  cell21: string;
  cell22: string;
  cell23: string;
  cell24: string;
  cell25: string;
  cell26: string;
  cell27: string;
  cell28: string;
  cell29: string;
  cell30: string;
  cell31: string;
  cell32: string;
  cell33: string;
  cell34: string;
  cell35: string;
  cell36: string;
  cell37: string;
  cell38: string;
  cell39: string;
  cell40: string;
  cell41: string;
  cell42: string;
  cell43: string;
  cell44: string;
  cell45: string;
  cell46: string;
  cell47: string;
  cell48: string;
  cell49: string;
  cell50: string;
  cell51: string;
  cell52: string;
  cell53: string;
  cell54: string;
  cell55: string;
  cell56: string;
  cell57: string;
  cell58: string;
  cell59: string;
  cell60: string;
  cell61: string;
  cell62: string;
  cell63: string;
  cell64: string;
  cell65: string;
  cell66: string;
  cell67: string;
  cell68: string;
  cell69: string;
  cell70: string;
  cell71: string;
  cell72: string;
  cell73: string;
  cell74: string;
  cell75: string;
  cell76: string;
  cell77: string;
  cell78: string;
  cell79: string;
  cell80: string;

  //  constructor(sudokuService: SudokuService) {
  //    this.sudokuService = sudokuService;
  //  }
   //


  solveNineByNine() {
    this.inputBoard = new InputBoard([
      [this.cell0, this.cell1, this.cell2, this.cell3, this.cell4, this.cell5, this.cell6, this.cell7, this.cell8],
      [this.cell9, this.cell10, this.cell11, this.cell12, this.cell13, this.cell14, this.cell15, this.cell16, this.cell17],
      [this.cell18, this.cell19, this.cell20, this.cell21, this.cell22, this.cell23, this.cell24, this.cell25, this.cell26],
      [this.cell27, this.cell28, this.cell29, this.cell30, this.cell31, this.cell32, this.cell33, this.cell34, this.cell35],
      [this.cell36, this.cell37, this.cell38, this.cell39, this.cell40, this.cell41, this.cell42, this.cell43, this.cell44],
      [this.cell45, this.cell46, this.cell47, this.cell48, this.cell49, this.cell50, this.cell51, this.cell52, this.cell53],
      [this.cell54, this.cell55, this.cell56, this.cell57, this.cell58, this.cell59, this.cell60, this.cell61, this.cell62],
      [this.cell63, this.cell64, this.cell65, this.cell66, this.cell67, this.cell68, this.cell69, this.cell70, this.cell71],
      [this.cell72, this.cell73, this.cell74, this.cell75, this.cell76, this.cell77, this.cell78, this.cell79, this.cell80]
    ]);

    let bodyString = JSON.stringify(this.inputBoard);


    this.cell0 = 'A';
    this.cell1 = this.cell4;
    this.cell2 = this.cell4;
    console.log(this.inputBoard.getMatrix());
    console.log(bodyString);


    // this.clickMessage = this.inputBoard.getMatrix();
  }
}
