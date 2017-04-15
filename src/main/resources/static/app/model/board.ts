import { Cell} from './cell';

export class Board {
  matrix: Cell[][];
  solved: boolean;
  hasChanged: boolean;

  constructor(matrix:  Cell[][], solved: boolean, hasChanged: boolean) {
    this.matrix = matrix;
    this.solved = solved;
    this.hasChanged = hasChanged;
  }
}
