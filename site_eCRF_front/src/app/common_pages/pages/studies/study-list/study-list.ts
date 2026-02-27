import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Study } from '../../../../interfaces/studies/study';

@Component({
  selector: 'app-study-list',
  imports: [RouterLink],
  templateUrl: './study-list.html',
  styleUrl: './study-list.css',
})
export class StudyList {

  studies: Study[] = [];

}
