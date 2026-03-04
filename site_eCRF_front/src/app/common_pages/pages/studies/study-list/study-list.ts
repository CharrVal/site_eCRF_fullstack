import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Study } from '../../../../interfaces/studies/study';
import { StudyService } from '../../../../services/studies/study-service';

@Component({
  selector: 'app-study-list',
  imports: [],
  templateUrl: './study-list.html',
  styleUrl: './study-list.css',
})
export class StudyList implements OnInit {

  studies: Study[] = [];
  errorMessage: string | null = "";

  constructor(private studyService: StudyService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadStudies();
  }

  loadStudies(): void {
    this.studyService.getAll().subscribe({
      next: (data) => {
        this.studies = data;
        this.cdr.markForCheck();
      },
      error: (err) => {
        this.errorMessage = 'Erreur lors du chargement des études';
        console.error(err);
        this.cdr.markForCheck();
      }
    });
  }
}
