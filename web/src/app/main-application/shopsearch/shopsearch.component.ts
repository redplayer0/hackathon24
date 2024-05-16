import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DataViewModule } from 'primeng/dataview';
import { AppComponent } from '../../app.component';
import { MainApplicationComponent } from '../main-application.component';
interface Car {
  brand: string;
  model: string;
  year: number;
  // Add more properties as needed
}

@Component({
  selector: 'app-shopsearch',
  templateUrl: './shopsearch.component.html',
  styleUrl: './shopsearch.component.css'
})
export class ShopsearchComponent {
  
  /*filteredShopList: Shop[] = [];

  constructor() {
    this.shopList = this.shopName.getAllNames();
    this.filteredShopList = this.shopList;
  }
  filterResults(text: string) {
    if (!text) {
      this.filteredShopList = this.shopList;
      return;
    }
  
    this.filteredShopList = this.shopList.filter(
      shopname => shopname?.shopName.toLowerCase().includes(text.toLowerCase())
    );
  }*/
  
}
