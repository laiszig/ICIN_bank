import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountCreationComponent } from './account/account-creation/account-creation.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AdminScreenComponent } from './home/admin-screen/admin-screen.component';
import { UserScreenComponent } from './home/user-screen/user-screen.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccountDetailsComponent } from './account/account-details/account-details.component';
import { ClientComponent } from './client/client.component';
import { CheckbookComponent } from './checkbook/checkbook.component';
import { MoveFundsComponent } from './account/move-funds/move-funds.component';

const routes: Routes = [
  {"path":"account/add", component: AccountCreationComponent},
  {"path":"accounts", component: AccountListComponent},
  {"path":"account/:id", component: AccountDetailsComponent},
  {"path":"admin/home", component: AdminScreenComponent},
  {"path":"user/home", component: UserScreenComponent},
  {"path":"register",component:RegisterComponent},
  {"path":"login",component:LoginComponent},
  {"path":"clients", component:ClientComponent},
  {"path":"checkbook", component:CheckbookComponent},
  {"path":"move", component:MoveFundsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
