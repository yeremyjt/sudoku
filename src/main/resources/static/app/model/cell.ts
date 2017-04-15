export class Cell {
  value: string;
  possibilities: string[];

  constructor(value: string, possibilities: string[]) {
    this.value = value;
    this.possibilities = possibilities;
  }
}
