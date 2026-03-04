import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Study } from '../../interfaces/studies/study';
import { StudyRequest } from '../../interfaces/studies/study-request';
import { Patient } from '../../interfaces/patients/patient';

@Injectable({
  providedIn: 'root',
})
export class StudyService {

  private apiUrl = "https://localhost:8080/studies"

  constructor ( private http: HttpClient){}

  getAll(): Observable<Study[]> {
    return this.http.get<Study[]>(this.apiUrl);
  }

  getById(id: number): Observable<Study> {
    return this.http.get<Study>(`${this.apiUrl}/${id}`);
  }

  getPatientsByStudy(studyId: number): Observable<Patient[]> {
    return this.http.get<Patient[]>(`http://localhost:8080/studies/${studyId}/patients`);
  }

}