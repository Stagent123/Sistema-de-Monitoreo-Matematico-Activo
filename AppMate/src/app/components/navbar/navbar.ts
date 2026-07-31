import { Component,EventEmitter,Output, Input } from '@angular/core';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar 
{
  @Input() isSidebarCollapsed = false;
  @Output() augmentToggle = new EventEmitter<void>();

  augmentNavbar(){
    this.augmentToggle.emit();
  }

  toggleaugmment() {
    if 
  }
}
