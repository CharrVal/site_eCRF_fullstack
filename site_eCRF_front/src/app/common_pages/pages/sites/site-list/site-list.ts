import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Site } from '../../../../interfaces/sites/site';
import { SiteService } from '../../../../services/sites/site-service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-site-list',
  imports: [RouterModule],
  templateUrl: './site-list.html',
  styleUrl: './site-list.css',
})
export class SiteList implements OnInit {

  sites: Site[] = [];
  errorMessage: string | null = "";

  constructor(private siteService: SiteService, private cdr: ChangeDetectorRef, private router: Router) {}

  ngOnInit(): void {
    this.loadSites();
  }

  loadSites(): void {
    this.siteService.getAll().subscribe({
      next: (data) => {
        this.sites = data;
        this.cdr.markForCheck();
      },
      error: (err) => {
        this.errorMessage = 'Erreur lors du chargement des sites';
        console.error(err);
        this.cdr.markForCheck();
      }
    });
  }

  deleteSite(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer ce site ?')) {
      this.siteService.deleteSite(id).subscribe({
        next: () => this.loadSites(),
        error: err => console.error(err)
      });
    }
  }
}
