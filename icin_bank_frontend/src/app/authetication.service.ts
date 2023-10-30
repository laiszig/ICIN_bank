import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AutheticationService {

  constructor(private httpClient : HttpClient) { }

  login(username: String, password: String) {
    return this.httpClient.post<any>("http://localhost:8080/authenticate", { username, password })
    .pipe(map(user => {
        if (user && user.token) {
            localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
    }));   
  }

  register(username: String, password: String) {
    return this.httpClient.post<any>("http://localhost:8080/register", { username, password })
    .pipe(map(user => {
        return user;
    }));   
  }

  getAccountData(userId: number): Observable<any> {
    return this.httpClient.get(`http://localhost:8080/admin/userentity/${userId}`)
    .pipe(map(user => {
      return user;
  })); 
  }

}
