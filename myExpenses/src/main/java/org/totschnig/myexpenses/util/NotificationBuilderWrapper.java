package org.totschnig.myexpenses.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import org.totschnig.myexpenses.R;

public class NotificationBuilderWrapper {
  private Context context;
  private Notification.Builder api23Builder;
  private NotificationCompat.Builder compatBuilder;

  public NotificationBuilderWrapper(Context context) {
    this.context = context;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      this.api23Builder = new Notification.Builder(context);
    } else {
      this.compatBuilder = new NotificationCompat.Builder(context);
    }
  }

  public NotificationBuilderWrapper setSmallIcon(int smallIcon) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.setSmallIcon(smallIcon);
    } else {
      compatBuilder.setSmallIcon(smallIcon);
    }
    return this;
  }

  public NotificationBuilderWrapper setContentTitle(String title) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.setContentTitle(title);
    } else {
      compatBuilder.setContentTitle(title);
    }
    return this;
  }

  public NotificationBuilderWrapper setContentText(String content) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.setContentText(content);
    } else {
      compatBuilder.setContentText(content);
    }
    return this;
  }

  public NotificationBuilderWrapper setContentIntent(PendingIntent contentIntent) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.setContentIntent(contentIntent);
    } else {
      compatBuilder.setContentIntent(contentIntent);
    }
    return this;
  }

  public NotificationBuilderWrapper setAutoCancel(boolean autoCancel) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.setAutoCancel(autoCancel);
    } else {
      compatBuilder.setAutoCancel(autoCancel);
    }
    return this;
  }

  public NotificationBuilderWrapper addAction(int iconCompat, int iconApi23, String title, PendingIntent intent) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      api23Builder.addAction(new Notification.Action.Builder(
          Icon.createWithBitmap(Utils.getTintedBitmapForTheme(context, iconApi23, R.style.ThemeLight)),
          title, intent).build());
    } else {
      compatBuilder.addAction(iconCompat, title, intent);
    }
    return this;
  }

  public Notification build() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return api23Builder.build();
    } else {
      return compatBuilder.build();
    }
  }
}
