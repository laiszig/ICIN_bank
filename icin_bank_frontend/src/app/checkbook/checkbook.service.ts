import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Checkbook } from './Checkbook';
import { CheckRequest } from './CheckRequest';

@Injectable({
  providedIn: 'root'
})
export class CheckbookService {

  private baseUrl = 'http://localhost:8080/admin/checkbook';
  private userUrl = 'http://localhost:8080/user/checkbook';

  constructor(private http: HttpClient) { }

  getAllCheckbookRequests(): Observable<Checkbook[]> {
    return this.http.get<Checkbook[]>(`${this.baseUrl}`);
  }

  approveCheckbookStatus(id: number): Observable<Checkbook> {
    return this.http.put<Checkbook>(`${this.baseUrl}/approve/${id}`, {});
  }

  denyCheckbookStatus(id: number): Observable<Checkbook> {
    return this.http.put<Checkbook>(`${this.baseUrl}/deny/${id}`, {});
  }

  createCheckbookRequest(accountId: number): Observable<CheckRequest> {
    console.log(accountId);
    return this.http.post<CheckRequest>(`${this.userUrl}`, { accountId });
  }
  
}
