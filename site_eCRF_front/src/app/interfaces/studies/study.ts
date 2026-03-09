import { Patient } from "../patients/patient";

export interface Study {
    id: number;
    name: string;
    description: string;
    patients?: Patient[];
}