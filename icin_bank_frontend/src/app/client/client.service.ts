import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../login/user';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  url: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  //get all tickets
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url + "/admin/userentity");
  } 
}
