import { Component } from '@angular/core';
import { Employee } from '../models/employee';
import { Office } from '../models/office';
import { HttpService } from '../services/http.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-employee-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './new-employee-form.component.html',
  styleUrl: './new-employee-form.component.css'
})
export class NewEmployeeFormComponent {
  constructor(private httpService: HttpService){
  }

  formEmployee: Employee = new Employee(0, '','','', new Office(0, '','',0,[]));

  employeeCreated: boolean= false;
  failedToCreate: boolean = false;
  createEmployee(){
    this.httpService.createEmployee(this.formEmployee).subscribe(
      {
        next: response => {
          this.employeeCreated = true;
          this.failedToCreate = false;
        },
        error: err => {
          this.failedToCreate = true;
          this.employeeCreated = false;
        }
      }
    );
  }
}
