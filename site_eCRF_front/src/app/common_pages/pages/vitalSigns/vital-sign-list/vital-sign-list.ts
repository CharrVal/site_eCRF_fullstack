import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { VitalSign } from '../../../../interfaces/vitalsign/vitalSign';
import { VitalSignService } from '../../../../services/vitalSigns/vital-sign-service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-vital-sign-list',
  imports: [RouterModule],
  templateUrl: './vital-sign-list.html',
  styleUrl: './vital-sign-list.css',
})
export class VitalSignList implements OnInit {

  vitalSigns: VitalSign[] = [];
  errorMessage: string | null = null;

  constructor(private vitalSignService: VitalSignService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadVitalSigns();
  }

  loadVitalSigns(): void {
    this.vitalSignService.getAll().subscribe({
      next: data => {
        this.vitalSigns = data;
        this.cdr.markForCheck();
      },
      error: err => {
        this.errorMessage = 'Erreur lors du chargement des signes vitaux';
        console.error(err);
      }
    });
  }

  deleteVitalSign(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer ce signe vital ?')) {
      this.vitalSignService.delete(id).subscribe({
        next: () => this.loadVitalSigns(),
        error: err => console.error(err)
      });
    }
  }
}
