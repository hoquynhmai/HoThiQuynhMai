import {Component} from "@angular/core";

@Component({
  selector: "student",
  templateUrl: './student.component.html',
  styleUrls: ["./student.component.css"]
})

export class StudentComponent {
  name: string = "Hồ Quỳnh Mai";
  age: number = 1995;
  address: string = "Đà Nẵng";
}
