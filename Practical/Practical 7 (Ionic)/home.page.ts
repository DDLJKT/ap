import { Component } from '@angular/core';
import { InfiniteScrollCustomEvent } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  student: any = {
    id:"",
    name:"",
    address:"",
    gender:"",
    city:"",
    phone:"",
    email:"",

    display1:"",
    display2:"",
    display3:"",
    display4:"",
    display5:"",
    display6:"",
    display7:""
  }
  constructor() {}

  onRegister() {
    this.student.display1 = this.student.id;
    this.student.display2 = this.student.name;
    this.student.display3 = this.student.gender;
    this.student.display4 = this.student.city;
    this.student.display5 = this.student.phone;
    this.student.display6 = this.student.email;
    this.student.display7 = this.student.address;
  }
}
