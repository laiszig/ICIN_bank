import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Account } from '../Account';
import { User } from 'src/app/login/user';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private accountService: AccountService
  ) {

    this.account = new Account();
    this.account.user = new User();
  
  }

  account: Account;

  ngOnInit(): void {
    const accountId = this.activatedRoute.snapshot.paramMap.get('id');
    console.log('Account ID:', accountId); // Check if the ID is correct
    if (accountId) {
      const parsedAccountId = parseInt(accountId, 10);
      this.accountService.getAccountById(parsedAccountId)
        .subscribe(
          (result) => {
            this.account = result;
            console.log('Fetched Account:', this.account); // Check the fetched account data
          },
          (error) => {
            console.error('Error fetching account details:', error);
          }
        );
    }
  }
  
}
