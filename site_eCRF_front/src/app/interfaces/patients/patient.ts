import { Site } from "../sites/site";
import { Visit } from "../visits/visit";

export interface Patient {
    id:number;
    subjectNumber:number;
    studyName?: string;
    site?: Site;
    visits?: Visit[];
}