import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountCreationComponent } from './account/account-creation/account-creation.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AdminScreenComponent } from './account/home/admin-screen/admin-screen.component';

const routes: Routes = [
  {"path":"account/add", component: AccountCreationComponent},
  {"path":"accounts", component: AccountListComponent},
  {"path":"admin", component: AdminScreenComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
