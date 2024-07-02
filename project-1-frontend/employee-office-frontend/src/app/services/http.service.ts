import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
import { Office } from '../models/office';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  url: String ='http://localhost:8080/';

  //get all
  getAllEmployees(): Observable<HttpResponse<any>>{
    return this.http.get(this.url + 'employee', { observe: 'response'});
  }

  getAllOffices(): Observable<HttpResponse<any>>{
    return this.http.get(this.url + 'office', {observe: 'response'});
  }

  //get by id
  getEmployeeById(employeeId: number): Observable<HttpResponse<any>>{
    return this.http.get(this.url +'employee/'+ employeeId, {observe: 'response'})
  }

  getOfficeById(officeId: number): Observable<HttpResponse<any>>{
    return this.http.get(this.url + 'office/' + officeId, {observe: 'response'})
  }

  //create
  createEmployee(employee: Employee): Observable<HttpResponse<any>>{
    return this.http.post(this.url + 'employee', employee,{observe: 'response'});
  }

  createOffice(office: Office): Observable<HttpResponse<any>>{
    return this.http.post(this.url + 'office', office,{observe: 'response'});
  }

  //update
  updateEmployee(employee: Employee): Observable<HttpResponse<any>>{
    return this.http.put(this.url + 'employee', employee, {observe: 'response'});
  }

  updateOffice(office: Office): Observable<HttpResponse<any>>{
    return this.http.put(this.url + 'office', office, {observe: 'response'});
  }

  //change employee's office
  changeEmployeeOffice(){}

  //delete
  deleteEmployee(employeeId: number): Observable<HttpResponse<any>>{
    return this.http.delete(this.url + 'employee/' + employeeId, {observe: 'response'});
  }

  deleteOffice(officeId: number): Observable<HttpResponse<any>>{
    return this.http.delete(this.url + 'office/' + officeId, {observe: 'response'});
  }


}
