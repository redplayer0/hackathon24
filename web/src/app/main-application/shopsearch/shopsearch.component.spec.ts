import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsearchComponent } from './shopsearch.component';

describe('ShopsearchComponent', () => {
  let component: ShopsearchComponent;
  let fixture: ComponentFixture<ShopsearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShopsearchComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShopsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
