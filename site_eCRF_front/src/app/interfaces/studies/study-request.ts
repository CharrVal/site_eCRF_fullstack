import { Patient } from "../patients/patient";

export interface StudyRequest {
    name: string;
    description: string;
    patients?: Patient[];
}