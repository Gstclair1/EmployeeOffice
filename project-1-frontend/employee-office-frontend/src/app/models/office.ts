export class Office {

    officeId: number;
    officeName: string;
    officeAddress: string;
    officeCapacity: number;
    employees: [];

    constructor(officeId: number, officeName: string, officeAddress: string, officeCapacity: number, employees: []){
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
        this.officeCapacity = officeCapacity;
        this.employees = employees;
    }

}
