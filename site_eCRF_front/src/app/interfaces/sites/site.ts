import { Patient } from "../patients/patient";
import { Study } from "../studies/study";

export interface Site {
    id: number;
    name: string;
    startDate: string;
    endDate: string;
    study ?: Study;
    patients ?: Patient[]
}