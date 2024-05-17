import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SidebarModule } from 'primeng/sidebar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReusableComponent } from './main-application/reusable/reusable.component';
import { HomepageComponent } from './main-application/homepage/homepage.component';
import { MainApplicationComponent } from './main-application/main-application.component';
import { ChangingComponent } from './main-application/changing/changing.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropdownModule } from 'primeng/dropdown';
import { DataViewModule } from 'primeng/dataview';
import { FormBuilder, FormGroup, FormsModule, NgForm, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TransactionhistoryComponent } from './main-application/transactionhistory/transactionhistory.component';
import { ShopsearchComponent } from './main-application/shopsearch/shopsearch.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './services/userService';
import { PaymentinfoComponent } from './paymentinfo/paymentinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ReusableComponent,
    HomepageComponent,
    MainApplicationComponent,
    ChangingComponent,
    TransactionhistoryComponent,
    PaymentinfoComponent,
  ],
  imports: [
    BrowserModule,
    TableModule,
    AppRoutingModule,
    SidebarModule,
    DropdownModule,
    BrowserAnimationsModule,
    DataViewModule,
    FormsModule,
    CommonModule,
    ButtonModule,
    HttpClientModule,
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
