import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, timer} from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {AbstractControl, AsyncValidatorFn} from '@angular/forms';

const URL = 'http://localhost:3000/employee';
const URLGender = 'http://localhost:3000/gender';

@Injectable({
  providedIn: 'root'
})
export class ServiceEmployeeService {
  public readonly API: string = 'http://localhost:3000/employee';
  public readonly APIGender: string = 'http://localhost:3000/gender';

  constructor(public http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllGender(): Observable<any> {
    return this.http.get(this.APIGender);
  }

  createNewEmployee(variable): Observable<any> {
    return this.http.post(this.API, variable);
  }

  editEmployee(employee, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, employee);
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind);
  }

  deleteEmployee(idNeedDelete: any): Observable<any> {
    return this.http.delete(this.API + '/' + idNeedDelete);
  }

  // -------------------------------- Validate Đã Tồn Tại ----------------------------------
  validateID(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any } | null> => {
      return this.search(control.value)
        .pipe(
          map(res => {
            if (res.length) {
              return {idExists: true};
            }
          })
        );
    };
  }

  search(text) {
    return timer(100)
      .pipe(
        switchMap(() => {
          return this.http.get<any>(`${URL}?employeeCode=${text}`);
        })
      );
  }
  // -----------------------------------------------------------------------------------------------

  // ------------------------------------ Search --------------------------------------------------
  findByFullName(key: string): Observable<any> {
    return this.http.get(`${URL}?fullName_like=${key}`);
  }

  findByEmail(key: string): Observable<any> {
    return this.http.get(`${URL}?email_like=${key}`);
  }

  findByNumberPhone(key: string): Observable<any> {
    return this.http.get(`${URL}?numberPhone_like=${key}`);
  }
}
