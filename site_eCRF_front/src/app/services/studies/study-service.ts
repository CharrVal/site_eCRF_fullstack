import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Study } from '../../interfaces/studies/study';

@Injectable({
  providedIn: 'root',
})
export class StudyService {

  private apiUrl = "http://localhost:8080/studies"

  constructor ( private http: HttpClient){}

  getAll(): Observable<Study[]> {
    return this.http.get<Study[]>(this.apiUrl);
  }

  getById(id: number): Observable<Study> {
    return this.http.get<Study>(`${this.apiUrl}/${id}`);
  }

  createStudy(study: Study): Observable<Study> {
    return this.http.post<Study>(this.apiUrl, study);
  }

  updateStudy(id: number, study: Study): Observable<Study> {
    return this.http.put<Study>(`${this.apiUrl}/${id}`, study);
  }

  deleteStudy(id: number) : Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}