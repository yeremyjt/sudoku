import { Injectable } from 'angular2/core';
import { Http } from 'angular2/http';
import { Headers} from 'angular2/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { InputBoard } from '../model/input-board';
import { Board } from '../model/board';
import { Component } from 'angular2/core';
import { HTTP_PROVIDERS } from 'angular2/http';

@Component({
    providers: [HTTP_PROVIDERS]
})

@Injectable()
export class SudokuService {

  constructor(private http: Http) {}

  solve(url: string, inputBoard: InputBoard): Observable<Board> {
    let bodyString = JSON.stringify(inputBoard);
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http
               .post(url, bodyString, headers)
               .map(response => response.json().data as Board);
  }
}
