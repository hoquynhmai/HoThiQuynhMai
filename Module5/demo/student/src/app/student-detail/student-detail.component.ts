import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {StudentInterface} from "../student/StudentInterface";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  studentChild: StudentInterface;

  @Output()
  changeMarkChild = new EventEmitter();
  mark: number;

  constructor() { }

  ngOnInit(): void {
  }

  changeMark(value: number) {
    this.studentChild.mark = value;
    this.changeMarkChild.emit(value);
  }
}
