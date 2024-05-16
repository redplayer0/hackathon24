import { Component } from '@angular/core';
interface Transaction {
  shopName: string;
  amount: number;
  date: string;
  status: string;
}
@Component({
  selector: 'app-transactionhistory',
  templateUrl: './transactionhistory.component.html',
  styleUrl: './transactionhistory.component.css'
})
export class TransactionhistoryComponent {
  transactions: Transaction[];


  constructor() {
    this.transactions = [
      { shopName: 'Shop 1', amount: 100, date: '01/01/2024', status: 'Completed' },
      { shopName: 'Shop 2', amount: 200, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 3', amount: 150, date: '01/01/2024', status: 'Completed' },
      { shopName: 'Shop 4', amount: 300, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 1', amount: 100, date: '02/02/2024', status: 'Completed' },
      { shopName: 'Shop 2', amount: 200, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 3', amount: 150, date: '02/03/2024', status: 'Completed' },
      { shopName: 'Shop 4', amount: 300, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 1', amount: 100, date: '02/02/2024', status: 'Completed' },
      { shopName: 'Shop 2', amount: 200, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 3', amount: 150, date: '02/02/2024', status: 'Completed' },
      { shopName: 'Shop 4', amount: 300, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 1', amount: 100, date: '02/02/2024', status: 'Completed' },
      { shopName: 'Shop 2', amount: 200, date: '02/02/2024', status: 'Pending' },
      { shopName: 'Shop 3', amount: 150, date: '02/02/2024', status: 'Completed' },
      { shopName: 'Shop 4', amount: 300, date: '02/02/2024', status: 'Pending' }
    ];
  }

}
