export class Office {

    officeId: number;
    officeName: string;
    officeAddress: string;
    officeCapacity: number;

    constructor(officeId: number, officeName: string, officeAddress: string, officeCapacity: number){
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
        this.officeCapacity = officeCapacity;
    }

}
