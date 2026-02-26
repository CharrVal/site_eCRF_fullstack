import { Routes } from '@angular/router';
import { Accueil } from './common_pages/accueil/accueil';
import { Connexion } from './common_pages/connexion/connexion';
import { StudyList } from './common_pages/pages/studies/study-list/study-list';
import { CreateStudy } from './common_pages/pages/studies/create-study/create-study';

export const routes: Routes = [

    { path: "accueil", component: Accueil},
    { path: "connexion", component: Connexion},
    { path: "studies", component: StudyList},
    { path: "createStudy", component: CreateStudy }
];
