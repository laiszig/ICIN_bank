import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountCreationComponent } from './account/account-creation/account-creation.component';
import { AccountListComponent } from './account/account-list/account-list.component';

const routes: Routes = [
  {"path":"account/add", component: AccountCreationComponent},
  {"path":"accounts", component: AccountListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
