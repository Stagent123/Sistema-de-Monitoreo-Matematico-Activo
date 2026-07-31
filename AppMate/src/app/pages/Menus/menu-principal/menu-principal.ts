import { Component } from '@angular/core';
import { Navbar } from "../../../components/navbar/navbar";
import { SideBar } from "../../../components/side-bar/side-bar";
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-menu-principal',
  imports: [SideBar,NgClass,Navbar],
  templateUrl: './menu-principal.html',
  styleUrl: './menu-principal.css',
})
export class MenuPrincipal {
  isSidebarCollapsed = false;

  onSidebarToggle() {
    this.isSidebarCollapsed = !this.isSidebarCollapsed;
  }
}