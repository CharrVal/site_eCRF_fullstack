import { ChangeDetectorRef, Component } from '@angular/core';
import { Patient } from '../../../../interfaces/patients/patient';
import { ActivatedRoute } from '@angular/router';
import { StudyService } from '../../../../services/studies/study-service';

@Component({
  selector: 'app-patient-list',
  imports: [],
  templateUrl: './patient-list.html',
  styleUrl: './patient-list.css',
})
export class PatientList {
  patients: Patient[] = [];
  errorMessage: string | null = "";

  constructor(private studyService: StudyService, private cdr: ChangeDetectorRef, private route: ActivatedRoute,) {}

  ngOnInit(): void {
    const studyId = this.route.snapshot.paramMap.get('studyId');
    if (studyId) {
    this.loadPatients(Number(studyId));
    }
  }

  loadPatients(studyId: number): void {
    this.studyService.getPatientsByStudy(studyId).subscribe({
    next: (data) => {
      this.patients = data;
      this.cdr.markForCheck();
      },
    error: (err) => {
      this.errorMessage = 'Erreur lors du chargement des patients';
      console.error(err);
      this.cdr.markForCheck();
      }
    });
  }
}
