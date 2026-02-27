import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Study } from '../../interfaces/studies/study';

@Injectable({
  providedIn: 'root',
})
export class StudyService {

  private apiUrl = "https://localhost:8080/studies"

  constructor ( private http: HttpClient){}

  getStudy(): Observable<Study[]> {
    return this.http.get<Study[]>(this.apiUrl);
  }

  getById(id: number): Observable<Study> {
    return this.http.get<Study>(`${this.apiUrl}/${id}`);
  }

  create(formData: Study) {
    return this.http.post<Study>(this.apiUrl, formData);
  }

  update(id: number, formData: FormData) {
    return this.http.put<Study>(`${this.apiUrl}/${id}`, formData)
  }

  delete(id:number) {
    return this.http.delete<Study>(`${this.apiUrl}/${id}`)
  }

}
