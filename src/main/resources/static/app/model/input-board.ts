export class InputBoard {
  matrix: string[][];

  constructor(matrix: string[][]) {
    this.matrix = matrix;
  }

  getMatrix() {
    return this.matrix;
  }
}
