import { Role } from "../roles/role";
import { Study } from "../studies/study";

export interface User {
    id:number;
    username:string;
    role: Role;
    studies?: Study[]
}