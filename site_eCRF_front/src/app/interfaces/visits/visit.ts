import { VitalSign } from "../vitalsign/vitalSign";

export interface Visit {
    id:number;

    name:string;
    date:string;
    vitalSign:VitalSign;
}