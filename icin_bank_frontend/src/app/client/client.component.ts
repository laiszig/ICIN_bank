import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientService } from './client.service';
import { User } from '../login/user';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private clientService: ClientService
  ) {}

  users: User[];
  filters = {
    keyword: ''
  }

  ngOnInit(): void {
    this.clientService
      .getAllUsers()
      .subscribe((result) => {
        console.log(result)

        this.users = result
      });
  }

  listClients() {
    this.clientService.getAllUsers().subscribe(
      data => this.users = this.filterUsers(data)
    )
  }

  filterUsers(users: User[]) {
    return users.filter((m) => {
      return (m.username.toLowerCase().includes(this.filters.keyword.toLowerCase()));
    })
  }
}
