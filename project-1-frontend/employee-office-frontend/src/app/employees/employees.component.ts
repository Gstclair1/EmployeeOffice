import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { response } from 'express';
import { HttpService } from '../services/http.service';
import { Employee } from '../models/employee';
import { EmployeeCardComponent } from '../employee-card/employee-card.component';
import { Office } from '../models/office';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, EmployeeCardComponent, EmployeeFormComponent, FormsModule],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {

  employees: Employee[] = [];

  constructor(private httpService: HttpService){
    this.getAllEmployees();
  }

  getAllEmployees(){
    this.httpService.getAllEmployees().subscribe(response =>{
          this.employees = [];
          for (let item of response.body){
            this.employees.push(
              new Employee(item.employeeId, item.employeeFirstName, item.employeeLastName, item.employeeJobTitle, item.office)
            );
          }
      });
  }

  formEmployee: Employee = new Employee(0, '','','', new Office(0, '','',0));

  createEmployee(){
    this.httpService.createEmployee(this.formEmployee).subscribe(response => {
      this.getAllEmployees();
    });
  }

 deleteEmployee(employeeId: number){
  this.httpService.deleteEmployee(employeeId).subscribe(response =>{
    this.getAllEmployees();
  })
 }
}
