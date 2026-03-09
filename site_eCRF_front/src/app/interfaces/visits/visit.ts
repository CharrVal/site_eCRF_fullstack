import { VitalSign } from "../vitalsign/vitalSign";

export interface Visit {
    id: number;
  name: string;
  visitDate: string;
  subjectNumber?: number;
  vitalSigns?: VitalSign[];
}