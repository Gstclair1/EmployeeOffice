import { Component, Input } from '@angular/core';
import { Employee } from '../models/employee';
import { Office } from '../models/office';

@Component({
  selector: 'app-employee-card',
  standalone: true,
  imports: [],
  templateUrl: './employee-card.component.html',
  styleUrl: './employee-card.component.css'
})
export class EmployeeCardComponent {


  @Input() employee: Employee = new Employee(0,'','','', new Office(0, '','',0));
}
