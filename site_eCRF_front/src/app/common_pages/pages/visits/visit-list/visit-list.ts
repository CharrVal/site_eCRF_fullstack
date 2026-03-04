import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Visit } from '../../../../interfaces/visits/visit';
import { VisitService } from '../../../../services/visits/visit-service';

@Component({
  selector: 'app-visit-list',
  imports: [],
  templateUrl: './visit-list.html',
  styleUrl: './visit-list.css',
})
export class VisitList implements OnInit {

  visits: Visit[] = [];
  errorMessage: string | null = "";

  constructor(private visitService: VisitService, private cdr: ChangeDetectorRef){}
  
  ngOnInit(): void {
    this.loadVisits();
  }

  loadVisits() {
    this.visitService.getVisit().subscribe({
      next: (data) => {
        this.visits = data;
        this.cdr.markForCheck();
      },
      error: (err) => {
        this.errorMessage = 'Erreur lors du chargement des visites';
        console.error(err);
        this.cdr.markForCheck();
      }
    });
  }
}