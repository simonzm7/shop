type CodeStatus = {
    [key: number]: string
}
export const HTTP_STATUS_CODE: CodeStatus = {
    400: 'The server cannot process the request due to a client syntax error.',
    403: 'Access denied.',
    404: 'Request not found.',
    405: 'A request has been made with a resource not supported by that resource (GET, POST, PUT, DELETE).',
    500: 'Unexpected server error.',
    501: 'The server either does not recognize the request method or lacks the ability to complete it.',
    503: 'The server is not available.',
    504: 'The timeout for the request has been exceeded.',
};

export const LOCAL_STATUS_CODE = {
        NO_HAY_INTERNET: 'No internet connection detected.',
    PETICION_FALLIDA: 'Unexpected error in the request',
}