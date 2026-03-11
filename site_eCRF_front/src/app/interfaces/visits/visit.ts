import { Patient } from "../patients/patient";
import { Study } from "../studies/study";
import { VitalSign } from "../vitalsign/vitalSign";

export interface Visit {
  id: number;
  name: string;
  visitDate: string;
  patientId: number;
  subjectNumber: string;
  study: Study;
  vitalSigns?: VitalSign[];
}