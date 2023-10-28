import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecurityInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(localStorage.getItem('currentUser')) {
      const currentUser = localStorage.getItem('currentUser') as string;
      const bearerToken = "Bearer " + JSON.parse(currentUser).token
      req = req.clone({
        setHeaders: { 
            Authorization: bearerToken
        }
      })
    }

    console.log(localStorage.getItem('currentUser'));

    return next.handle(req);
  }
}
