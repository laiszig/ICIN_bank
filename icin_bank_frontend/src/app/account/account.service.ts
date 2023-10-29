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

  account: Account;

  createAccount(account: Account) {
    return this.httpClient.put<any>(this.url + "/account", account)
    .pipe(map(result => {
      console.log("SERVICE LOG PIPE")
      console.log(result)
      return result;
    }));
  }

  getAllAccounts(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(this.url + "/admin/accounts");
  }

  getAccountById(accountId: number): Observable<Account> {
    return this.httpClient.get<Account>(`${this.url}/admin/account/${accountId}`);
  }
}
