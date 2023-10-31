import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AccountService } from 'src/app/account/account.service';
import { CheckbookService } from 'src/app/checkbook/checkbook.service';

@Component({
  selector: 'app-user-screen',
  templateUrl: './user-screen.component.html',
  styleUrls: ['./user-screen.component.css']
})
export class UserScreenComponent {

  accountId: number;
  requestSent: boolean = false;

  constructor(
    private checkbookService: CheckbookService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private accountService: AccountService,
  
    ) { }

  checkingBalance: number;

  ngOnInit(): void {
    // this.accountService.getCheckingBalance();
    this.accountService.getCheckingBalance()
   .subscribe(
      balance => {
        this.checkingBalance = balance;
        console.log(balance); // Check the value in the console
      },
      error => {
        console.error(error); // Log any errors
      }
   );
  }

  getAccountBalance(): void {
    this.accountService.getCheckingBalance()
      .subscribe(balance => this.checkingBalance = balance);
      console.log(this.checkingBalance);
  }

  requestCheckbook(): void {
    this.checkbookService.createCheckbookRequest(this.accountId)
      .subscribe(() => {
        this.requestSent = true;
      });
  }

}
