import {RouteDefinition} from 'angular2/router';
import {TodolistComponent} from './todolist/todolist.component';
import {SimplebindComponent} from './simplebind/simplebind.component';
import {NineByNineComponent} from './nine-by-nine/nine-by-nine.component';

export var APP_ROUTES: RouteDefinition[] = [
    { path: '/nine-by-nine', name: '9 by 9', component: NineByNineComponent, useAsDefault: true },
    { path: '/simplebind', name: '16 by 16', component: SimplebindComponent },
    { path: '/todolist', name: 'Todolist', component: TodolistComponent }
];
