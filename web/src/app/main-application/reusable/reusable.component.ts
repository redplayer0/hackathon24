import { Component } from '@angular/core';

@Component({
  selector: 'app-reusable',
  templateUrl: './reusable.component.html',
  styleUrl: './reusable.component.css'
})
export class ReusableComponent {
  sidebarVisible: boolean = false;
  dynamicBalance: string = "0";
  dynamicLimit: string = "0";

  ngOnInit(): void {
    setTimeout(() => {
      //get from api new balance and Limit
      this.dynamicBalance = "New Balance";
      this.dynamicLimit= "New Limit";
    }, 2000);
  }

}
