import { VitalSignType } from "../vitalSignType/vitalSigntype";

export interface VitalSign {
  id: number;
  type: VitalSignType;  // enum côté Angular pour sécurité de type
  value: number;
  unit: string;
  measuredAt: string;   // ISO string renvoyée par Spring
  visitId?: number; 
}