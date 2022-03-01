import { Directive, Input } from "@angular/core";
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from "@angular/forms";
import { isLessThanValidator } from "../validator/is-less-than-validator";


const MIN_USD: number = 5;
@Directive({
    selector: '[isLessThan]',
    providers: [{provide: NG_VALIDATORS, useExisting: IsLessThanValidatorDirective, multi: true}]
  })
  export class IsLessThanValidatorDirective implements Validator {
    @Input('isLessThan') isLessThan: string = '';
  
    validate(control: AbstractControl): ValidationErrors | null {
      return Number(this.isLessThan) != 0 ? isLessThanValidator(MIN_USD)(control) : null;
    }
  }