import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, timer} from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {AbstractControl, AsyncValidatorFn} from '@angular/forms';

const URL = 'http://localhost:3000/products';
const URLType = 'http://localhost:3000/productType';

@Injectable({
  providedIn: 'root'
})
export class ServiceConnectService {
  public readonly API: string = 'http://localhost:3000/products';
  public readonly APIProductType: string = 'http://localhost:3000/productType';

  constructor(public http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllType(): Observable<any> {
    return this.http.get(this.APIProductType);
  }

  createNewService(variable): Observable<any> {
    return this.http.post(this.API, variable);
  }

  editService(customer, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, customer);
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind);
  }

  deleteService(idNeedDelete: any): Observable<any> {
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
          return this.http.get<any>(`${URL}?idFormat=${text}`);
        })
      );
  }
  // -----------------------------------------------------------------------------------------------

  // ------------------------------------ Search --------------------------------------------------
  findByName(key: string): Observable<any> {
    return this.http.get(`${URL}?name_like=${key}`);
  }

  findByPrice(key: string): Observable<any> {
    return this.http.get(`${URL}?price_like=${key}`);
  }

  findByType(key: string): Observable<any> {
    return this.http.get(`${URL}?type.name_like=${key}`);
  }

  findByNameAndPrice(name: string, price: string): Observable<any> {
    return this.http.get(`${URL}?name_like=${name}&price_like=${price}`);
  }

  findByNameAndType(name: string, price: string): Observable<any> {
    return this.http.get(`${URL}?name_like=${name}&type.name_like=${price}&_sort=price&_order=asc`);
  }
  // -------------------------------------------------------------------------------------------------------


  // -------------------------------------------- Sort --------------------------------------------------
  sortByPriceASC(): Observable<any> {
    return this.http.get(`${URL}?_sort=price&_order=asc`);
  }

  sortByPriceDESC(): Observable<any> {
    return this.http.get(`${URL}?_sort=price&_order=desc`);
  }

  sortByNameASC(): Observable<any> {
    return this.http.get(`${URL}?_sort=name&_order=asc`);
  }

  sortByNameDESC(): Observable<any> {
    return this.http.get(`${URL}?_sort=name&_order=desc`);
  }

  sortByIDASC(): Observable<any> {
    return this.http.get(`${URL}?_sort=idFormat&_order=asc`);
  }

  sortByIDDESC(): Observable<any> {
    return this.http.get(`${URL}?_sort=idFormat&_order=desc`);
  }
  // ---------------------------------------------------------------------------------------------------------
}
