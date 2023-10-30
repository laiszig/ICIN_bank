import { Component } from '@angular/core';
import { CheckbookService } from 'src/app/checkbook/checkbook.service';

@Component({
  selector: 'app-user-screen',
  templateUrl: './user-screen.component.html',
  styleUrls: ['./user-screen.component.css']
})
export class UserScreenComponent {

  accountId: number;
  requestSent: boolean = false;

  constructor(private checkbookService: CheckbookService) { }

  requestCheckbook(): void {
    this.checkbookService.createCheckbookRequest(this.accountId)
      .subscribe(() => {
        this.requestSent = true;
      });
  }

}
