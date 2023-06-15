import React, {useState, useEffect } from 'react';
import axios from 'axios';
import StudentsDetails from '../StudentsDetail/StudentsDetails'
import { Link, useNavigate } from 'react-router-dom';

const StudentList=()=>{
  const [students, setStudents]=useState([]);
  // const [selectedStudent, setSelectedStudent]=useState(null);
  const navigate = useNavigate();

  useEffect(()=>{
    axios.get('http://localhost:9090/api/v1/students/')
    .then(response=>setStudents(response.data))
    .catch(error=>console.error('Error:',error));
  }, [])

  return(
    <div>
    <table>
      <thead>
      <tr>
        <th>Student Id</th>
        <th>Student Number</th>
        <th>Student FirstName</th>
        <th>Student MiddleName</th>
        <th>Student LastName</th>
        <th>Student CGPA</th>
        <th>Student Date Of Enrollment</th>
        <th>Is International</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
        {
      students.map(student=>(
        <tr key={student.studentId}>
          <td>{student.studentId}</td>
          <td>{student.studentNumber}</td>
          <td>{student.firstname}</td>
          <td>{student.middlename}</td>
          <td>{student.lastname}</td>
          <td>{student.cgpa}</td>
          <td>{student.dateOfEnrollment}</td>
          <td>{student.isInternational?"True":"False"}</td>
          <td><button onClick={()=>navigate(`/student/${student.studentId}`)}>View</button></td>
        </tr>
      ))
        }
      </tbody>
    </table>
    </div>
  )
};
export default StudentList;