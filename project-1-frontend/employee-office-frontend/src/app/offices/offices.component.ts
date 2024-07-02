import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { response } from 'express';
import { Office } from '../models/office';
import { HttpService } from '../services/http.service';
import { OfficeCardComponent } from '../office-card/office-card.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-offices',
  standalone: true,
  imports: [HttpClientModule, CommonModule, OfficeCardComponent, FormsModule],
  templateUrl: './offices.component.html',
  styleUrl: './offices.component.css'
})
export class OfficesComponent {
  offices: Office[] = [];

  constructor(private httpService: HttpService){
    this.getAllOffices();
  }

  getAllOffices(){
    this.httpService.getAllOffices().subscribe(response => {
      this.offices = [];
      for (let item of response.body){
        this.offices.push(
          new Office(item.officeId, item.officeName, item.officeAddress, item.officeCapacity)
        );
      }
    });
  }

  formOffice: Office = new Office(0, '','',0);
  createOffice(){
    this.httpService.createOffice(this.formOffice).subscribe(response => {
      this.getAllOffices();
    });
  }
}
