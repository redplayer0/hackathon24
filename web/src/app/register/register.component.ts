import { Component, ViewChild } from '@angular/core';
import { Dropdown } from 'primeng/dropdown'; 
import { IUser, IUserLogin, UserLogIn,CustomerSingUp,ShopperSingUp } from '../models/models'; 
import { ButtonModule } from 'primeng/button';
import { FormBuilder, FormGroup, FormsModule, Validators} from '@angular/forms';
import { InputText, InputTextModule } from 'primeng/inputtext';
import { UserService } from '../services/userService';

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
  constructor(private userService: UserService) {
    
  }

  onOptionChange(event: any) {
    this.selectedOption = event.value;
    if (event.value === 'shop') {
      this.showAdditionalShoperInputs = true;
      this.showAdditionalPayerInputs = false;
      this.customerSignUp.role='shop';
    } 
    if(event.value==='customer'){
      this.showAdditionalShoperInputs = false;
      this.showAdditionalPayerInputs=true;
      this.customerSignUp.role='customer';
    }
  }

  signUpUser():void{
    this.userService.customerSignUp(this.customerSignUp).subscribe()
  }
  onSubmit() { 
    this.submitted = true; 
    this.signUpUser()
  }

  submitForm() {

    this.submitted = true; 
    
    this.signUpUser();
  }

}
