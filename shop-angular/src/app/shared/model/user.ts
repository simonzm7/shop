import { Balance } from "./balance";

export interface User {
    id: BigInt;
    countryId: number;
    name: string;
    email: string;
    balance: Balance;
}