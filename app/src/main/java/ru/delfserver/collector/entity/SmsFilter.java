package ru.delfserver.collector.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by delf on 12/16/17.
 */

@Entity
public class SmsFilter implements ru.delfserver.collector.entity.Entity {
  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "pattern_from")
  private String patternFrom;

  @ColumnInfo(name = "pattern_to")
  private String patternTo;

  @ColumnInfo(name = "pattern_text")
  private String patternText;

  @ColumnInfo(name = "pattern_result_text")
  private String patternResultText;

  public SmsFilter(String patternFrom, String patternTo, String patternText,
      String patternResultText) {
    this.patternFrom = patternFrom;
    this.patternTo = patternTo;
    this.patternText = patternText;
    this.patternResultText = patternResultText;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPatternFrom() {
    return patternFrom;
  }

  public void setPatternFrom(String patternFrom) {
    this.patternFrom = patternFrom;
  }

  public String getPatternTo() {
    return patternTo;
  }

  public void setPatternTo(String patternTo) {
    this.patternTo = patternTo;
  }

  public String getPatternText() {
    return patternText;
  }

  public void setPatternText(String patternText) {
    this.patternText = patternText;
  }

  public String getPatternResultText() {
    return patternResultText;
  }

  public void setPatternResultText(String patternResultText) {
    this.patternResultText = patternResultText;
  }
}
