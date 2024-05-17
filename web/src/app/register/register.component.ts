import { Component, ViewChild } from '@angular/core';
import { Dropdown } from 'primeng/dropdown'; 
import { IUser, IUserLogin, UserLogIn,CustomerSingUp,ShopSingUp } from '../models/models'; 
import { ButtonModule } from 'primeng/button';
import { FormBuilder, FormGroup, FormsModule, Validators} from '@angular/forms';
import { InputText, InputTextModule } from 'primeng/inputtext';
import { UserService } from '../services/userService';
import { Router, RouterLink } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
 
})
export class RegisterComponent {
  @ViewChild('myDropdown') myDropdown: Dropdown | undefined;
  dropdownOptions: any[] = [
    { label: 'Customer', value: 'customer' },
    { label: 'Shop', value: 'shop' }
  ];

  selectedOption: string = 'customer';
  showAdditionalShoperInputs: boolean = false;
  showAdditionalPayerInputs : boolean = true;
  firstname : string | undefined;
  submitted = false;
  customerSignUp = new CustomerSingUp()
  shopperSignUp = new ShopSingUp()
  constructor(private userService: UserService,private router: Router) {
    
  }

  onOptionChange(event: any) {
    this.selectedOption = event.value;
    if (event.value === 'shop') {
      this.showAdditionalShoperInputs = true;
      this.showAdditionalPayerInputs = false;
      this.shopperSignUp.role='shop';
    } 
    if(event.value==='customer'){
      this.showAdditionalShoperInputs = false;
      this.showAdditionalPayerInputs=true;
      this.customerSignUp.role='customer';
    }
  }

  signUpUser():void{
    if(this.showAdditionalPayerInputs ){
      this.userService.customerSignUp(this.customerSignUp).subscribe()
    }else {
      this.userService.shopSignUp(this.shopperSignUp).subscribe()
    }
    
  }
  onSubmit() { 
    this.submitted = true; 
    this.signUpUser()
    this.router.navigate(['/homepage']);
  }

  submitForm() {

    this.submitted = true; 
    this.router.navigate(['/homepage']);
    this.signUpUser();
  }

}
