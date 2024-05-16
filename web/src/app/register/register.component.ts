import { Component, ViewChild } from '@angular/core';
import { Dropdown } from 'primeng/dropdown'; 
import { ButtonModule } from 'primeng/button';
import { FormBuilder, FormGroup, FormsModule, Validators} from '@angular/forms';
import { InputText, InputTextModule } from 'primeng/inputtext';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
 
})
export class RegisterComponent {
  @ViewChild('myDropdown') myDropdown: Dropdown | undefined;
  dropdownOptions: any[] = [
    { label: 'Payer', value: 'payer' },
    { label: 'Shopper', value: 'shopper' }
  ];

  selectedOption: string = 'payer';
  showAdditionalShoperInputs: boolean = false;
  showAdditionalPayerInputs : boolean = true;
  firstname : string | undefined;


  onOptionChange(event: any) {
    this.selectedOption = event.value;
    if (event.value === 'shopper') {
      this.showAdditionalShoperInputs = true;
      this.showAdditionalPayerInputs = false;
    } 
    if(event.value==='payer'){
      this.showAdditionalShoperInputs = false;
      this.showAdditionalPayerInputs=true;
    }
  }

  submitForm() {
    if (this.firstname) {
      // Input is not null, proceed with your logic
      console.log('Input is not null:', this.firstname);
    } else  {
      // Input is null
      console.log('Input is null');
    }
  }

}
