import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Study } from '../../interfaces/studies/study';
import { Patient } from '../../interfaces/patients/patient';
import { Visit } from '../../interfaces/visits/visit';
import { VitalSign } from '../../interfaces/vitalsign/vitalSign';
import { StudyService } from '../../services/studies/study-service';
import { PatientService } from '../../services/patients/patient-service';
import { VisitService } from '../../services/visits/visit-service';
import { VitalSignService } from '../../services/vitalSigns/vital-sign-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-accueil',
  imports: [DatePipe,FormsModule],
  templateUrl: './accueil.html',
  styleUrl: './accueil.css',
})
export class Accueil implements OnInit {
  studies: Study[] = [];
  selectedStudyId!: number;

  patients: Patient[] = [];
  selectedPatient!: Patient;

  visits: Visit[] = [];
  selectedVisit!: Visit;

  vitals: VitalSign[] = [];

  constructor(
    private studyService: StudyService,
    private patientService: PatientService,
    private visitService: VisitService,
    private vitalSignService: VitalSignService
  ) {}

  ngOnInit(): void {
    this.loadStudies();
  }

  loadStudies(): void {
    this.studyService.getAll().subscribe(studies => this.studies = studies);
  }

  onStudyChange(): void {
    if (this.selectedStudyId) {
      this.patientService.getByStudyId(this.selectedStudyId).subscribe(patients => {
        this.patients = patients;
        this.selectedPatient = undefined!;
        this.visits = [];
        this.selectedVisit = undefined!;
        this.vitals = [];
      });
    }
  }

  selectPatient(patient: Patient): void {
    this.selectedPatient = patient;
    this.visitService.getByPatientId(patient.id).subscribe(visits => {
      this.visits = visits;
      this.selectedVisit = visits.length ? visits[0] : undefined!;
      if (this.selectedVisit) {
        this.loadVitals(this.selectedVisit.id);
      }
    });
  }

  selectVisit(visit: Visit): void {
    this.selectedVisit = visit;
    this.loadVitals(visit.id);
  }

  loadVitals(visitId: number): void {
    this.vitalSignService.getByVisitId(visitId).subscribe(vitals => this.vitals = vitals);
  }
}
