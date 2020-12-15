package com.solutions.datamart.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.solutions.datamart.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query(value = "Select * FROM record order by created_date desc limit 100", nativeQuery = true)
	public List<Record> getAllNews();

	@Query(value = "Select * FROM record WHERE (title like :content OR description like :content) order by created_date desc limit 100", nativeQuery = true)
	public List<Record> getAllNewsByContent(@Param("content") String content);

	@Query(value = "Select * FROM record WHERE created_date > :fromDate and created_date < :toDate order by created_date desc limit 100", nativeQuery = true)
	public List<Record> getAllNewsByDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "Select * FROM record WHERE (title like :content OR description like :content) AND created_date > :fromDate and created_date < :toDate order by created_dt desc limit 100", nativeQuery = true)
	public List<Record> getAllNewsByContentAndDate(@Param("content") String content, @Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate);

}
