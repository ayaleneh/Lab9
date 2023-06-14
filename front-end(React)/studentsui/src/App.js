import logo from './logo.svg';
import './App.css';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import StudentList from './Students/StudentList';
import StudentsDetails from './StudentsDetail/StudentsDetails';
import StudentForm from './AddStudent/StudentForm';

function App() {
  return (
  <Router>
    <Navbar/>
    <Routes>
      <Route path='/students' element={<StudentList/>}/>
      <Route path='/student/:studentId' element={<StudentsDetails />}/>
      <Route path='/edit-student/:studentId' element={<StudentForm/>}/>
      <Route path='/add-student' element={<StudentForm />}/>
    </Routes>
  </Router>
  );
}

export default App;
