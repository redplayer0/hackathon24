import { Component } from '@angular/core';

@Component({
  selector: 'app-changing',
  templateUrl: './changing.component.html',
  styleUrl: './changing.component.css'
})
export class ChangingComponent {
 
    sidebarVisible: boolean = true;
    dynamicLabel: string = "Initial Label";
    ngOnInit(): void {
      // Change the label dynamically when the component initializes
      this.dynamicLabel = "Initial Label";
      setTimeout(() => {
        this.dynamicLabel = "New Label after 2 seconds";
      }, 2000);
    }
}

