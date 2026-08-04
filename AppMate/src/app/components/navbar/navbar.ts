import { Component,EventEmitter,Output, Input } from '@angular/core';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-navbar',
  imports: [NgClass],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar 
{
  @Input() isSidebarCollapsed = false;
}