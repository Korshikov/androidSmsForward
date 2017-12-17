package ru.delfserver.collector.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by delf on 12/16/17.
 */

@Entity
public class ExportChanel implements ru.delfserver.collector.entity.Entity {
  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "chanel_name")
  private String name;
/*
  *//** Chanel type
   * 0 - copy board, 1 - share with some app, 2 - telegram bot api
   *//*
  @ColumnInfo(name = "chanel_type")
  @TypeConverters(ChanelTypeConverter.class)
  private ChanelTypeEnum type;

  public enum ChanelTypeEnum {
    copyBoard(0),
    shareWith(1),
    telegramBotApi(2);

    private int code;

    ChanelTypeEnum(int code){
      this.code = code;
    }

    public int getCode() {
      return code;
    }
  }

  public static class ChanelTypeConverter {

    @TypeConverter
    public static ExportChanel.ChanelTypeEnum toType(int type) {
      if (type == ChanelTypeEnum.copyBoard.getCode()) {
        return ChanelTypeEnum.copyBoard;
      } else if (type == ChanelTypeEnum.shareWith.getCode()) {
        return ChanelTypeEnum.shareWith;
      } else if (type == ChanelTypeEnum.telegramBotApi.getCode()) {
        return ChanelTypeEnum.telegramBotApi;
      } else {
        throw new IllegalArgumentException("Could not recognize type");
      }
    }

    @TypeConverter
    public static Integer toInteger(ChanelTypeEnum type) {
      return type.getCode();
    }
  }*/

  public ExportChanel(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
