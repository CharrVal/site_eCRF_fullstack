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
  errorMessage: string | null = null;

  constructor(private visitService: VisitService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadVisits();
  }

  loadVisits(): void {
    this.visitService.getAll().subscribe({
      next: data => {
        this.visits = data;
        this.cdr.markForCheck();
      },
      error: err => {
        this.errorMessage = 'Erreur lors du chargement des visites';
        console.error(err);
      }
    });
  }

  deleteVisit(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer cette visite ?')) {
      this.visitService.delete(id).subscribe({
        next: () => this.loadVisits(),
        error: err => console.error(err)
      });
    }
  }
}