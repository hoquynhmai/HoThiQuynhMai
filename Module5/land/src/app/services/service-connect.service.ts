import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, timer} from "rxjs";
import {map, switchMap} from "rxjs/operators";
import {AbstractControl, AsyncValidatorFn} from "@angular/forms";

const URL = 'http://localhost:3000/products';

@Injectable({
  providedIn: 'root'
})
export class ServiceConnectService {
  public API: string = 'http://localhost:3000/products';
  public APIProductType: string = 'http://localhost:3000/landType';
  public APIProductStatus: string = ' http://localhost:3000/landStatus';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllType(): Observable<any> {
    return this.http.get(this.APIProductType);
  }

  getAllStatus(): Observable<any> {
    return this.http.get(this.APIProductStatus);
  }

  createNewService(variable): Observable<any> {
    return this.http.post(this.API, variable)
  }

  validateID(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any } | null> => {
      return this.search(control.value)
        .pipe(
          map(res => {
            // if username is already taken
            console.log(res);
            if (res.length) {
              // return error
              return {'idExists': true};
            }
          })
        );
    };
  }

  search(text) {
    // debounce
    return timer(100)
      .pipe(
        switchMap(() => {
          // Check if id is exists :
          return this.http.get<any>(`${URL}?idFormat=${text}`)
        })
      );
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind)
  }

  deleteService(idNeedDelete: any): Observable<any> {
    return this.http.delete(this.API + '/' + idNeedDelete)
  }

  editService(customer, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, customer)
  }

  //---------------------------------------- Search -----------------------------------------------
  findByArea(key: string): Observable<any> {
    return this.http.get(`${URL}?area_like=${key}`);
  }

  findByCost(key: string): Observable<any> {
    return this.http.get(`${URL}?cost_like=${key}`);
  }

  findByFloor(key: string): Observable<any> {
    return this.http.get(`${URL}?floor_like=${key}`);
  }

  findByAreaAndCost(area: string, cost: string): Observable<any> {
    return this.http.get(`${URL}?area_like=${area}&cost_like=${cost}`);
  }

  findByAreaAndCostAndFloor(area: string, cost: string, floor: string): Observable<any> {
    return this.http.get(`${URL}?area_like=${area}&cost_like=${cost}&floor_like=${floor}`);
  }
  //-------------------------------------------------------------------------------------------------------
}
