import { Component } from '@angular/core';
import { IUser, IUserLogin, UserLogIn } from '../../models/models'; 
import { FormBuilder, FormGroup, FormsModule, NgForm, Validators } from '@angular/forms';
import { UserService } from '../../services/userService';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DataViewModule } from 'primeng/dataview';
import { AppComponent } from '../../app.component';
import { MainApplicationComponent } from '../main-application.component';


@Component({
  selector: 'app-shopsearch',
  templateUrl: './shopsearch.component.html',
  styleUrl: './shopsearch.component.css'
})
export class ShopsearchComponent {

  shops: string[] = ['Apple', 'Banana', 'Cherry', 'Date', 'Elderberry'];
  filteredItems: string[]=[];
  

  constructor(private userService: UserService) {
    
    //this.userService.getShopsNames().subscribe(shops => this.shops = shops.map((shop)=> shop.name));
    this.filteredItems = this.shops;
  }
  search(searchValue: string): void {
    //console.log(searchValue);
    if (!searchValue) {
      this.filteredItems = this.shops;
      return;
    }
    this.filteredItems = this.shops.filter(shop =>
      shop.toLowerCase().includes(searchValue.toLowerCase())
      
    );
    console.log(searchValue);
  
  }
  
  

}
