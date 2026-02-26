import { Injectable } from '@angular/core';
import { Visit } from '../../interfaces/visits/visit';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class VisitService {

  private apiUrl = "https://localhost:8080/visits"

  constructor ( private http: HttpClient){}

  getVisit(): Observable<Visit[]> {
    return this.http.get<Visit[]>(this.apiUrl);
  }

  getById(id: number): Observable<Visit> {
    return this.http.get<Visit>(`${this.apiUrl}/${id}`);
  }

  create(formData: FormData) {
    return this.http.post<Visit>(this.apiUrl, formData);
  }

  update(id: number, formData: FormData) {
    return this.http.put<Visit>(`${this.apiUrl}/${id}`, formData)
  }

  delete(id:number) {
    return this.http.delete<Visit>(`${this.apiUrl}/${id}`)
  }

}
