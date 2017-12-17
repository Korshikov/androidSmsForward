package ru.delfserver.collector;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import java.util.Objects;


/**
 * Created by delf on 12/10/17.
 */

public class SmsListener extends BroadcastReceiver {

  public static final CharSequence clipLabel = "Collector sms";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Objects.equals(intent.getAction(), "android.provider.Telephony.SMS_RECEIVED")) {
      Bundle bundle = intent.getExtras();
      SmsMessage[] msgs;
      if (bundle != null) {
        {
          Object[] pdus = (Object[]) bundle.get("pdus");
          msgs = new SmsMessage[pdus.length];
          String wholeString = "";
          for (int i = 0; i < msgs.length; i++) {
            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            wholeString += msgs[i].getMessageBody();
          }
          ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
          assert clipboardManager != null;
          clipboardManager.setPrimaryClip(ClipData.newPlainText(clipLabel,wholeString));
        }
      }
    }
  }
}