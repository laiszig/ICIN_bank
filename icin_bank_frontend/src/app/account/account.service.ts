import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Account } from './Account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  url: string = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  createAccount(account: Account) {
    return this.httpClient.put<any>(this.url + "/account", account)
    .pipe(map(result => {
      console.log("SERVICE LOG PIPE")
      console.log(result)
      return result;
    }));
  }

  //get all tickets
  getAllAccounts(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(this.url + "/account");
  }

  // getTicketsByStatus(id: any): Observable<Account[]> {
  //   return this.http.post<Account[]>(this.url + "/ticket/status", {"status" : Status})
  // }
}
