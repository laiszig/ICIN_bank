import { Component } from '@angular/core';
import { Checkbook } from './Checkbook';
import { CheckbookService } from './checkbook.service';

@Component({
  selector: 'app-checkbook',
  templateUrl: './checkbook.component.html',
  styleUrls: ['./checkbook.component.css']
})
export class CheckbookComponent {
  checkbookRequests: Checkbook[] = [];
  filters: any = {}; // Define filters object

  constructor(private checkbookService: CheckbookService) { }

  ngOnInit(): void {
    this.loadCheckbookRequests();
  }

  loadCheckbookRequests(): void {
    this.checkbookService.getAllCheckbookRequests()
      .subscribe(data => {
        this.checkbookRequests = data;
      });
  }

  approveRequest(id: number): void {
    this.checkbookService.approveCheckbookStatus(id)
      .subscribe(updatedCheckbook => {
        // Handle the updatedCheckbook if needed
        // For example, update the local checkbookRequests list
        this.loadCheckbookRequests();
      });
  }

  denyRequest(id: number): void {
    this.checkbookService.denyCheckbookStatus(id)
      .subscribe(updatedCheckbook => {
        // Handle the updatedCheckbook if needed
        // For example, update the local checkbookRequests list
        this.loadCheckbookRequests();
      });
  }
}
