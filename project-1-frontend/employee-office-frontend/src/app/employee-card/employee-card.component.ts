import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Employee } from '../models/employee';
import { Office } from '../models/office';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-card',
  standalone: true,
  imports: [],
  templateUrl: './employee-card.component.html',
  styleUrl: './employee-card.component.css'
})
export class EmployeeCardComponent {

  constructor(private router: Router){}

  @Input() employee: Employee = new Employee(0,'','','', new Office(0, '','',0,[]));

  @Output() deleteEmployeeEvent = new EventEmitter<number>();

  editEmployee(){
    this.router.navigate(['employee/'+this.employee.employeeId])
  }

  deleteEmployee(){
    this.deleteEmployeeEvent.emit(this.employee.employeeId);
    
  }
}
