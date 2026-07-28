import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [],
  templateUrl: './notification.html',
  styleUrl: './notification.css',

  // Component-level provider creates a separate NotificationService
  // instance scoped to this component and its children.
  providers: [NotificationService]
})
export class Notification {

  constructor(private notificationService: NotificationService) {}

  notify(): void {
    this.notificationService.show('Notification service works!');
  }
}