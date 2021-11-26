import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public type !: string | null

  regForm = new FormGroup({
    name: new FormControl('',
      [
        Validators.required
      ]
    ),
    email: new FormControl('',
      [
        Validators.required,
        Validators.email
      ]
    ),
    password: new FormControl('',
      [
        Validators.required,
        Validators.minLength(6)
      ]
    )
  })
  get f() { return this.regForm.controls; }

  constructor(private route: ActivatedRoute, private regService: RegisterService) { }

  ngOnInit(): void {
    this.type = this.route.snapshot.paramMap.get('type')
    console.log(this.type);
  }

  onRegister() {
    if (this.regForm.valid) {
      if (this.type === 'doctor') {
        let doc = {
          'password': this.regForm.value.password,
          'doctor': {
            'eMail': this.regForm.value.email,
            'drName': this.regForm.value.name
          }
        }
        this.regService.addDoc(doc).subscribe(
          res => {
            console.log(res);
          }
        )
      } else if (this.type === 'patient') {
        let pat = {
          'password': this.regForm.value.password,
          'patient': {
            'eMail': this.regForm.value.email,
            'name': this.regForm.value.name
          }
        }
        this.regService.patDoc(pat).subscribe(
          res => {
            console.log(res);

          }
        )
      }

    }

  }
}
