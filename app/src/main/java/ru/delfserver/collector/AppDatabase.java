package ru.delfserver.collector;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import ru.delfserver.collector.dao.ExportChanelDao;
import ru.delfserver.collector.dao.SmsFilterDao;
import ru.delfserver.collector.dao.SmsFilterDestinationDao;
import ru.delfserver.collector.entity.ExportChanel;
import ru.delfserver.collector.entity.SmsFilter;
import ru.delfserver.collector.entity.SmsFilterDestination;

/**
 * Created by delf on 12/16/17.
 */

@Database(entities = {SmsFilter.class, ExportChanel.class, SmsFilterDestination.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

  private static volatile AppDatabase instance;

  public static AppDatabase getInstance(Context context) {
    AppDatabase localInstance = instance;
    if (localInstance == null) {
      synchronized (AppDatabase.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = Room.databaseBuilder(context,
              AppDatabase.class, "collector-database").build();
        }
      }
    }
    return localInstance;
  }

  public abstract SmsFilterDao smsFilterDao();
  public abstract ExportChanelDao exportChanelDao();
  public abstract SmsFilterDestinationDao smsFilterDestinationDao();
}
