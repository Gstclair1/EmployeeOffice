import { Component, Input } from '@angular/core';
import { Office } from '../models/office';

@Component({
  selector: 'app-office-card',
  standalone: true,
  imports: [],
  templateUrl: './office-card.component.html',
  styleUrl: './office-card.component.css'
})
export class OfficeCardComponent {

  @Input() office: Office = new Office(0, '','',0);
}
