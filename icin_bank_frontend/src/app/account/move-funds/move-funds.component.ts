import { Component } from '@angular/core';
import { Account } from '../Account';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-move-funds',
  templateUrl: './move-funds.component.html',
  styleUrls: ['./move-funds.component.css']
})
export class MoveFundsComponent {

  depositAmount: number;
  withdrawAmount: number;

  constructor(
    private accountService: AccountService,
    private router: Router) { }

  onSubmit(action: string): void {
    if (action === 'deposit') {
      this.deposit();
    } else if (action === 'withdraw') {
      this.withdraw();
    }
    this.router.navigate(['/user/home']);
  }

  deposit(): void {
    this.accountService.deposit(this.depositAmount).subscribe(
      (account: Account) => {
        console.log('Deposit successful:', account);
      },
      (error) => {
        console.error('Deposit error:', error);
      }
    );
  }

  withdraw(): void {
    this.accountService.withdraw(this.withdrawAmount).subscribe(
      (account: Account) => {
        console.log('Withdrawal successful:', account);
      },
      (error) => {
        console.error('Withdrawal error:', error);
      }
    );
  }

}
