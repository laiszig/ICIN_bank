import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AutheticationService } from '../authetication.service';

@Component({
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null,
    role: null,
  };
    loading = false;
    submitted = false;
    isSuccessful=false
    isSignUpFailed = false;
    errorMessage = "";

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AutheticationService,
    ) {

    }

    ngOnInit() {
    }



    onSubmit() {
        this.submitted = true;

        console.log(this.form)

        this.loading = true;
        this.authenticationService.login(this.form.username, this.form.password)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate(["/"]);
                },
                error => {
 
                    this.loading = false;
                });
    }

    // login() {
    //     this.authenticationService.login(this.email, this.password).subscribe((response: any) => {
    //             this.authenticationService.getAccountData().subscribe((res: any) => {
    //                 this.authority = res.authorities[0]; // role
    //                 this.sharedService.setUserRole(this.authority);
    //                 if (this.authority === Role.ADMIN_ROLE) {
    //                     this.router.navigate(['admin/home']);
    //                 } else if (this.authority === Role.USER_ROLE) {
    //                     this.router.navigate(['user/home']);
    //                 } 
    //             });
            
    //     });
//  }
    
}
