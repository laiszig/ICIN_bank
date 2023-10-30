import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Account } from '../Account';

@Component({
  selector: 'app-account-creation',
  templateUrl: './account-creation.component.html',
  styleUrls: ['./account-creation.component.css']
})
export class AccountCreationComponent {

  constructor(
    private accountService: AccountService,
    private router: Router
  ) {}

  account: Account[];

    form: any = {
      accountType: null,
      user:null
    };

    ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.form);
    this.accountService.createAccount(this.form)

    .subscribe(
      data => {
        console.log("Processed")
        this.router.navigate(['/accounts']);
      },
      error => {
        console.log("Error processing")
        console.log(error)
      });
      
  }

  btnClick = () => {
    console.log("Account created!");
  };
}
