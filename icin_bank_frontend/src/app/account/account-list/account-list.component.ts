import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../Account';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private accountService: AccountService,

  ) {}

  accounts: Account[];
  // users: Users[];
  filters = {
    keyword: ''
  }

  ngOnInit(): void {
    this.accountService
      .getAllAccounts()
      .subscribe((result) => {
        console.log(result)

        this.accounts = result
      });
  }

  listAccounts() {
    this.accountService.getAllAccounts().subscribe(
      data => this.accounts = this.filterAccounts(data)
    )
  }

  filterAccounts(accounts: Account[]) {
    return accounts.filter((m) => {
      return (m.accountType.toLowerCase().includes(this.filters.keyword.toLowerCase())); 
      // || m.status.toString().toLowerCase().includes(this.filters.keyword.toLowerCase()));
    })
  } 
  
 redirectToAccountDetails(accountId: number) {
  if (accountId) {
    this.router.navigate(['/account', accountId]);
  }
}

  

  // statusSelection = (event: any) => {
  //   const status = event.target.value;
  //   if (status != 0) {
  //     this.listTicketService
  //     .getTicketsByStatus(status)
  //     .subscribe((result) => (this.tickets = result));
  //   } else {
  //     this.listTicketService
  //     .getAllTickets()
  //     .subscribe((result) => (this.tickets = result));
  //   }
  // }

  // redirectToAccountDetails(event: any) {
  //   const accountNumber = event.target.value;
  //   const url: String = "/account" 
  //   // + accountId;
  //   this.router.navigate([url]);
  // }
  
}
