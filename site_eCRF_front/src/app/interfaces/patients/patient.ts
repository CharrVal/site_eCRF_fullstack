import { Visit } from "../visits/visit";

export interface Patient {
    id:number;
    subjectNumber:number;
    visits:Visit[];
}