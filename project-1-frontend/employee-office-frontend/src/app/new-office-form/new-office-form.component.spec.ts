import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOfficeFormComponent } from './new-office-form.component';

describe('NewOfficeFormComponent', () => {
  let component: NewOfficeFormComponent;
  let fixture: ComponentFixture<NewOfficeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewOfficeFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewOfficeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
