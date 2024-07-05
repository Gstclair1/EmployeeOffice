import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Office } from '../models/office';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-new-office-form',
  standalone: true,
  imports: [RouterLink, FormsModule, CommonModule],
  templateUrl: './new-office-form.component.html',
  styleUrl: './new-office-form.component.css'
})
export class NewOfficeFormComponent {

  constructor(private httpService: HttpService){
  }

  formOffice: Office = new Office(0, '','',0,[]);
  officeCreated: boolean = false;
  failedToCreate: boolean = false;
  createOffice(){
    this.httpService.createOffice(this.formOffice).subscribe({
      next: data =>{
        this.officeCreated = true;
        this.failedToCreate = false;
      },
      error: err => {
        this.officeCreated = false;
        this.failedToCreate = true;
      }
    });
  }
}
