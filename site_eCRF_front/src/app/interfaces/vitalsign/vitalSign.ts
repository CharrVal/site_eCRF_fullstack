export interface VitalSign {
    id: number;
    name: string;
    description: string;
    temperature: number;
    pulse: number;
    systolicPressure: number;
    diastolicPressure: number;
    weight: number;
    height: number;
}