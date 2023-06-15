import React, { useState } from "react";
import {Link, NavLink, useNavigate} from 'react-router-dom'
// starting from V6 useHistory replaced by useNavigate()
const Navbar=()=>{
  // HomePage
  const [search, setSearch]= useState("");
  const navigate= useNavigate();
  const handleSubmit=(e)=>{
    e.preventDefault();
    navigate(`/search?firstname=${search}`);
  }
  return(
    <div>
      <div>
        <NavLink to="/" activeClassName="active">E-Registrar Home</NavLink>
        <NavLink to="/students" activeClassName="active">Students</NavLink>
        <NavLink to="/add-student">Add New Student</NavLink>
      </div>

      <div>
      <h1>Home Page</h1>
      <form onSubmit={handleSubmit}>
        <input 
        type="text"
        placeholder="Search by first name"
        value={search}
        onChange={(e)=>setSearch(e.target.value)}
        />
       <button type="submit">Search</button>
      </form>
      </div>
      <div>

      </div>
    </div>
  )
}
export default Navbar;