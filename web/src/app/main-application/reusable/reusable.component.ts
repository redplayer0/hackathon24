import { Component } from '@angular/core';
import { UserService } from '../../services/userService';
import { CustomerSingUp } from '../../models/models';

@Component({
  selector: 'app-reusable',
  templateUrl: './reusable.component.html',
  styleUrl: './reusable.component.css'
})
export class ReusableComponent {
  sidebarVisible: boolean = false;
  dynamicBalance: string = "0";
  dynamicLimit: string = "0";
  customer :CustomerSingUp[]=[];
  constructor(private userService: UserService) {
    
  }

  ngOnInit(): void {
    setTimeout(() => {
      //get from api new balance and Limit

      this.dynamicBalance = "100";
      this.dynamicLimit= "100";
    }, 2000);
  }

}
