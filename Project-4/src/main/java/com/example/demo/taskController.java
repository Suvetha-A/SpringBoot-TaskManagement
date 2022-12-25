package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class taskController {
	
	@Autowired task_repo ob;

	@PostMapping("/save")
	public String saveTask(@RequestBody Task task)
	{
		Task a= new Task();
		
		int id= task.getTaskid() ;
		String name = task.getTaskHolderName();
		String date=task.getTaskDate();
		String tname =task.getTaskName();
		String status= task.getTaskStatus();
		
		a.setTaskid(id);
		a.setTaskHolderName(name);
		a.setTaskDate(date);
		a.setTaskName(tname);
		a.setTaskStatus(status);
		Task first = new Task(id,name,date,tname,status);
		ob.save(first);
		
		return "Added successfully";

		}
	@GetMapping("/getTasks")
    public List<Task> getAllTask()
    {

        return ob.findAll();

    }
	
	 @GetMapping("/getTask/{name}")
		public List<Task> getTaskByTaskHolderName(@PathVariable("name") String name)   
		{  
			return ob.findByHolderName(name);  
		}
		
			
		@PutMapping("/changeStatus/{id}")
		public String changeTaskStatus(@RequestBody Task T,@PathVariable("id") int id)
	    {
			int id1= T.getTaskid() ;
			String name = T.getTaskHolderName();
			String date= T.getTaskDate();
			String taskName = T.getTaskName() ;
			String status= T.getTaskStatus();
		
			ob.changeTaskStatus(id1,name,date,taskName,status,id);
				 
			return "successfully updated";
	}

		
		@DeleteMapping("delete/{id}")
	    public String deleteById(@PathVariable("id") int id)
	    {
		 
			ob.deleteAllByIdInBatch(id);
			
			return "deleted successfully";
	}
}
