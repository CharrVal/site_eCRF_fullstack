import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Patient } from '../../../../interfaces/patients/patient';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { StudyService } from '../../../../services/studies/study-service';
import { PatientService } from '../../../../services/patients/patient-service';

@Component({
  selector: 'app-patient-list',
  imports: [RouterModule],
  templateUrl: './patient-list.html',
  styleUrl: './patient-list.css',
})
export class PatientList implements OnInit {

  patients: Patient[] = [];
  errorMessage: string | null = null;

  constructor(private patientService: PatientService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients(): void {
    this.patientService.getAll().subscribe({
      next: data => {
        this.patients = data;
        this.cdr.markForCheck();
      },
      error: err => {
        this.errorMessage = 'Erreur lors du chargement des patients';
        console.error(err);
      }
    });
  }

  deletePatient(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer ce patient ?')) {
      this.patientService.delete(id).subscribe({
        next: () => this.loadPatients(),
        error: err => console.error(err)
      });
    }
  }
}
