import { Injectable } from "@angular/core";
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class SlideShowService {
    product = new BehaviorSubject<any>({});
    selectedProduct = this.product.asObservable();

    constructor() {}
}