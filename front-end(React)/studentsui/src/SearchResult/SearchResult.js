import { useEffect, useState } from "react"
import { useLocation } from "react-router-dom";
import queryString from "query-string"
import axios from "axios";
//npm install query-string
const SearchResults=()=>{
  const [results, setReslts]= useState([]);
  const location = useLocation();
  const {firstname} = queryString.parse(location.search);
  useEffect(()=>{
    axios.get(`http://localhost:9090/api/v1/students/search?firstname=${firstname}`)
    .then((response)=>setReslts(response.data))
    .catch((error)=>console.error("Error:",error));
  },[firstname]);
  return(
    <div>
      <h1>Search Results</h1>
      {results.map((student)=>(
        <div key={student.studentId}>
          <p>Student Id: {student.studentId}</p>
          <p>Student Number: {student.studentNumber}</p> 
          <p>Student FirstName:{student.firstname}</p>
          <p>Student MiddleName: {student.middlename}</p>
          <p>Student LastName: {student.lastname}</p>
          <p>Student CGPA: {student.cgpa}</p>
          <p>Student Date Of Enrollment: {student.dateOfEnrollment}</p>
          <p>Is International: {student.isInternational?"True":"False"}</p>
          </div>
      ))}
    </div>
  )
}

export default SearchResults;

// import React, { useEffect, useState } from 'react';
// import { useLocation } from 'react-router-dom';
// import axios from 'axios';

// function useQuery() {
//   return new URLSearchParams(useLocation().search);
// }

// const SearchResults = () => {
//   const query = useQuery();
//   const [students, setStudents] = useState([]);
//   const firstname = query.get("firstname");

//   useEffect(() => {
//     axios.get(`http://localhost:9090/api/v1/students/search?firstname=${firstname}`)
//       .then(response => setStudents(response.data))
//       .catch(error => console.error('Error:', error));
//   }, [firstname]);

//   return (
//     <div>
//       <h1>Search Results</h1>
//       {students.map(student => (
//         <div key={student.studentId}>

//           <p>Student Id: {student.studentId}</p>
//           <p>Student Number: {student.studentNumber}</p>
//           <p>Student FirstName:{student.firstname}</p>
//           <p>Student MiddleName: {student.middlename}</p>
//           <p>Student LastName: {student.lastname}</p>
//           <p>Student CGPA: {student.cgpa}</p>
//           <p>Student Date Of Enrollment: {student.dateOfEnrollment}</p>
//           <p>Is International: {student.isInternational ? "True" : "False"}</p>
//         </div>
//       ))}
//     </div>
//   );
// };

// export default SearchResults;
