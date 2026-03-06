import { Routes } from '@angular/router';
import { Accueil } from './common_pages/accueil/accueil';
import { Connexion } from './common_pages/connexion/connexion';
import { ControlPanel } from './common_pages/control-panel/control-panel';
import { StudyList } from './common_pages/pages/studies/study-list/study-list';
import { PatientList } from './common_pages/pages/patients/patient-list/patient-list';
import { VisitList } from './common_pages/pages/visits/visit-list/visit-list';
import { VitalSignList } from './common_pages/pages/vitalSigns/vital-sign-list/vital-sign-list';
import { CreatePatient } from './common_pages/pages/patients/create-patient/create-patient';
import { CreateStudy } from './common_pages/pages/studies/create-study/create-study';
import { UpdateStudy } from './common_pages/pages/studies/update-study/update-study';
import { UpdatePatient } from './common_pages/pages/patients/update-patient/update-patient';
import { CreateVisit } from './common_pages/pages/visits/create-visit/create-visit';
import { UpdateVisit } from './common_pages/pages/visits/update-visit/update-visit';
import { CreateVitalSign } from './common_pages/pages/vitalSigns/create-vital-sign/create-vital-sign';
import { UpdateVitalSign } from './common_pages/pages/vitalSigns/update-vital-sign/update-vital-sign';
import { PatientByStudy } from './common_pages/pages/patients/patient-by-study/patient-by-study';
import { VisitByPatient } from './common_pages/pages/visits/visit-by-patient/visit-by-patient';
import { VitalSignByVisit } from './common_pages/pages/vitalSigns/vital-sign-by-visit/vital-sign-by-visit';

export const routes: Routes = [

    { path: 'accueil', component: Accueil},
    { path: 'connexion', component: Connexion},
    { path: 'control-panel', component: ControlPanel },
    { path: 'studies', component: StudyList },
    { path: 'studies/create', component: CreateStudy },
    { path: 'studies/update/:id', component: UpdateStudy },
    { path: 'patients', component: PatientList },
    { path: 'patients/create', component: CreatePatient },
    { path: 'patients/update/:id', component: UpdatePatient },
    { path: 'patients/study/:studyId', component: PatientByStudy },
    { path: 'visits', component: VisitList },
    { path: 'visits/create', component: CreateVisit },
    { path: 'visits/update/:id', component: UpdateVisit },
    { path: 'visits/patient/:patientId', component: VisitByPatient },
    { path: 'vital-signs', component: VitalSignList },
    { path: 'vital-signs/create', component: CreateVitalSign },
    { path: 'vital-signs/update/:id', component: UpdateVitalSign },
    { path: 'vital-signs/visit/:visitId', component: VitalSignByVisit },
    { path: '**', redirectTo: 'accueil' }
];
