import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Office } from '../models/office';
import { HttpService } from '../services/http.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-office-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './office-form.component.html',
  styleUrl: './office-form.component.css'
})
export class OfficeFormComponent {
  office: Office = new Office(0,'','',0, []);

  constructor(private httpService: HttpService, private route: ActivatedRoute){
    this.getOfficeById();
  }

  getOfficeById(){
    this.httpService.getOfficeById(this.route.snapshot.params['id'])
                  .subscribe(data =>{
                    this.office = data.body

                    this.updatedOffice.officeId = data.body.officeId;
                    this.updatedOffice.officeName = data.body.officeName;
                    this.updatedOffice.officeAddress = data.body.officeAddress;
                    this.updatedOffice.officeCapacity = data.body.officeCapacity;
                    this.updatedOffice.employees = data.body.employees;
                  })
  }

  updatedOffice: Office = new Office(0,'','',0,[]);

  updateOffice(){
    this.httpService.updateOffice(this.updatedOffice)
          .subscribe(data=>{
            this.getOfficeById();
          })
  }
}
