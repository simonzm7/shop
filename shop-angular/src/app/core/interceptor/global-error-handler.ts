import { HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HTTP_STATUS_CODE, LOCAL_STATUS_CODE } from './http-status-code';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
  constructor() {}

  handleError(error: string | Error): void {
    const errorMessage: string | Error  = this.defaultMessage(error);
    this.printOnConsole(errorMessage);
  }

  private defaultMessage(error: string | Error): string | Error {
    if (error instanceof HttpErrorResponse) {
      if (!navigator.onLine) {
        return LOCAL_STATUS_CODE.NO_HAY_INTERNET;
      }
      if (error.hasOwnProperty('status') && !error.error.hasOwnProperty('message')) {
        return this.getHttpStatusCodeValue(error.status);
      }
    }
    return error;
  }

  private printOnConsole(message: string | Error): void {
    const response = {
      timestamp: new Date().toLocaleString(),
      path: window.location.href,
      message,
    };
    if (!environment.production) {
      window.console.error('Unexpected Error:\n', response);
    }
  }

  public getHttpStatusCodeValue(httpCode: number): string {
    if (HTTP_STATUS_CODE.hasOwnProperty(httpCode)) {
      return HTTP_STATUS_CODE[httpCode];
    }
    return LOCAL_STATUS_CODE.PETICION_FALLIDA;
  }
}
