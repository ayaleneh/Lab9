import axios from "axios";
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom";

const StudentForm=()=>{

  const { studentId }= useParams();
  const isEditing = !!studentId; //isEditing will be true when studentId has a value, indicating that we are in "edit mode", and false when studentId doesn't have a value, indicating that we are in "add mode".
  const navigate= useNavigate();

  const [student, setStudent]= useState({
    studentNumber:"",
    firstname:"",
    middlename:"",
    lastname:"",
    cgpa:"",
    dateOfEnrollment:"",
    isInternational:false,
  });

  useEffect(()=>{
  if(isEditing){
    axios.get(`http://localhost:9090/api/v1/students/${studentId}`)
    .then(response=>setStudent(response.data)) //data binding happen here, so when i try to edit student it will bring the data to be edited
    .catch(error=>console.error("Error:", error));
  }
  },[isEditing,studentId]);


  const handleChange=(e)=>{
    setStudent({...student,[e.target.name]: e.target.value })
    }

  const handleSubmit=(e)=>{
    e.preventDefault();
    const apiCall= isEditing?axios.put(`http://localhost:9090/api/v1/students/${studentId}`, student)
    :axios.post("http://localhost:9090/api/v1/students/", student);

    apiCall
    .then(response=>{
      alert(isEditing? "Student updated Successfully":"Student added Successfully");
      navigate("/students")
    })
    .catch(error=>console.error("Error:",error));

  }
 

  return(
    <form onSubmit={handleSubmit}>
      <fieldset>
      <label>
        Student Number:
        <input type="text" name="studentNumber" onChange={handleChange} value={student.studentNumber}/>
      </label>

      <label>
        FirstName:
        <input type="text" name="firstname" onChange={handleChange} value={student.firstname}/>
      </label>

      <label>
        MiddleName:
        <input type="text" name="middlename" onChange={handleChange} value={student.middlename}/>
      </label>

      <label>
        LastName:
        <input type="text" name="lastname" onChange={handleChange} value={student.lastname}/>
      </label>

      <label>
        CGPA:
        <input type="text" name="cgpa" onChange={handleChange} value={student.cgpa}/>
      </label>

      <label>
        Date Of Enrollment:
        <input type="date" name="dateOfEnrollment" onChange={handleChange} value={student.dateOfEnrollment}/>
      </label>
      <label>
        Is International:
        <input type="checkbox" name="isInternational" onChange={e=>setStudent({...student, isInternational:e.target.checked})} checked={student.isInternational} />
      </label>
      <button type="submit">Submit</button>
      </fieldset>
    </form>
  )
}

export default StudentForm;