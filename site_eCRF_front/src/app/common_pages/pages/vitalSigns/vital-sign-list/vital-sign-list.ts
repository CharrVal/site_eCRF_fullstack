import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { VitalSign } from '../../../../interfaces/vitalsign/vitalSign';
import { VitalSignService } from '../../../../services/vitalSigns/vital-sign-service';

@Component({
  selector: 'app-vital-sign-list',
  imports: [],
  templateUrl: './vital-sign-list.html',
  styleUrl: './vital-sign-list.css',
})
export class VitalSignList implements OnInit {

  vitalSigns: VitalSign[] = [];
  errorMessage: string | null = "";

  constructor(private vitalSignService: VitalSignService, private cdr: ChangeDetectorRef){}
  
  ngOnInit(): void {
    this.loadVitalSigns();
  }

  loadVitalSigns() {
    this.vitalSignService.getVisit().subscribe({
      next: (data) => {
        this.vitalSigns = data;
        this.cdr.markForCheck();
      },
      error: (err) => {
        this.errorMessage = 'Erreur lors du chargement des signes vitaux';
        console.error(err);
        this.cdr.markForCheck();
      }
    });
  }


}
