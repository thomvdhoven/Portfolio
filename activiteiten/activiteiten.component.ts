import { InteressesService } from './../services/interesses.service';
import { Component, OnInit, Input } from '@angular/core';
import { ActiviteitenService } from '../services/activiteiten.service';

@Component({
  selector: 'app-activiteiten',
  templateUrl: './activiteiten.component.html',
  styleUrls: ['./activiteiten.component.css']
})
export class ActiviteitenComponent implements OnInit {

  @Input() amount: number;
  @Input() recommended: boolean;
  @Input() filter: boolean;
  activiteiten: any;
  interesses: any;
  isLoading;

  constructor(
    private activiteitService: ActiviteitenService,
    private interessesService: InteressesService
    ) { }

  ngOnInit(): void {
    this.isLoading = true;
    if (this.recommended) {
      this.activiteitService.getAllRecommended().subscribe(
        response => {
          this.activiteiten = response;
          this.isLoading = false;
        }
      );
    } else {
      this.activiteitService.getAllRecent().subscribe(
        response => {
          this.activiteiten = response;
          this.isLoading = false;
        }
      );
    }

    this.interessesService.getAll().subscribe(
      response => {
        this.interesses = response;
        this.isLoading = false;
      }
    );
  }

  setFilter(e) {
    this.activiteitService.getAllInteresse(e.interessenaam).subscribe(
      response => {
        this.activiteiten = response;
        this.isLoading = false;
        console.log(e);
        console.log(response);
      }
    );
  }

}
