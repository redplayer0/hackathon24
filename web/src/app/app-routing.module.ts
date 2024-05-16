import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ReusableComponent } from './main-application/reusable/reusable.component';
import { HomepageComponent } from './main-application/homepage/homepage.component';
import { MainApplicationComponent } from './main-application/main-application.component';
import { ChangingComponent } from './main-application/changing/changing.component';
import { RegisterComponent } from './register/register.component';
import { TransactionhistoryComponent } from './main-application/transactionhistory/transactionhistory.component';
import { ShopsearchComponent } from './main-application/shopsearch/shopsearch.component';

const routes: Routes = [

  {
  path:'login',
  component: LoginComponent
  },
  {
    path:'sidebar',
    component:ChangingComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'',
    component:MainApplicationComponent,
    children:[
      {path: 'homepage', component:HomepageComponent, pathMatch:'full'},
      {path: 'changing', component: ChangingComponent, pathMatch: 'full'},
      {path: 'transactionshistory', component: TransactionhistoryComponent,pathMatch:'full'},
      {path: 'shops', component: ShopsearchComponent,pathMatch:'full'}
    ],

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
