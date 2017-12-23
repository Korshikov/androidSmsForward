package ru.delfserver.collector.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import ru.delfserver.collector.entity.SmsFilterDestination;

/**
 * Created by delf on 12/16/17.
 */

@Dao
public interface SmsFilterDestinationDao {
  @Query("SELECT * FROM SmsFilterDestination WHERE sms_filter_id = :filter_id")
  List<SmsFilterDestination> getSmsFilterDestinations(int filter_id);

  @Insert
  void insertSmsFilterDestinations(SmsFilterDestination... destinations);

  @Delete
  void deleteSmsFilterDestination(int... ids);

  @Delete
  void deleteSmsFilterDestination(int id);


}
