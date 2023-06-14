import React from "react";
import {Link, NavLink} from 'react-router-dom'

const Navbar=()=>{
  // HomePage
  return(
    <div>
      <div>
        <NavLink to="/" activeClassName="active">E-Registrar Home</NavLink>
        <NavLink to="/students" activeClassName="active">Students</NavLink>
        <NavLink to="/add-student">Add New Student</NavLink>
      </div>
      <div>

      </div>
    </div>
  )
}
export default Navbar;