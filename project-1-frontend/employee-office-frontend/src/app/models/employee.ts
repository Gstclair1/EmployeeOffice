import { Office } from "./office";

export class Employee {

    employeeId: number;
    employeeFirstName: string;
    employeeLastName: string;
    employeeJobTitle: string;
    office: Office;

    constructor(employeeId: number, employeeFirstName: string, employeeLastName: string, employeeJobTitle: string, office: Office){
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeJobTitle = employeeJobTitle;
        this.office = office;
    }

}
