import { Patient } from "../patients/patient";
import { User } from "../users/user";

export interface StudyRequest {
    name: string;
    description: string;
    user?: User;
    patients?: Patient[];
}