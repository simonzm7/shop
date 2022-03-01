import { INPUT_PATTERN } from "./input-pattern";

describe('InputPatter', () => {

    it('should be falsy if have email format is correct', () => {
        const email: string = 'email';
        expect(new RegExp(INPUT_PATTERN.email).test(email)).toBeFalsy();
    });

    it('should be truthy if have email format is correct', () => {
        const email: string = 'email@email.com';
        expect(new RegExp(INPUT_PATTERN.email).test(email)).toBeTruthy();
    });

    it('should be falsy if have name format is correct', () => {
        const name: string = '123';
        expect(new RegExp(INPUT_PATTERN.name).test(name)).toBeFalsy();
    });

    it('should be truthy if have email format is correct', () => {
        const name: string = 'name';
        expect(new RegExp(INPUT_PATTERN.name).test(name)).toBeTruthy();
    });

    it('should be falsy if have name format is correct', () => {
        const number: string = 'number';
        expect(new RegExp(INPUT_PATTERN.numeric).test(number)).toBeFalsy();
    });

    it('should be truthy if have email format is correct', () => {
        const number: string = '1234567890';
        expect(new RegExp(INPUT_PATTERN.numeric).test(number)).toBeTruthy();
    });


    it('should be falsy if have name format is correct', () => {
        const number: string = 'number';
        expect(new RegExp(INPUT_PATTERN.numericWithDecimal).test(number)).toBeFalsy();
    });

    it('should be truthy if have email format is correct', () => {
        const number: string = '1234567890.1';
        expect(new RegExp(INPUT_PATTERN.numericWithDecimal).test(number)).toBeTruthy();
    });
});