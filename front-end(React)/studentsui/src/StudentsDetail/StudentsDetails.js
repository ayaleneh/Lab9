import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom" 

const StudentDetails =()=>{
  const {studentId}= useParams();
  const [student, setStudent]= useState(null);
  const navigate = useNavigate(); 

  useEffect(()=>{
    axios.get(`http://localhost:9090/api/v1/students/${studentId}`)
    .then(response=>setStudent(response.data))
    .catch(error=>console.error('Error:'.error))
  },[studentId]);

  if(!student) return null;

  return(
    <div>
      <h2>Student Details</h2>
      <p>Student Id: {student.studentId}</p>
      <p>Student Number: {student.studentNumber}</p>
      <p>Student FirstName: {student.firstname}</p>
      <p>Student MiddleName: {student.middlename}</p>
      <p>Student LastName: {student.lastname}</p>
      <p>CGPA: {student.cgpa}</p>
      <p>Date of Enrollment: {student.dateOfEnrollment}</p>
      <p>Is International: {student.isInternational?"True":"False"}</p>
      <button onClick={()=>navigate(`/edit-student/${student.studentId}`)}>Edit</button>

      <button onClick={()=>{
        axios.delete(`http://localhost:9090/api/v1/students/${student.studentId}`)
        .then(response=>{
          console.log(response.data);
          alert("Deleted Successfully");
          navigate("/"); // Use navigate function to redirect
        })
        .catch(error=> console.error('Error:',error))
      }}>Delete</button>
    </div>
  )
}

export default StudentDetails;
