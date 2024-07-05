import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Employee } from '../models/employee';
import { Office } from '../models/office';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../services/http.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.css'
})
export class EmployeeFormComponent {

  employee: Employee = new Employee(0,'','','',new Office(0,'','',0,[]));
  
  constructor(private route: ActivatedRoute, private httpService: HttpService){
        this.getEmployeeById();
        this.getAllOffices();
  }

  getEmployeeById(){
    this.httpService.getEmployeeById(this.route.snapshot.params['id'])
                  .subscribe(data=>{
                    this.employee = data.body;

                    this.updatedEmployee.employeeId = data.body.employeeId;
                    this.updatedEmployee.employeeFirstName = data.body.employeeFirstName;
                    this.updatedEmployee.employeeLastName = data.body.employeeLastName;
                    this.updatedEmployee.employeeJobTitle = data.body.employeeJobTitle;
                    this.updatedEmployee.office = data.body.office;
                  })
  }

  updatedEmployee: Employee = new Employee(0,'','','',new Office(0,'','',0,[]));

  employeeUpdated: boolean = false;
  failedToUpdate: boolean = false;
  updateEmployee(){
    this.httpService.updateEmployee(this.updatedEmployee)
    .subscribe({
      next: data =>{
        this.getEmployeeById();
        this.employeeUpdated = true;
        this.failedToUpdate = false;
      }
    })
  }

  offices: Office[] = [];

  getAllOffices(){
    this.httpService.getAllOffices().subscribe(response => {
      console.log(response.body);
      this.offices = [];
      this.officeAtCapacity = false;
      for (let item of response.body){
        this.offices.push(
          new Office(item.officeId, item.officeName, item.officeAddress, item.officeCapacity, item.employees)
        );
      }
    });
  }

  newOffice: Office = new Office(0,'','',0,[])

  officeAtCapacity: boolean =false;
  officeUpdated: boolean = false;

  updateEmployeeOffice(){
    console.log(this.newOffice.officeId);
    this.httpService.changeEmployeeOffice(this.employee.employeeId, this.newOffice.officeId)
        .subscribe(
          {
            next: data => {
              this.officeAtCapacity = false;
              this.officeUpdated = true;
            },
            error: err => {
              this.officeAtCapacity = true;
              this.officeUpdated = false;
            }
          }
        )
  }

}
