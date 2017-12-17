package ru.delfserver.collector.entity;

import static android.arch.persistence.room.ForeignKey.CASCADE;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by delf on 12/16/17.
 */

@Entity(indices = {@Index("sms_filter_id")},
    foreignKeys = {
        @ForeignKey(entity = SmsFilter.class,
            parentColumns = "id",
            childColumns = "sms_filter_id",
            onDelete = CASCADE),
        @ForeignKey(entity = ExportChanel.class,
            parentColumns = "id",
            childColumns = "export_chanel_id",
            onDelete = CASCADE)
    })
public class SmsFilterDestination implements ru.delfserver.collector.entity.Entity {

  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "sms_filter_id")
  private final int smsFilterId;

  @ColumnInfo(name = "export_chanel_id")
  private final int exportChanelId;

  @ColumnInfo(name = "destination")
  private String destination;

  public SmsFilterDestination(int smsFilterId, int exportChanelId, String destination) {
    this.smsFilterId = smsFilterId;
    this.exportChanelId = exportChanelId;
    this.destination = destination;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSmsFilterId() {
    return smsFilterId;
  }

  public int getExportChanelId() {
    return exportChanelId;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }
}
