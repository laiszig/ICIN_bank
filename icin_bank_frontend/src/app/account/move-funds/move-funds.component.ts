import { Component } from '@angular/core';
import { Account } from '../Account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-move-funds',
  templateUrl: './move-funds.component.html',
  styleUrls: ['./move-funds.component.css']
})
export class MoveFundsComponent {

  account: Account;
  
  constructor(private accountService: AccountService) { }

  deposit(id: number, amount: number): void {
    this.accountService.deposit(id, amount).subscribe(
      (account: Account) => {
        // Handle successful deposit, for example, update the account details in the UI
        console.log('Deposit successful:', account);
      },
      (error) => {
        // Handle deposit error, show error message to the user
        console.error('Deposit error:', error);
      }
    );
  }

  withdraw(id: number, amount: number): void {
    this.accountService.withdraw(id, amount).subscribe(
      (account: Account) => {
        // Handle successful withdrawal, for example, update the account details in the UI
        console.log('Withdrawal successful:', account);
      },
      (error) => {
        // Handle withdrawal error, show error message to the user
        console.error('Withdrawal error:', error);
      }
    );
  }

}
