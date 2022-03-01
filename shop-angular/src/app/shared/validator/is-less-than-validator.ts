import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export function isLessThanValidator(minimum: number): ValidatorFn{
    return (control: AbstractControl): ValidationErrors | null => {
        const isLessThan = Number(control.value) < minimum;
        return isLessThan ? {isLessThan: {value: control.value}} : null;
      };
}