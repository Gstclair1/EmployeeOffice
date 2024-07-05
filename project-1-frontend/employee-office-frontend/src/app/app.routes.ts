import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmployeesComponent } from './employees/employees.component';
import { OfficesComponent } from './offices/offices.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { OfficeFormComponent } from './office-form/office-form.component';
import { NewEmployeeFormComponent } from './new-employee-form/new-employee-form.component';
import { NewOfficeFormComponent } from './new-office-form/new-office-form.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'employees',
        component: EmployeesComponent
    },
    {
        path: 'offices',
        component: OfficesComponent
    },
    {
        path: 'employee/:id',
        component: EmployeeFormComponent
    },
    {
        path: 'office/:id',
        component: OfficeFormComponent
    },
    {
        path: 'employees/new',
        component: NewEmployeeFormComponent
    },
    {
        path: 'offices/new',
        component: NewOfficeFormComponent
    }
];
