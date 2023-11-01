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
    return this.httpClient.put<any>(this.url + "/admin/account", account)
    .pipe(map(result => { return result }));
  }

  getAllAccounts(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(this.url + "/admin/accounts");
  }

  getAccountById(accountId: number): Observable<Account> {
    return this.httpClient.get<Account>(`${this.url}/admin/account/${accountId}`);
  }

  deposit(amount: number): Observable<Account> {
    const depositUrl = `${this.url}/user/account/deposit`;
    return this.httpClient.post<Account>(depositUrl, { amount });
  }

  withdraw(amount: number): Observable<Account> {
    const withdrawUrl = `${this.url}/user/account/withdraw`;
    return this.httpClient.post<Account>(withdrawUrl, { amount });
  }

  getCheckingBalance(): Observable<number> {
    return this.httpClient.get<number>(this.url + "/user/account/balance");
  }
}
