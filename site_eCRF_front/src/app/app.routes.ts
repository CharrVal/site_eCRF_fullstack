import { Routes } from '@angular/router';
import { Accueil } from './common_pages/accueil/accueil';
import { Connexion } from './common_pages/connexion/connexion';
import { StudyList } from './common_pages/pages/studies/study-list/study-list';
import { PatientList } from './common_pages/pages/patients/patient-list/patient-list';
import { VisitList } from './common_pages/pages/visits/visit-list/visit-list';
import { VitalSignList } from './common_pages/pages/vitalSigns/vital-sign-list/vital-sign-list';

export const routes: Routes = [

    { path: "accueil", component: Accueil},
    { path: "connexion", component: Connexion},
    { path: "studies", component: StudyList},
    { path: 'studies/:studyId/patients', component: PatientList },
    { path: 'patients/:patientId/visits', component: VisitList },
    { path: 'visits/:visitId/vital-signs', component: VitalSignList },
];
