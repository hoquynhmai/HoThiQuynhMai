import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API = ' http://localhost:3000/employees';
  public APIposition: string = '  http://localhost:3000/position';
  public APIdivision: string = '  http://localhost:3000/division';
  public APIeducationDegree: string = ' http://localhost:3000/educationDegree';

  constructor(public http: HttpClient) {}

  getAllEmployees(): Observable<any>{
    // console.log('hhhhh'+ this.http.get(this.API))
    return this.http.get(this.API);
  }

  getAllPosition(): Observable<any>{
    return this.http.get(this.APIposition);
  }

  getAllDivision(): Observable<any>{
    return this.http.get(this.APIdivision);
  }

  getAllEducationDegree(): Observable<any>{
    return this.http.get(this.APIeducationDegree);
  }

  addNewEmployeeService(employee): Observable<any> {
    return this.http.post(this.API, employee);
  }

  findById(employeeId): Observable<any>{
    return this.http.get(this.API + '/' + employeeId);
  }

  deleteEmployeeService(employeeId): Observable<any>{
    return this.http.delete(this.API + '/' + employeeId);
  }

  editEmployeeService(employee, employeeId): Observable<any>{
    return this.http.put(this.API + '/' + employeeId, employee);
  }
}
