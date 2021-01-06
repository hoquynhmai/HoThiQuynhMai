import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, timer} from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {AbstractControl, AsyncValidatorFn} from '@angular/forms';

const URL = 'http://localhost:8080/parking-slot';

@Injectable({
  providedIn: 'root'
})
export class ParkingSlotService {
    public readonly API: string = 'http://localhost:8080/parking-slot';
    public readonly API_SLOT_TYPE: string = 'http://localhost:8080/parking-slot/slot-type';

    constructor(
      public http: HttpClient
    ) {
    }

    getAllParkingLotService(): Observable<any> {
      return this.http.get(this.API + '/list');
    }

    getAllSlotType(): Observable<any> {
      return this.http.get(this.API_SLOT_TYPE);
    }

    createParkingLotService(parkingSlot): Observable<any> {
      return this.http.post(this.API + '/create', parkingSlot);
    }

    searchParkingLotFloorService(idSearch: any): Observable<any> {
      return this.http.get(this.API + '/search-floor/' + idSearch);
    }

    searchValidate(slotNumber, floorInput): Observable<any> {
      return this.http.get(this.API + '/find-parking-slot-by-slot-number-floor/' + slotNumber + '/' + floorInput);
    }

    validateId(): AsyncValidatorFn {
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
      console.log(text);
      return timer(100)
        .pipe(
          switchMap(() => {
            return this.http.get<any>(`${URL}/find-id/${text}`);
          })
        );
    }
  }
