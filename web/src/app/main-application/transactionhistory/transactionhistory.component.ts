import { Component } from '@angular/core';
import { UserService } from '../../services/userService';
import { IUser, IUserLogin, UserLogIn,TransactionOfUser } from '../../models/models';


@Component({
  selector: 'app-transactionhistory',
  templateUrl: './transactionhistory.component.html',
  styleUrl: './transactionhistory.component.css'
})
export class TransactionhistoryComponent {
  transactions: TransactionOfUser[] = [];


  constructor(private userService: UserService) {
    this.getTransactions();
  }

  getTransactions(): void {
    this.userService.getTransactions()
      .subscribe(trans => this.transactions = trans);
  }



   

}
