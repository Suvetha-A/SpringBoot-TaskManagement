package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface task_repo extends JpaRepository<Task,Integer>{
	
	 @Query(value="SELECT * FROM task T where T.task_holder_name=?1",nativeQuery=true)
	 List<Task> findByHolderName(String name);
	 
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM task WHERE taskid = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "Update task s set s.taskid = ?1 ,s.task_holder_name=?2, s.task_date =?3 , s.task_name = ?4 , s.task_status=?5  where s.taskid = ?6 ", nativeQuery = true)
	 void changeTaskStatus(int id1,String name,String date,String taskname,String status,int id);

}




