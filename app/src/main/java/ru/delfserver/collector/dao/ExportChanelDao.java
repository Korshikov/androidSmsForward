package ru.delfserver.collector.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
import ru.delfserver.collector.entity.ExportChanel;

/**
 * Created by delf on 12/16/17.
 */

@Dao
public interface ExportChanelDao {
  @Query("SELECT * FROM ExportChanel")
  List<ExportChanel> getExportChanels();

  @Query("SELECT * FROM ExportChanel WHERE id IN (:ids)")
  List<ExportChanel> getChanelByIds(int... ids);

  @Query("SELECT * FROM ExportChanel WHERE id = :id")
  ExportChanel getChanelById(int id);

  @Insert
  void insertChannels(ExportChanel... channels);

  @Update
  void updateChannels(ExportChanel... channels);

  @Delete
  void deleteChanel(ExportChanel... channels);


}
